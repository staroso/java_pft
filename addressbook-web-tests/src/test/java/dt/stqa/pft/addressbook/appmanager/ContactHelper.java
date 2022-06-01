package dt.stqa.pft.addressbook.appmanager;

import dt.stqa.pft.addressbook.model.ContactData;
import dt.stqa.pft.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }   else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
  public void initContactModification(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }
  public void checkAlert() {
    try {
      wd.switchTo().alert().accept();
    } catch (NoAlertPresentException e) {}
  }
  public void createContact(ContactData contact, boolean creation) {
    initContactCreation();
    fillDataOfContact(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModification(contact.getId());
    fillDataOfContact(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void deleteContact(ContactData contact) {
    initContactModification(contact.getId());
    deleteSelectedContact();
    checkAlert();
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

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> column = element.findElements(By.cssSelector("td"));
      String firstname = column.get(2).getText();
      String lastname = column.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }


}
