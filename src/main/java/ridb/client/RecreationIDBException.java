package ridb.client;

public class RecreationIDBException extends Exception{
    public RecreationIDBException(String message) {
        super(message);
    }

    public RecreationIDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecreationIDBException(Throwable cause) {
        super(cause);
    }

    protected RecreationIDBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
