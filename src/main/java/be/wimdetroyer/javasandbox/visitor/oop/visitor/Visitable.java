package be.wimdetroyer.javasandbox.visitor.oop.visitor;


//TODO: https://refactoring.guru/design-patterns/visitor-double-dispatch

// This interface is necessary because double dispatch is not used in java. For more info: https://www.baeldung.com/ddd-double-dispatch

public interface Visitable {

    void accept(BooksVisitor v);
}
