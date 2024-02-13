import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        String number = scan.nextLine();
        System.out.print("В какой системе счисления измеряется ваше число: ");
        int systemAtTheMoment = scan.nextInt();
        System.out.print("В какую систему счисления хотите перевести число: ");
        int needSystem = scan.nextInt();
        if (needSystem == 10) {
            System.out.println("Результат: " + Integer.parseInt(number, systemAtTheMoment));
        } else if (systemAtTheMoment == 10) {
            System.out.println("Результат: " + conventor(number, needSystem));
        } else {
            String firstStep = String.valueOf(Integer.parseInt(number, systemAtTheMoment));
            String secondStep = conventor(firstStep, needSystem);
            System.out.println("Результат: " + secondStep);
        }
    }
    public static String conventor(String number, int system) {
        int numberInt = Integer.parseInt(number);
        String temp = "";
        if (system <= 10) {
            while (numberInt != 0) {
                int x = numberInt % system;
                temp = x + temp;
                numberInt /= system;
            }
        } else {
            while (numberInt != 0) {
                int x = numberInt % system;
                char symbol = getSymbol(x);
                temp = symbol + temp;
                numberInt /= system;
            }
        }
        return temp;
    }
    public static char getSymbol(int number) {
        if (number <= 9) {
            return (char)(number + '0');
        } else {
            return (char)(number - 10 + 'A');
        }
    }
}