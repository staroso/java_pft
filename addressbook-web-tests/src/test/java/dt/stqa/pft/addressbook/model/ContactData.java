package dt.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String secondname;
  private final String lastname;
  private final String nickname;
  private final String companyname;
  private final String city;
  private final String email;

  public ContactData(String name, String secondname, String lastname, String nickname, String companyname, String city, String email) {
    this.name = name;
    this.secondname = secondname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.companyname = companyname;
    this.city = city;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getSecondname() {
    return secondname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompanyname() {
    return companyname;
  }

  public String getCity() {
    return city;
  }

  public String getEmail() {
    return email;
  }

}
