#!groovy

// def jobConfig = [:]
// def jobConfigText = libraryResource("ftb_job_names.yaml")

// jobConfig = readYaml text: "${jobConfigText}"

// if( !jobConfig?.ftp_app_names ){
//   error "not able to read yaml file"
// }

def ftp_app_names = [ "app1", "app2", "app3", "app4", "app5", "app6", "app7", "app8", "app9", "app10" ]

for( jobName in ftp_app_names ) {
  job('GeneratedJobs/Job-DSL-Test-1') {
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
