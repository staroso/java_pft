package dt.stqa.pft.addressbook.tests;


import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.Contacts;
import dt.stqa.pft.addressbook.model.GroupData;
import dt.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().goToHomePage();
      app.contact().createContact(new ContactData().withFirstname("test_name").withLastname("test_surname"));
    }

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    Contacts beforeContact = app.db().contacts();
    ContactData contactSelect = beforeContact.iterator().next();
    Groups beforeGroup = app.db().groups();
    GroupData groupSelect = beforeGroup.iterator().next();

    app.goTo().goToHomePage();
    if (!contactSelect.getGroups().isEmpty() && contactSelect.getGroups().contains(groupSelect)) {
      app.contact().deleteContactFromGroup(contactSelect, groupSelect);
      assertThat(contactSelect.getGroups().without(groupSelect), equalTo(app.db().contacts().stream().
              filter((c) -> c.getId() == contactSelect.getId()).collect(Collectors.toList()).get(0).getGroups()));
      app.goTo().goToHomePage();
    }
    app.contact().selectAllGroup("[all]");
    app.contact().addContactToGroup(contactSelect, groupSelect);
    assertThat(contactSelect.getGroups().withAdded(groupSelect), equalTo(app.db().contacts().stream().
            filter((c) -> c.getId() == contactSelect.getId()).collect(Collectors.toList()).get(0).getGroups()));
  }
}

