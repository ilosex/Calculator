public class CalcMain {

    public static void main(String[] args) {
        args = new String[]{"X", "*", "II", "-", "I"};
        /*
         * Проверяем, что получили что-то похожее на пример
         */
        if(!Arguments.verifyArguments(args)) {
            System.out.println("Ошибка ввода. Попробуйте еще раз, пожалуйста!");
            System.exit(1);
        }

        OutputOperation.outputResult(args);

    }
}
