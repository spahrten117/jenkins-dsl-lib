#!groovy
def lib = library("jenkins-dsl")
def jobConfig = [:]
def jobConfigText = libraryResource("ftb_job_names.yaml")

jobConfig = readYaml text: "${jobConfigText}"

if( !jobConfig?.ftp_app_names ){
  error "not able to read yaml file"
}

for( jobName in jobConfig.ftp_app_names ) {
  job('GeneratedJobs/Job-DSL-Test-${jobName}') {
  	scm {
      	git('git://github.com/quidryan/aws-sdk-test.git')
      }
      triggers {
      	scm('H/15 * * * *')
      }
      steps {
      	maven('-e clean test')
      }
  }
}
