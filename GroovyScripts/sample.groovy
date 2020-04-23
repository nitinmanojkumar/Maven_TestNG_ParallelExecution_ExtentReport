    node('master') {
        stage("checkout"){
            git credentialsId: 'dbd2b7f7-7776-40e3-a9c3-73f4b620a651', url: 'https://github.com/nitinmanojkumar/Maven_TestNG_ParallelExecution_ExtentReport.git'
        }
        stage("maven clean"){
            withEnv(["PATH+MAVEN=${tool 'MAVEN_HOME'}/bin"]) {
                bat label: '', script: 'mvn clean'
            }
        }
        stage("Execute bat file"){
            println pwd()
            bat 'start cmd.exe /c '+pwd()+'\\batFiles\\sample.bat'
        }
    }


        
