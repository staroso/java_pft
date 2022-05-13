package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestAddContact extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @Test
  public void testCreateNewContact() throws Exception {
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("test4", "test4", "test4"));
    }
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillDataOfContact(new ContactData("Nadezhda", "Andreevna", "Chumakova", "nstaroso", "DTIT", "Saint-Petersburg", "n.starosotnikova@gmail.com", "test4"), true);
    app.getContactHelper().submitContactCreation();;
    app.getContactHelper().returnToHomePage();
  }
}