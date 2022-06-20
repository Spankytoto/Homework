pipeline {
        agent any

    parameters {
        choice(name: 'suite', choices: ['testNG.xml'], description: 'suite')
        }

        stages {
            stage("tests") {
                steps {
                    bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testNG.xml"
            }
        }
            stage('report') {
                  steps {
                        allure([report: "allure-report", results: [[path: "target/allure-results"]]])
                            }
                        }

            }
            post {
                    always {
                        deleteDir()
                    }
        }
}


