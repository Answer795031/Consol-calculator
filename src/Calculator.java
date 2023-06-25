import java.util.Scanner;                               // Вызываем Scanner
public class Calculator {
    static Scanner scanner = new Scanner(System.in);    // Объявляем метод Scanner для ввода значений в консоль

    public static void main(String[] args) {
        /*
        Метод main() присваивает переменным num1 и num2 значения, считанные в методе getDouble(), а так же переменной
        operation значение, считанное в методе getOperation(), после чего передает три значения методу calc().
        Метод calc() возвращает значение result в метод main(), посчле чего происходит вывод результата в консоль.
         */
        double num1 = getDouble();                      // Запись первого числа
        double num2 = getDouble();                      // Запись второго числа
        char operation = getOperation();                // Запись операции
        double result = calc(num1, num2, operation);    // Запись результата
        System.out.println("Результат операции: " + result);
    }

    public static double getDouble(){
        /*
        Метод считывает с консоли число, проверяет его на соответствие типу double, после чего записывает значение
        в переменную num. В случае несоответствия входного числа типу double, происходит рекурсия.
        Метод возвращает переменную num, чтобы в main() мы могли присвоить это значение переменной num1 или num2.
         */
        System.out.print("Введите число: ");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getDouble();          // Рекурсия
        }
        return num;                                     // Возвращаем значение num для  метода main()
    }

    public static char getOperation(){
        /*
        Метод считывает с консоли символ, проверяет его на соответствие типу char.
        Необходимо ввести один из символов: '+', '-', '*', '/', иначе в методе calc() возникнет ошибка, после чего
        программа вызовет рекурсию, попросив повторить ввод команды в getOperation().
        В случае несоответствия вводного символа типу char, происходит рекурсия.
         */
        System.out.print("Введите операцию: ");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();                             // Рекурсия
            operation = getOperation();
        }
        return operation;                               // Возвращаем значение operation для метода main()
    }

    public static double calc(double num1, double num2, char operation){
        /*
        Метод, отвечающий за вычисления над переменными num1 и num2 в соответствии с требуемой операцией.
        Для корректной работы метода необходимы переменные num1 и num2 типа double, а так же знак математической
        операции типа char ('+', '-', '*', '/').
        В случе если в методе getOperation() был считан символ char, отличающийся от требуемых, возникает рекурсия.
         */

        double result;
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
