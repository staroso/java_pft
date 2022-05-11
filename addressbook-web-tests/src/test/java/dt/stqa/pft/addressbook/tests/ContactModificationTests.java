package dt.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import dt.stqa.pft.addressbook.model.ContactData;
public class ContactModificationTests extends TestBase{

  @Test
  public void testModificationContact() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Nadezhda", "Andreevna", "Chumakova", "nstaroso", "DTIT", "Saint-Petersburg", "n.starosotnikova@gmail.com", "test4"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillDataOfContact(new ContactData("Nadia", "Nadia", "Star", "nstaroso2", "DTDTDT", "Moskau-Petersburg", "n.starosot@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
