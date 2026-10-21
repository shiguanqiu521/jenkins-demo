// Jenkinsfile（放在项目根目录）
pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9'
        jdk 'JDK-17'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo '拉取代码...'
                // 实际使用时: git 'https://github.com/your/repo.git'
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
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
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
    }
}