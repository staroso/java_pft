package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
      app.goTo().goToHomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("test_name").withLastname("test_surname").withGroup("[none]")
              .withHomePhone("12 345").withMobilePhone("22-222").withWorkPhone("+33553").withAddress("wwwLeningrad")
              .withEmail("qwerty@mail.ru").withEmail2("trewq@mail.ru").withEmail3("zxdfgdfcvbn@mail.ru"));    }
  }
  @Test(enabled = true)
  public void testModificationContact() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = (ContactData) before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test_name").withLastname("test_surname").withGroup("[none]");
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
  }

