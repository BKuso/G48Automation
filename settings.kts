package G48.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.exec

object G48_Test : BuildType({
    id("Test")
    name = "Test"

    vcs {
        root(G48Automation)
    }

    steps {
        dockerCommand {
            name = "Prepare Environment"
            enabled = false
            commandType = build {
                source = file {
                    path = "./docker/prepare.dockerfile"
                }
                contextDir = "."
                namesAndTags = "mvn:latest"
            }
            param("dockerImage.platform", "linux")
        }
        dockerCommand {
            name = "Prepare Project Container"
            commandType = build {
                source = file {
                    path = "./docker/launch.dockerfile"
                }
                contextDir = "."
                namesAndTags = "g48:latest"
            }
            param("dockerImage.platform", "linux")
        }
        dockerCompose {
            name = "Up Allure and Selenoid Environment"
            file = "docker-compose.yml"
        }
        exec {
            name = "Run g48 tests"
            path = "docker run -it -v ${'$'}{PWD}/allure/allure-results:/app/G48Automation/target/allure-results g48 mvn test -Dusername=BKuso -Dpassword=Ovrush20 -PChrome"
        }
        step {
            name = "Launch g48"
            type = "allure.testPlanBuildStep"
            param("allure.server.testplan.filter", "*")
            param("allure.server.testplan.override", "true")
        }
    }
})
