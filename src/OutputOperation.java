public class OutputOperation {
    private static String formatOutput (String[] args) {
        String formattedResult = "";

        if(Arguments.isInteger(args[0])) formattedResult = Integer.toString(CalcOperation.calculation(args));
        else if (Arguments.isRomanNumber(args[0]))
            formattedResult = RomanNumber.parseRomanNumberName(CalcOperation.calculation(args));
        return formattedResult;
    }

    static void outputResult (String[] args) {
        String inputString = "";

        for(String arg: args){
            inputString = inputString.concat(arg).concat(" ");
        }

        System.out.println(inputString.concat("= ").concat(OutputOperation.formatOutput(args)));

    }

}
