package be.wimdetroyer.javasandbox.failfastwithstreams.v2;

import lombok.SneakyThrows;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
       // https://stackoverflow.com/questions/52215917/callable-vs-supplier-interface-in-java
       // https://stackoverflow.com/questions/29132884/lazy-field-initialization-with-lambdas/29133244
       // https://stackoverflow.com/questions/51941203/using-java-8-supplier-in-streams-to-achieve-lazy-evaluation
*/
public class FailFastValidationService {

  private ErrorNotificationService errorNotificationService = new ErrorNotificationService();

  public void validate(PayloadToValidate payloadToValidate) {

    String param1 = payloadToValidate.param1();
    String param2 = payloadToValidate.param2();
    String param3 = payloadToValidate.param3();

    Supplier<ValidationResult<String>> val1Func = this::validation1;
    Supplier<ValidationResult<String>> val2Func = () -> this.validation2(param1);
    Supplier<ValidationResult<String>> val3Func = () -> this.validation3(param1, param2);
    Supplier<ValidationResult<String>> val4Func = () -> this.validation4(param1, param2, param3);

    // Note:  Stream.of is sequential
    var optionalError =
        Stream.of(val1Func, val2Func, val3Func, val4Func)
            .map(Supplier::get)
            .dropWhile(ValidationResult::isOk)
            .findFirst();
//
//    optionalError.ifPresentOrElse(
//        (err) -> errorNotificationService.notify(err), () -> System.out.println("No errors found"));
  }

  @SneakyThrows
  private ValidationResult<String> validation1() {
    System.out.println("Running validation 1");
    Thread.sleep(2500);
    System.out.println("Done with validation 1");
    System.out.println("---");

    return ValidationResult.of("foo");
    //        return ValidationResult.of(dummyError());
  }

  @SneakyThrows
  private ValidationResult<String> validation2(String param1) {
    System.out.println("Running validation 2");
    Thread.sleep(5000);
    System.out.println("Done with validation 2");
    System.out.println("---");

    return ValidationResult.of("foo");
    //        return ValidationResult.of(dummyError());
  }

  @SneakyThrows
  private ValidationResult<String> validation3(String param1, String param2) {
    System.out.println("Running validation 3");
    Thread.sleep(7500);
    System.out.println("Done with validation 3");
    System.out.println("---");

    return ValidationResult.of("foo");
    //        return ValidationResult.of(dummyError());
  }

  @SneakyThrows
  private ValidationResult<String> validation4(String param1, String param2, String param3) {
    System.out.println("Running validation 3");
    Thread.sleep(10000);
    System.out.println("Done with validation 3");
    System.out.println("---");

    return ValidationResult.of("foo");
    //        return ValidationResult.of(dummyError());
  }

  private Error dummyError() {
    return new Error("foo", "bar");
  }
}
