package dt.stqa.pft.addressbook.appmanager;

import dt.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  private int id;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void returnToHomePage() {
    click(By.linkText("home"));
  }
  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
  public void fillDataOfContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getSecondname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
  } else {
    Assert.assertFalse(isElementPresent(By.name("new_group")));
   }
  }
  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }
  public void initContactModification(int index) {
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
  }
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillDataOfContact(new ContactData("name", "lastname", "test4"), true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void selectContact(int index) {
    click(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> column = element.findElements(By.cssSelector("td"));
      String firstname = column.get(2).getText();
      String lastname = column.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname, lastname, null);
      contacts.add(contact);
    }
    return contacts;
  }

}
