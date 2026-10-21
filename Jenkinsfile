pipeline {
    agent any
    
    tools {
        maven 'maven-3.10'
        jdk 'jdk17'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo '拉取代码...'
                git 'https://github.com/shiguanqiu521/jenkins-demo.git'
            }
        }
        
        stage('Compile') {
            steps {
                echo '编译代码...'
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo '运行单元测试...'
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo '打包项目...'
                bat 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, allowEmptyArchive: true
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline 执行成功!'
        }
        failure {
            echo 'Pipeline 执行失败!'
        }
        always {
            echo '清理工作空间...'
            cleanWs()
        }
    }
}