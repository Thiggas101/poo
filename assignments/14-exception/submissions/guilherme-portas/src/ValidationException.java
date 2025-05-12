public class ValidationException extends Exception{
    public ValidationException(String msgErro) {
        super(msgErro);
    }

    public ValidationException(Throwable causa) {

    }
}