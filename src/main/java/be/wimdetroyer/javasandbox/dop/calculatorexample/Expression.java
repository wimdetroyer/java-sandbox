package be.wimdetroyer.javasandbox.dop.calculatorexample;

public sealed interface Expression permits DivisionExpr, NumberExpr, ProductExpr, SubtractionExpr, SumExpr {
}
