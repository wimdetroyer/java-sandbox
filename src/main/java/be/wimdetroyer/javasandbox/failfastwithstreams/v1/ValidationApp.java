package be.wimdetroyer.javasandbox.failfastwithstreams.v1;

public class ValidationApp {

  public static void main(String[] args) {
    new FailFastValidationService().validate(new PayloadToValidate("foo", "bar", "baz"));
  }
}
