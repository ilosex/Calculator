class Arguments {

    /**
     * Метод verifyArguments получает массив слов и проверяет арифметическое ли это выражение
     * @param args - массив аргументов типа String
     * @return true, если проверка пройдена успешно и false, если это не арифметическое выражение
     */
    static boolean verifyArguments(String[] args){
        boolean integerArgs = false,
                romanNumber = false,
                mathOperatorsIsOk = true;
        for (String arg : args) {
            if (Arguments.isInteger(arg)) integerArgs = true;
            if (Arguments.isRomanNumber(arg)) romanNumber = true;
            if (Arguments.isRomanNumber(arg) && Arguments.isInteger(arg)) mathOperatorsIsOk &= isMathOperator(arg);
        }
        return ((args.length % 2 != 0) && (integerArgs ^ romanNumber) && mathOperatorsIsOk);
    }

    /**
     * Метод isInteger проверяет, содержится ли в входной строке что-то помимомо цифр.
     * @param s - входная строка
     * @return результат проверки
     */
    static boolean isInteger(String s) {
        return s.matches("[0-9]");
    }

    /**
     * Метод isRomanNumber проверяет является ли введенная строка римским числом
     * @param name - введенная строка
     * @return результат проверки
     */
    static boolean isRomanNumber(String name){
        String[] digits = name.trim().split("");
        for(String digit: digits) {
            if (RomanDigit.notConsistsOf(digit)) return false;
        }
        return true;
    }

    /**
     * Метод isMathOperator проверяет введенную строку является ли она математическим оператором
     * @param s - введенная строка
     * @return результат проверки
     */
    private static boolean isMathOperator(String s) {
        return s.length() == 1 && s.matches("[+\\-*/]");
    }

    /**
     * Метод giveMeInIntArgs преобразует введенные числа в различных форматах к типу Integer
     * @param args - введенный массив строк
     * @return введенные числа в формате Integer
     */
    static String[] giveMeInIntArgs(String[] args){

        for(int i = 0; i < args.length; i++){
            if (Arguments.isRomanNumber(args[i])){
                args[i] = Integer.toString(RomanNumber.toRomanNumber(args[i]).parseInt());
            }
        }
        return args;
    }

}
