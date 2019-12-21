public class OutputOperation {

    /**
     * Метод formatOutput определяет в каком виде введены аргументы и отдает результат вычислений в том же виде
     * @param args - входные аргументы
     * @return форматированный результат вычислений
     */
    private static String formatOutput (String[] args) {
        String formattedResult = "";

        if(Arguments.isInteger(args[0])) formattedResult = Integer.toString(CalcOperation.calculation(args));
        else if (Arguments.isRomanNumber(args[0]))
            formattedResult = RomanNumber.parseRomanNumberName(CalcOperation.calculation(args));
        return formattedResult;
    }

    /**
     * Метод outputResult принимает входной массив аргументов и выводит результат вычислений на экран
     * @param args - входной массив аргументов
     */
    static void outputResult (String[] args) {

        System.out.println(OutputOperation.formatOutput(args));
    }

}
