import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CalcOperation - Класс, реализующий оперцаии, достуные для вычисления нашим калькулятором.
 */
class CalcOperation {

    /**
     * Метод summ суммирует целый аргумент @param x и целый аргумент @param y и возвращает результат выполнения
     * в виде целого числа.
     */
    private static int summ(int x, int y) { return x + y; }

    /**
     * Метод subtraction вычитает из целого аргумента @param x целый аргумент @param y и возвращает результат выполнения
     * в виде целого числа.
     */
    private static int subtraction(int x, int y) { return x - y; }

    /**
     * Метод multiply умножает целый аргумент @param x на целый аргумент @param y и возвращает результат выполнения
     * в виде целого числа.
     */
    private static int multiply(int x, int y) {
        return x * y;
    }

    /**
     * Метод division делит целый аргумент @param x на целый аргумент @param y и возвращает результат выполнения
     * в виде целого числа.
     */
    private static int division(int x, int y) {
        int result = 0;
        try {
            result = x / y;
        } catch (ArithmeticException DivisionByZero) {
            System.out.println("Нельзя делить на ноль!");
        }
        return result;
    }

    /**
     * Метод letsCount служит оберткой для методов сложения, вычитания, деления и умножения
     * @param arg1 - первый аргумент математической операции
     * @param arg2 - второй аргумент математической операции
     * @param operator - обозначение математической операции
     * @return результат выполения математической операции
     */
    private static int letsCount (int arg1, int arg2, String operator) {
        int result = 0;

        switch (operator) {
            case ("+"):
                result = CalcOperation.summ(arg1, arg2);
                break;

            case ("-"):
                result = CalcOperation.subtraction(arg1, arg2);
                break;

            case ("*"):
                result = CalcOperation.multiply(arg1, arg2);
                break;

            case ("/"):
                result = CalcOperation.division(arg1, arg2);
                break;
        }
        return result;
    }

    /**
     * Метод calculation получает введенный пользователем математический пример и, разобрав его на аргументы и операции,
     * производит вычисление ответа заданного примера
     * @param args - введенный пользователем пример в виде массива слов
     * @return результат вычисления примера
     */
     static int calculation (String[] args) {
        List<String> input = new ArrayList<>(args.length);
        args = Arguments.giveMeInIntArgs(args);
        Collections.addAll(input, args);
        boolean flag = true;
        while (input.size() > 1) {
            for(int i = 0; i < input.size(); i++) {
                if(input.get(i).matches(flag ? "[*/]" : "[+-]")) {
                    int argument1, argument2;
                    argument1 = Integer.parseInt(input.get(i - 1));
                    argument2 = Integer.parseInt(input.remove(i + 1));
                    String mathOperator = input.remove(i);
                    String s = Integer.toString(CalcOperation.letsCount(argument1, argument2, mathOperator));
                    input.set(i-1, s);
                    i--;
                }
            }
            flag = false;
        }
        return Integer.parseInt(input.get(0));
    }
}

