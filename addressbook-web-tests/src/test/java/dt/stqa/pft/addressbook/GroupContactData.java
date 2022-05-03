package dt.stqa.pft.addressbook;

public class GroupContactData {
  private final String name;
  private final String secondname;
  private final String lastname;
  private final String nickname;
  private final String companyname;
  private final String city;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;

  public GroupContactData(String name, String secondname, String lastname, String nickname, String companyname, String city, String email, String bday, String bmonth, String byear) {
    this.name = name;
    this.secondname = secondname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.companyname = companyname;
    this.city = city;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
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

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }
}
