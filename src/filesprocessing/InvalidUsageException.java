package filesprocessing;

/**
 * this class implements exception that thrown in case that
 */
public class InvalidUsageException extends TypeTwoException {
    @Override
    public String getMsg() {
        return "Invalid parameters were inserted";
    }
}
