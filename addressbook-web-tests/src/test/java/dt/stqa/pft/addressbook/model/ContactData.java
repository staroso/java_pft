package dt.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private String name;
  private String secondname;
  private String lastname;
  private String nickname;
  private String companyname;
  private String city;
  private String email;
  private String group;


  public ContactData(String name, String secondname, String lastname, String nickname, String companyname, String city, String email, String group) {
    this.id = Integer.MAX_VALUE;;
    this.name = name;
    this.secondname = secondname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.companyname = companyname;
    this.city = city;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id, String name, String secondname, String lastname) {
    this.id = id;
    this.name = name;
    this.secondname = secondname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.companyname = companyname;
    this.city = city;
    this.email = email;
    this.group = group;
  }

  public int getId() {
    return id;
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

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
