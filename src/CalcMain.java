public class CalcMain {

    public static void main(String[] args) {

        args = args.length == 0 ? InOperation.giveMeArgs() : args;

        if(!Arguments.verifyArguments(args)) {
            System.out.println("Ошибка ввода. Попробуйте еще раз, пожалуйста!");
            System.exit(1);
        }

        OutputOperation.outputResult(args);
    }
}
