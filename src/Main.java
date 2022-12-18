import java.util.Scanner;

import static java.util.Collections.replaceAll;


public class Main {
    public static void main(String[] args) {
        double accum = 0;
        boolean switcher = false;
        String operation = "";
        //System.out.println("введите число");
        accum = getNumber();
        while (true) {

            if (switcher) {
                System.out.println("введите число");

            } else {
                System.out.println("введите операцию");
            }
            String tmp = getString();
            if (tmp.equals("с")) {
                Main.main(args);
            }
            boolean isValid = false;
            if (switcher) {
                isValid = isNumber(tmp);


            } else {
                isValid = isOperation(tmp);
            }
            if (!isValid) {
                System.out.println("нневерный ввод");
                continue;

            }
            if (switcher) {
                int num = Integer.parseInt(tmp);
                accum = calculate(accum, operation, num);
                System.out.println("новое число равно " + accum);

            } else {
                operation = tmp;
            }
            switcher = !switcher;
        }


    }

    public static double calculate(double a, String op, int b) {
        switch (op) {
            case "+":
                return (a + b);
            case "-":
                return (a - b);
            case "*":
                return (a * b);
            default:
                return (a / b);

        }

    }

    public static String getString() {
        Scanner sc1 = new Scanner(System.in);
        return sc1.nextLine();
    }

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число");
            String maybeNum = sc.nextLine();
            if (!isNumber(maybeNum)) {
                System.out.println("не правильный ввод, повторите");
                continue;

            }
            return Integer.parseInt(maybeNum);
        }

    }

    public static boolean isNumber(String a) {
        a = a.replaceAll("1", "").replaceAll("2", "")
                .replaceAll("3", "").replaceAll("4", "")
                .replaceAll("5", "").replaceAll("6", "")
                .replaceAll("7", "").replaceAll("8", "")
                .replaceAll("9", "").replaceAll("0", "");
        return a.trim().length() == 0;
    }


    public static boolean isOperation(String s) {
        s = s.replaceAll("\\+", "")
                .replaceAll("-", "")
                .replaceAll("\\*", "")
                .replaceAll("/", "")
                .trim();
        return s.length() == 0;
    }
}
