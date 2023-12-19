package be.wimdetroyer.javasandbox.testmotherspoc;

import lombok.Builder;

@Builder
public record ContactInfo(String representative, String phoneNumber) {
}
