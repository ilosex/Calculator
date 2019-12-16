class RomanNumber {
    private String name;
    private RomanNumber(String name) {
        this.name = name;
    }

    /**
     * Метод toRomanNumber возвращает объект типа римское число по введенной строке
     * @param s - введенная строка
     * @return объект римское число, соответствующий вееденной строке
     */
    static RomanNumber toRomanNumber(String s) {
        return new RomanNumber (s);
    }

    /**
     * Метод parseInt преобразует римское число к числу типа Integer
     * @return число типа Integer
     */
    int parseInt() {
        String[] digits = this.name.trim().split("");
        int[] intDigits = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            intDigits[i] = RomanDigit.toRomanDigit(digits[i]).toInteger();
        }
        System.out.println(intCombiner(intDigits));
        return intCombiner(intDigits);
    }

    /**
     * Метод intCombiner подготавливает к выводу число на основе введенных цифр
     * @param args - вводной массив цифр
     * @return число типа Integer
     */
    private int intCombiner (int[] args) {
        int result = 0;
        int oldArgs = 0;

        if (args.length == 1) return args[0];
        for(int i = args.length - 1; i >= 0; i--) {

            if(oldArgs > args[i]) {
                int j = i;
                while (j >= 0) {
                   if (oldArgs <= args[j]) break;
                   j--;
                }
                int newArgsLength = i - j;
                int[] newArgs = new int[newArgsLength];
                System.arraycopy(args, j + 1, newArgs, 0,  newArgsLength);
                result -= intCombiner(newArgs);
                i = j + 1;
            } else result += args[i];
            oldArgs = args[i];
        }
        return result;
    }

    /**
     * Метод parseRomanNumberName принимает число в формате Integer и возвращает его в формате римского числа
     * @param number - число в формате Integer
     * @return число в формате римского числа
     */
    static String parseRomanNumberName(int number){
        String resultRomanString = "";
        RomanDigit[] romanDigits = RomanDigit.values();
        int numberOrder = (int)Math.floor(Math.log10(number)),
            temp;

        for (int i  = numberOrder; i > 0; i--){
            temp =  number / (int) (Math.pow(10, i));
            number -= temp * (int) (Math.pow(10, i));

            if (temp == romanDigits[1].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[2*i -1].name());
            }

            else if (temp == romanDigits[2].toInteger() - romanDigits[0].toInteger()){
                resultRomanString = resultRomanString.concat(romanDigits[2*(i - 1)].name()).concat(romanDigits[2*i].name());
            }

            else if (temp == romanDigits[1].toInteger() - romanDigits[0].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[2*(i - 1)].name()).concat(romanDigits[2*i - 1].name());
            }

            else if (temp > romanDigits[1].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[2*i - 1].name());

                for (int j = temp; j > 0; j--) {
                    resultRomanString = resultRomanString.concat(romanDigits[2 * i].name());
                }
            }

            else {

                for (int j = temp; j > 0; j--) {
                    resultRomanString = resultRomanString.concat(romanDigits[2 * i].name());
                }
            }
            numberOrder--;
        }

        if (numberOrder == 0) {

            if (number == romanDigits[2].toInteger() - romanDigits[0].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[0].name()).concat(romanDigits[2].name());
            }

            else if (number == romanDigits[1].toInteger() - romanDigits[0].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[0].name()).concat(romanDigits[1].name());
            }

            else if (number == romanDigits[1].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[1].name());
            }

            else if (number > romanDigits[1].toInteger()) {
                resultRomanString = resultRomanString.concat(romanDigits[1].name());
                number -= romanDigits[1].toInteger();

                for (int j = number; j > 0; j--) {
                    resultRomanString = resultRomanString.concat(romanDigits[0].name());
                }
            }

            else {
                for (int j = number; j > 0; j--) {
                    resultRomanString = resultRomanString.concat(romanDigits[0].name());
                }
            }
        }

        return resultRomanString;
    }
}
