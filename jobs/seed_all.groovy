#!groovy

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
