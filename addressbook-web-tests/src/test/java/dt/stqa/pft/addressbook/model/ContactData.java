package dt.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String name;
  private String secondname;
  private String lastname;
  private String group;

  public ContactData(String name, String lastname, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.lastname = lastname;
    this.group = group;
  }
  public ContactData(int id, String name, String lastname, String group) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
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


  public String getGroup() {
    return group;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastname);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            "lastname='" + lastname + '\'' +
            '}';
  }

}
