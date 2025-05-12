public class ValidationException extends Exception {

    public ValidationException(String erro) {
        super(erro);
    }

    public ValidationException(String erro, Throwable causa) {
        super(erro, causa);

    }

}



