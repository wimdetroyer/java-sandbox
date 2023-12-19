package be.wimdetroyer.javasandbox.testmotherspoc;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AdressTestMother {

    public static Address.AddressBuilder validAddress() {
        var addressBuilder = Address.builder();
        addressBuilder.country("Belgium");
        addressBuilder.city("Brussels");
        addressBuilder.number("123");
        addressBuilder.street("Grand Place");
        return addressBuilder;
    }
}
