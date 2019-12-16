import java.util.NoSuchElementException;

/**
 * Перечисление доступных видов римских цифр
 */
enum RomanDigit {
    I {
        @Override
        public int toInteger() {
            return 1;
        }
    },

    V {
        @Override
        public int toInteger() {
            return 5;
        }
   },

    X {
        @Override
        public int toInteger() {
            return 10;
        }

    };

    /**
     * Метод toInteger возвращает значетие римской цифры в формате Integer
     * @return цифру в формате Integer
     */
    abstract int toInteger();

    /**
     * Метод notConsistsOf проверяет существование римской цифры по введенному имени
     * @param s - введенное имя
     * @return возвращает true, если римской цифры соответсвующей введенной строке не существует
     */
    static boolean notConsistsOf(String s) {
        for(RomanDigit num: RomanDigit.values()){
           if (num.toString().equals(s)) return false;
        }
        return true;
    }

    /**
     * Метод toRomanDigit преобразует введенное число типа Integer, данного в виде строки, в объект римской цифры
     * @param s - введенная цифра в формате строки
     * @return римскую цифру
     */
    static RomanDigit toRomanDigit (String s) {
        RomanDigit digit = null;

        if (notConsistsOf(s)) throw new NoSuchElementException("Нет такой римской цифры!");

        for (RomanDigit num: RomanDigit.values()) {
            if (num.toString().equals(s)) digit = num;
        }
        return digit;
    }
}
