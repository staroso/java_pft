package dt.stqa.pft.addressbook.tests;

import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  private int id;

  @Test
  public void testDeleteContact() {
    if (! app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().createGroup(new GroupData("test4", "test4", "test4"));
    }
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("name", "lastname", "test4"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }
}

