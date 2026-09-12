pipeline {

agent any

stages {

stage('Checkout') {
steps {
checkout scm
}
}

stage('Build') {
steps {
bat 'mvn clean install -DskipTests'
}
}
stage('Check Workspace') {
steps {
bat 'cd'
bat 'dir'
bat 'dir pom.xml'
}
}
stage('Run Playwright Tests') {
steps {
bat 'mvn test'
}
}
}

post {
always {
junit 'target/surefire-reports/TEST-*.xml'
}
}
}

