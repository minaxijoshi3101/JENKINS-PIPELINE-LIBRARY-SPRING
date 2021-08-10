package com.seh.studentCRUD

def call(Map pipelineParams) 
{
  if(pipelineParams.APP_TYPE == "java")
  POM = readMavenPom file: "${REPO}/pom.xml"
  env.POM_VERSION = POM.version
{
  sh '''
  cd $REPO
  mvn clean install
  cp 
  '''
}
}
