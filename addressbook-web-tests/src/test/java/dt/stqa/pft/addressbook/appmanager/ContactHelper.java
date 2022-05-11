package dt.stqa.pft.addressbook.appmanager;

import dt.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {
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
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompanyname());
    type(By.name("home"), contactData.getCity());
    type(By.name("email"), contactData.getEmail());

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
  public void initContactModification() {
    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillDataOfContact(new ContactData("Nadezhda", "Andreevna", "Chumakova", "nstaroso", "DTIT", "Saint-Petersburg", "n.starosotnikova@gmail.com", "test4"), true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
}
