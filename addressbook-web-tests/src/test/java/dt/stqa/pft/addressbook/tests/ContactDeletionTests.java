package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.Contacts;
import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
  private int id;
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().all().size() ==0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().goToHomePage();
    if (app.contact().all().size() ==0) {
      app.contact().createContact(new ContactData().withFirstname("test_name").withLastname("test_surname").withGroup("test4"), true);
    }
    }
  @Test(enabled = true)
  public void testDeleteContact() {
      Contacts before = app.contact().all();
      ContactData deletedContact = (ContactData) before.iterator().next();
      app.contact().deleteContact(deletedContact);
      Contacts after = app.contact().all();
      assertThat(after.size(), equalTo(before.size() - 1));

      assertThat(after, equalTo(before.without(deletedContact)));
    }
}

