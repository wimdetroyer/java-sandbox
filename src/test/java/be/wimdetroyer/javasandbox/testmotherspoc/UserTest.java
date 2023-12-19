package be.wimdetroyer.javasandbox.testmotherspoc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {

    @Test
    void userTest() {
        var validuserBuilder = UserTestMother.validUser();
        var addressBuilder = AdressTestMother.validAddress();
        addressBuilder.street("Visstraat");
        addressBuilder.number("83");
        validuserBuilder.AddressList(List.of(addressBuilder.build()));
        var user = validuserBuilder.build();
        Assertions.assertEquals(1, user.addressList().size());
    }
}
