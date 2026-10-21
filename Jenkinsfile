// Jenkinsfile（放在项目根目录）
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
                    // 收集测试报告 → 左侧出现 "Test Result"
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo '打包项目...'
                bat 'mvn package -DskipTests'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline 执行成功!'
            // 归档 JAR 包 → 左侧出现 "Build Artifacts"
            archiveArtifacts artifacts: ', fingerprint: true
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