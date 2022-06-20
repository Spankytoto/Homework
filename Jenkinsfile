pipeline {
        agent any

    parameters {
        choice(name: 'suite', choices: ['suitesGui.xml'], description: 'suite')
        }

        stages {
            stage("tests") {
                steps {
                    bat "mvn clean install"
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


