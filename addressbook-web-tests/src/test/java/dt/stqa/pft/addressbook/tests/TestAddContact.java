package dt.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.Contacts;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAddContact extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson ();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

  }

  @Test (dataProvider = "validContactsFromJson")
  public void testCreateNewContact(ContactData contact) throws Exception {
    app.goTo().goToHomePage();
    Contacts before = app.db().contacts();
    app.contact().createContact(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}