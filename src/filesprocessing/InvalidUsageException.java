package filesprocessing;

public class InvalidUsageException extends TypeTwoException {
    @Override
    public String getMsg() {
        return "Invalid parameters were inserted";
    }
}
