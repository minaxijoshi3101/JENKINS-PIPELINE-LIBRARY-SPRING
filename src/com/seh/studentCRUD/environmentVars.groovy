package com.seh.studentCRUD

def call(Map pipelineParams) {
    env.REPO = pipelineParams.REPO
    env.BRANCH = pipelineParams.BRANCH
    env.GIT_GROUP = pipelineParams.GIT_GROUP
    env.DOCKER_HOST = pipelineParams.DOCKER_HOST
    env.DOCKER_REGISTRY = pipelineParams.DOCKER_REGISTRY
    env.APP_NAME = pipelineParams.APP_NAME
    env.CONTAINER_PORT = pipelineParams.CONTAINER_PORT
    env.NAMESPACE = pipelineParams.NAMESPACE
    env.HOST_PORT = pipelineParams.HOST_PORT
    env.HOST_IP  = pipelineParams.HOST_IP   
    env.REPLICAS = pipelineParams.REPLICAS 
    env.ENVIRONMENT = pipelineParams.ENVIRONMENT
    env.DB_NAME = pipelineParams.DB_NAME
}
