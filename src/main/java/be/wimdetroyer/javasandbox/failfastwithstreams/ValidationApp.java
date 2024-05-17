package be.wimdetroyer.javasandbox.failfastwithstreams;

public class ValidationApp {

  public static void main(String[] args) {
    new FailFastValidationService().validate(new PayloadToValidate("foo", "bar", "baz"));
  }
}
