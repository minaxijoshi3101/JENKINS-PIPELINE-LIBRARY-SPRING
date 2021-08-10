import com.seh.util.checkoutSCM;
import com.seh.studentCRUD.buildCompileApp;
import com.seh.studentCRUD.environmentVars;

def call(Map pipelineParams)
{
  try
  {
    timeout(time: 60,unit:"MINUTES")
    {
      env.BRANCH = pipelineParams.BRANCH
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
          stage("Deploy Application")
          {
            new deployApp().call(pipelineParams)
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
