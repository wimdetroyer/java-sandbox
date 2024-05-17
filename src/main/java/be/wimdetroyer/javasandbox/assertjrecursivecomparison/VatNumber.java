package be.wimdetroyer.javasandbox.assertjrecursivecomparison;

public class VatNumber {

  private final String internalValue;

  public VatNumber(String internalValue) {
    if (!internalValue.contains("VAT")) {
      throw new IllegalArgumentException("is not a VAT");
    }
    this.internalValue = internalValue;
  }

  @Override
  public String toString() {
    return internalValue;
  }
}
