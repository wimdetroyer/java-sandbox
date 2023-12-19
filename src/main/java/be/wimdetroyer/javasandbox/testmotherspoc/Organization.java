package be.wimdetroyer.javasandbox.testmotherspoc;

import lombok.Builder;

@Builder
public record Organization(ContactInfo contactInfo, String organisationName) {
}
