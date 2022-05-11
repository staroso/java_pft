package dt.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import dt.stqa.pft.addressbook.model.ContactData;
public class ContactModificationTests extends TestBase{

  @Test
  public void testModificationContact() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillDataOfContact(new ContactData("Nadia", "Nadia", "Star", "nstaroso2", "DTDTDT", "Moskau-Petersburg", "n.starosot@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
