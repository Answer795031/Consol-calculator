import java.util.Scanner;                               // Вызываем Scanner
public class Calculator {
    static Scanner scanner = new Scanner(System.in);    // Объявляем метод Scanner для ввода значений в консоль

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static int getInt(){                         // Метод, отвечающий за ввод чисел для вычислений
        System.out.print("Введите число: ");
        int num;
        if(scanner.hasNextInt()){                       // Проверка на соответстиве числа типу int
            num = scanner.nextInt();                    // Записываем число в переменную num
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();                             // Рекурсия в случае ошибки при вводе числа
            num = getInt();                             // Повтор
        }
        return num;                                     // Возвращаем значение num для записи в num1 в main()
    }

    public static char getOperation(){                  // Метод, отвечающий за выбор операции, производимой над числами
        System.out.print("Введите операцию: ");
        char operation;                                 // Зададим 4 операции типом char: '+', '-', '*', '/'
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();                             // Рекурсия
            operation = getOperation();
        }
        return operation;                               // Возвращаем значение operation для метода main()
    }

    public static int calc(int num1, int num2, char operation){     // Метод, отвечающий непосредственно за вычисления
        int result;
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());          // Рекурсия
        }
        return result;                                              // Возвращаем значение result
    }
}
