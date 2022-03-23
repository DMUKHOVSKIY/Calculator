public class Calculator implements CalculatorInterface {
    private double result;
    private OperationHistory history = new OperationHistory();

    @Override
    public void action(double firstNumber, double secondNumber, String operation) {
        switch (operation) {
            case "+": {
                result = firstNumber + secondNumber;
                addResult();
                System.out.println(result);
            }
            break;
            case "-": {
                result = firstNumber - secondNumber;
                addResult();
                System.out.println(result);
            }
            break;
            case "*": {
                result = firstNumber * secondNumber;
                addResult();
                System.out.println(result);
            }
            break;
            case "/": {
                result = firstNumber / secondNumber;
                addResult();
                System.out.println(result);
            }
            break;
            default:
                System.out.println("There isn't such operation");
        }
    }

    private void addResult() {
        history.addObject(result);
    }

    public void printHistory() {
        history.printObject();
    }
}
