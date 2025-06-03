package programmierung2.kapitel10;

@FunctionalInterface
interface MathOp {
    int calculate(int operand1, int operand2);
}

public class MathCalculations {
    private static int compute(int operand1, int operand2, 
            MathOp operator) {
    	return operator.calculate(operand1, operand2); // TODO
    }

    public static void main(String[] args) {
        // TODO: define lambdas for "add" and "mult"
        MathOp add = (x, y) -> x + y;
        MathOp mult = (x, y) -> x * y;
        // Division
        MathOp div = (x, y) -> x / y;
        
        System.out.printf("%d + %d = %d\n", 3, 4, compute(3, 4, add));
        System.out.printf("%d * %d = %d\n", 3, 4, compute(3, 4, mult));
        System.out.printf("%d / %d = %d\n", 33, 4, compute(33, 4, div));
    }
}
