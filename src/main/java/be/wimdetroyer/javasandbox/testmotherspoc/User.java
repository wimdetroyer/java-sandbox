package be.wimdetroyer.javasandbox.testmotherspoc;

import lombok.Builder;
import java.util.*;

@Builder
public record User(String userId, String name, String gender, List<Address> addressList, Organization Organization) {
}
