package com.seh.studentCRUD
 def call(Map pipelineparams)
{
  sh '''
  sudo docker rm -f ${APP_NAME}
  sudo docker run -v testvol1:/etc -d --name ${APP_NAME} -p ${HOST_PORT}:${CONTAINER_PORT} -v myvol1:/var/JENKINS_HOME ${DOCKER_REGISTRY}:latest
  '''
}
