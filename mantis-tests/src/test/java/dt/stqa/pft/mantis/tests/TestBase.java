package dt.stqa.pft.mantis.tests;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import dt.stqa.pft.mantis.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite(alwaysRun = true)
  protected void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.logout();
    app.stop();
  }

}