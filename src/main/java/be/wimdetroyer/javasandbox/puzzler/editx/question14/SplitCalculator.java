package be.wimdetroyer.javasandbox.puzzler.editx.question14;

public record SplitCalculator(float amount, int people) {

  float amountToPay() {
    return amount / people;
  }

  static class Main {
    public static void main(String[] args) {
      SplitCalculator splitCalculator = new SplitCalculator(100, 0);
      System.out.println(splitCalculator.amountToPay());
      // prints infinity: see
      // https://stackoverflow.com/questions/18542536/why-is-number-divided-by-zero-infinity-in-java
    }
  }
}
