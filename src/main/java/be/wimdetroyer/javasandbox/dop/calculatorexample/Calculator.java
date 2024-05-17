package be.wimdetroyer.javasandbox.dop.calculatorexample;

public class Calculator {

    public static void main(String[] args) {
        var numberExpr = new NumberExpr(50);
        var numberExpr2 = new NumberExpr(50);
        // (5 + (5 + 5)) / 3
        var sums = new SumExpr(numberExpr, new SumExpr(numberExpr, numberExpr2));
        System.out.println(evaluate(sums));
        var divisionExpr = new DivisionExpr(sums, new NumberExpr(3));
        System.out.println(evaluate(divisionExpr));
    }

    public static int evaluate(Expression expression) {
        return switch (expression) {
            case DivisionExpr(Expression expr1, Expression expression2) -> evaluate(expr1) / evaluate(expression2);
            case ProductExpr product -> evaluate(product.expr1()) / evaluate(product.expr2());
            case SubtractionExpr subtractionExpr -> evaluate(subtractionExpr.expr1()) / evaluate(subtractionExpr.expr2());
            case SumExpr sum -> evaluate(sum.expr1()) + evaluate(sum.expr2());
            // Only allof for numbers up until 30.
            case NumberExpr(int number) when number > 30 -> 30;
            case NumberExpr(int number) -> number;
        };
    }
}
