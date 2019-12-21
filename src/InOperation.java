import java.util.Scanner;

/**
 * Класс InOperation отвечает за получение входных данных
 */
public class InOperation {

    /**
     * Метод giveMeArgs выдает запрос на ввод арифметического выражения и считывает ввод
     * @return массив слов, принятых от пользователя
     */
    static String[] giveMeArgs(){
        String[] args;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение");
        args = scan.nextLine().trim().split(" ");
        scan.close();
        return args;
    }
}
