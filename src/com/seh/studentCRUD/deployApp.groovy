package com.seh.studentCRUD
 def call(Map pipelineparams)
{
  sh '''
  sudo docker rm -f ${APP_NAME}
  sudo docker run -d --name ${APP_NAME} -p${HOST_PORT}:${CONTAINER_PORT} ${DOCKER_REGISTRY}:latest
  '''
}
