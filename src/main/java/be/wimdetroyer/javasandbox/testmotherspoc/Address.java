package be.wimdetroyer.javasandbox.testmotherspoc;

import java.util.Objects;
import lombok.Builder;

@Builder
public final class Address {
  private final String street;
  private final String city;
  private final String country;
  private final String number;

  public Address(String street, String city, String country, String number) {
    // contrived example of a validation rule:
    if (!country.equals("belgium")) {
      throw new IllegalArgumentException("Address must be in belgium!");
    }
    this.street = street;
    this.city = city;
    this.country = country;
    this.number = number;
  }

  public String street() {
    return street;
  }

  public String city() {
    return city;
  }

  public String country() {
    return country;
  }

  public String number() {
    return number;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Address) obj;
    return Objects.equals(this.street, that.street)
        && Objects.equals(this.city, that.city)
        && Objects.equals(this.country, that.country)
        && Objects.equals(this.number, that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, country, number);
  }

  @Override
  public String toString() {
    return "Address["
        + "street="
        + street
        + ", "
        + "city="
        + city
        + ", "
        + "country="
        + country
        + ", "
        + "number="
        + number
        + ']';
  }
}
