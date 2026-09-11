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

stage('Run Playwright Tests') {
steps {
bat 'mvn test'
}
}
}

post {
always {
junit 'target/surefire-reports/*.xml'
}
}
}

