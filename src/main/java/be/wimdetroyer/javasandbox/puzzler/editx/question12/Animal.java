package be.wimdetroyer.javasandbox.puzzler.editx.question12;

public sealed interface Animal {}

/*
legal because one can implement a sealed interface provided the class implementing it is declared in the same file as the interface AND it is FINAL/sealed or NON-sealed
*/
final class Bird implements Animal {}

/*
   Interface extending an interface is legal, also WITHIN the same file, however we need to declare non-sealed/sealed here.
   Why?

   The point of non-sealed: https://stackoverflow.com/questions/63860110/what-is-the-point-of-extending-a-sealed-class-with-a-non-sealed-class
*/
non-sealed interface Mamal extends Animal {}

/*
 Possible even if Mamal were sealed because again:
 one can implement a sealed interface provided the class implementing it is declared in the same file as the interface AND it is FINAL/sealed or NON-sealed

*/
final class Cat implements Mamal {}

final class Dog implements Mamal {}

class Main {
  public static void main(String[] args) {
    Animal animal = new Cat();
    // We can do this if it were non-sealed:
    Mamal mama =
        new Mamal() {
          @Override
          public int hashCode() {
            return super.hashCode();
          }
        };
    switch (animal) {
      case Bird bird -> System.out.printf("Bird");
      case Cat cat -> System.out.printf("Cat");
      case Dog dog -> System.out.println("Dog");
        // TODO: possible solutions are adding mssing branch (mamal) or making Mamal sealed??
        // Mamal can be instantiated by creating an anonymous class
        // Sswitch expressions NEEED to cover all possible cases!!
      default -> throw new IllegalStateException("Unexpected value: " + animal);
    }
  }

  //    // See also: https://stackoverflow.com/a/65657170/3470438
  //    public String caseTest() {
  //        Animal animal = new Cat();
  //        // switch expression DOES not need a default branch
  //        return switch (animal) {
  //            case Bird bird ->  "Bird";
  //            case Cat cat ->  "Cat";
  //            case Dog dog ->  "Dog";
  //        };
  //    }
}
