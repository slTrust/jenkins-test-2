String buildNumber = env.BUILD_NUMBER;
String timestamp = new Date().format('yyyyMMddHHmmss');
String projectName = env.JOB_NAME.split(/\//)[0];
// e.g awesome-project/release/RELEASE-1.0.0
String branchName = env.JOB_NAME.split(/\//)[1..-1].join(/\//);

println("${buildNumber} ${timestamp} ${projectName}");

String version = "${buildNumber}-${timestamp}-${projectName}";


pipeline {
    agent {
        docker { image 'circleci/openjdk:8u212-jdk-stretch' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }
}
