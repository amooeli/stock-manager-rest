package stockmanager.task.exception;

/**
 * @author ali
 */
public class StockManagerException extends Exception {
    public StockManagerException(String msg) {
        super(msg);
    }

    public StockManagerException(String msg, Throwable e) {
        super(msg, e);
    }
}

