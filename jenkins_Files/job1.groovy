    pipeline{
        agent any
        
        parameters {
            string(name: 'user', defaultValue: 'John', description: 'A user that triggers the pipeline')
        }
  
 
        
        stages{
            
           /* stage('Trigger pipeline') {
                steps {
                    echo "Pipeline triggered by ${params.USER}"
                }
            }
  
            /*stage ('build') {
                input{
                message "Press Ok to continue"
                submitter "user1,user2"
                parameters {
                string(name:'username', defaultValue: 'user', description: 'Username of the user pressing Ok')
                    }
                }
                steps { 
                    echo "User: ${username} said Ok."
                }
            }*/
            
            stage("checkout"){
                environment {
                    OUTPUT_PATH = './outputs/'
                }
                steps{
					git credentialsId: 'dbd2b7f7-7776-40e3-a9c3-73f4b620a651', url: 'https://github.com/nitinmanojkumar/Maven_TestNG_ParallelExecution_ExtentReport.git'
				}
			}
            stage("maven clean"){
                environment {
                    OUTPUT_PATH = './outputs/'
                }
                steps{
					withEnv(["PATH+MAVEN=${tool 'MAVEN_HOME'}/bin"]) {
					bat label: '', script: 'mvn clean'
					}
                }
            }
            stage("Execute bat file"){
                
				
				
				steps {
				parallel (
					"Bat1" : {
						script {
							println pwd()
							bat 'start cmd.exe /c '+pwd()+'\\batFiles\\sample.bat'
							println '1';
						}
					},
					"Bat2" : {
						script {
							println pwd()
							bat 'start cmd.exe /c '+pwd()+'\\batFiles\\sample1.bat'
							println '2';
						}
					}
				)
			}

				
			}
            
        }
        
        
        post {
            always {
                echo 'Pipeline finished'
            }
        }
        
        
        
    }
    


        
k