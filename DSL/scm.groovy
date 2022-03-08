job('javaappDSLscm') {
    description('Java Maven App con DSL para el curso de Jenkins')
    scm {
        git('https://github.com/Adastra-THW/jenkinsmaven.git', 'master') { node ->
            node / gitConfigName('adastra')
            node / gitConfigEmail('adastra@thehackerway.com')
        }
    }
}
