package be.wimdetroyer.javasandbox.testmotherspoc;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void userTest() {
    var validuserBuilder = UserTestMother.validUser();
    var addressBuilder = AdressTestMother.validAddress();
    addressBuilder.street("Visstraat");
    addressBuilder.number("83");
    validuserBuilder.addressList(List.of(addressBuilder.build()));
    var user = validuserBuilder.build();
    Assertions.assertEquals(1, user.addressList().size());
  }
}
