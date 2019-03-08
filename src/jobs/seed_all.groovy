#!groovy
//def ftp_app_names = [ "app1", "app2", "app3", "app4", "app5", "app6", "app7", "app8", "app9", "app10" ]

for( jobName in jobConfig.ftp_app_names ) {
  if(jobName == "app1"){
    job("GeneratedJobs/Job-DSL-Test-${jobName}") {
        scm {
          git('git://github.com/quidryan/aws-sdk-test.git')
        }
        triggers {
          githubPush()
        }
        steps {
          maven('clean test')
        }
    }
  } else {
    job("GeneratedJobs/Job-DSL-Test-${jobName}") {
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
}
