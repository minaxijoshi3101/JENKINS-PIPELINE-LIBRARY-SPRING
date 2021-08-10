package com.seh.studentCRUD

def call(Map pipelineParams) 
{
  echo "build the code"
  if(pipelineParams.APP_TYPE == "java")
  {
  POM = readMavenPom file: REPO+"/pom.xml"
  env.POM_VERSION = POM.version
  sh '''
  cd $REPO
  mvn clean install
  cp target/StudentCrud-${POM_VERSION}.jar .
  
  '''
}
  else if(pipelineParams.APP_TYPE == "node")
  {
    sh '''
    cd $REPO
    sudo npm install
    if [ $ENVIRONMENT == "dev" ]
    then
    sudo npm run build:deployment
    else
    sudo npm run build
    fi
    version=$(jq -r .version package.json)
    sudo docker build -t ${DOCKER_REGISTRY}:$version .
     sudo docker build -t ${DOCKER_REGISTRY}:latest .
     sudo docker push ${DOCKER_REGISTRY}:$version
     sudo docker push ${DOCKER_REGISTRY}:latest
    '''
  }
}
