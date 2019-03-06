job('GeneratedJobs/New_Job_with_Git_Groovy-1') {
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

job('GeneratedJobs/New_Job_with_Git_Groovy-2') {
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
