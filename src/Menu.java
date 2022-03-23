import java.util.Scanner;

public class Menu {
    private boolean conclusion = true;
    private static boolean b1 = true;
    private Calculator calc = new Calculator();
    private UserHistory userHistory = new UserHistory();
    private Scanner scanner = new Scanner(System.in);

    //Calculator life cycle
    private boolean end() {
        if (!conclusion)
            return false;
        return true;
    }


    private double number(int i) {
        while (true) {
            System.out.println("Number" + i + ":");
            scanner = new Scanner(System.in);
            if (scanner.hasNextDouble())
                return scanner.nextDouble();
            else
                System.out.println("Input correct number");
        }
    }

    //+, -, *, /
    private String operation() {
        while (true) {
            System.out.println("operation:");
            scanner = new Scanner(System.in);
            return scanner.next();
        }
    }

    public void authentication() {
        int chose;

        while (true) {
            conclusion = true;
            while (true) {
                scanner = new Scanner(System.in);
                System.out.println("Choose 1 to Registration, 2 to authorization or 3 to exit");
                if (scanner.hasNextInt()) {
                    chose = scanner.nextInt();
                    if (chose == 1 || chose == 2 || chose == 3)
                        break;
                }
            }

            switch (chose) {
                case 1: {
                    System.out.println("Enter login");
                    String loginTmp = scanner.next();
                    System.out.println("Enter password");
                    scanner = new Scanner(System.in);
                    String passwordTmp = scanner.next();
                    System.out.println("Enter username");
                    scanner = new Scanner(System.in);
                    String usernameTmp = scanner.next();

                    userHistory.addObject(new User(loginTmp, passwordTmp, usernameTmp));
                }
                break;
                case 2: {
                    System.out.println("Enter login");
                    String loginTmp = scanner.next();
                    System.out.println("Enter password");
                    scanner = new Scanner(System.in);
                    String passwordTmp = scanner.next();

                    if (userHistory.checkData(new User(loginTmp, passwordTmp))) {
                        System.out.println("Hello " + userHistory.getName());
                        callingCalculator();
                    } else
                        System.out.println("Try again");
                }
                break;
                case 3:
                    System.out.println("I'LL BE BACK");
                    return;
            }
        }
    }

    public void callingCalculator() {
        int chose1;
        while (end()) {
            while (true) {
                scanner = new Scanner(System.in);
                System.out.println("Choose: 1 to start, 2 to print the history of calculations or 3 to exit");
                if (scanner.hasNextInt()) {
                    chose1 = scanner.nextInt();
                    break;
                }
            }


            switch (chose1) {
                case 1: {
                    calc.action(number(1), number(2), operation());
                }
                break;
                case 2: {
                    calc.printHistory();
                }
                break;
                case 3: {
                    System.out.println("END");
                    conclusion = false;
                }
                break;
                default:
                    System.out.println("Input correct number!!!");
            }
        }
    }


}
