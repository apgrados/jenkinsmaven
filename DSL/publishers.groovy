job('javaappDSLpublishers') {
    description('Java Maven App con DSL para el curso de Jenkins')
    scm {
        git('https://github.com/apgrados/jenkinsmaven.git', 'master') { node ->
            node / gitConfigName('adastra')
            node / gitConfigEmail('adastra@thehackerway.com')
        }
    }
    steps {
        maven {
          mavenInstallation('mavenjenkins')
          goals('-B -DskipTests clean package')
        }
        maven {
          mavenInstallation('mavenjenkins')
          goals('test')
        }
        shell('''
          echo "Entrega: Desplegando la aplicación" 
          java -jar "/root/.jenkins/workspace/MVNIntegration/target/my-app-1.0-SNAPSHOT.jar"
        ''')
    }
    publishers {
        archiveArtifacts('target/*.jar')
        archiveJunit('target/surefire-reports/*.xml')
    }
}
