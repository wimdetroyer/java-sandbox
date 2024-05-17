package be.wimdetroyer.javasandbox.assertjrecursivecomparison;

import java.util.function.BiPredicate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DumbDTOMapperTest {

  @Test
  void mapsOk() {
    var dumbDTOMapper = new DumbDTOMapper();
    var actual = new DumbDTO();
    var dumbDTOSubClass = new DumbDTOSubClass();
    dumbDTOSubClass.setVatNumber("VAT123");
    actual.setSubClass(dumbDTOSubClass);
    var expected = dumbDTOMapper.toSmart(actual);

    Assertions.assertThat(expected)
        .usingRecursiveComparison()
        .withEqualsForFields(
            new BiPredicate<VatNumber, String>() {
              @Override
              public boolean test(VatNumber actual, String expected) {
                return actual.toString().equals(expected);
              }
            },
            "subClass.vatNumber")
        .isEqualTo(actual);

    // Will fail:
    Assertions.assertThat(expected).usingRecursiveComparison().isEqualTo(actual);
  }
}
