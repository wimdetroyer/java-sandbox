package be.wimdetroyer.javasandbox.testmotherspoc;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OrganisationTestMother {

  public static Organization.OrganizationBuilder validOrganization() {
    var builder = Organization.builder();
    builder.organisationName("Het Codehuis");
    /*
       The chain continues... lomboks lack of a composite mother is a PITA here.
       Ideally we would be able to handle this from WITHIN the UserTestMother. See:
       https://github.com/projectlombok/lombok/issues/2557
    */
    builder.contactInfo(ContactInfo.builder().build());
    return builder;
  }
}
