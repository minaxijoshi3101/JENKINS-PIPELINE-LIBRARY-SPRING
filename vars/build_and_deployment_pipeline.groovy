import com.seh.util.checkoutSCM;
import com.seh.studentCRUD.buildCompileApp;

def call(Map pipelineParams)
{
  try
  {
    timeout(time: 60,unit:"MINUTES")
    {
      env.BRNACH = pipelineParams.BRANCH
      env.REPO = pipelineParams.REPO
      pipeline
      {
        new environmentVars().call(pipelineParams)
        node(pipelineParams.BUILD_NODE)
        {
          stage("checkout source code")
          {
            new checkoutSCM().call(pipelineParams)
          }
          stage("Build provisioning")
          {
            new buildCompileApp().call(pipelineParams)
          }
        }
      }
    }
  }
  catch(Exception e)
  {
    print "Error cause: ${e}"
    error('Build stage - failed')
  }
}
