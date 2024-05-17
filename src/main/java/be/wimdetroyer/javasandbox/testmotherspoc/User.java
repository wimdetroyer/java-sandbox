package be.wimdetroyer.javasandbox.testmotherspoc;

import java.util.*;
import lombok.Builder;

@Builder
public record User(
    String userId,
    String name,
    String gender,
    List<Address> addressList,
    Organization Organization) {}
