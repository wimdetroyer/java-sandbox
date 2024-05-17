package be.wimdetroyer.javasandbox.testmotherspoc;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTestMother {

  /*
     Contrived example of a User Test Mother returning a 'valid user builder'
     Valid here would mean that the user entity is created with all mandatory fields prefilled in with sensible defaults.
     test classes consumers of the testmother can take this valid user and apply changes to certain fields, not having to worry about presetting the object in a valid state.
  */
  public static User.UserBuilder validUser() {
    var userBuilder = User.builder();
    userBuilder.userId("123");
    userBuilder.name("Wim");
    userBuilder.gender("Male");
    // lomboks lack of a composite builder make the following clunky.
    userBuilder.Organization(OrganisationTestMother.validOrganization().build());
    var addressBuilder = AdressTestMother.validAddress();
    userBuilder.addressList(List.of(addressBuilder.build(), addressBuilder.build()));
    return userBuilder;
  }
}
