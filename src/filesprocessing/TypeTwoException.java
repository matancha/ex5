package filesprocessing;

/**
 * this class implements Exception that thrown in case when There is no way
 * to continue filtering of files,consequently it will be stoped and
 * Error will be printed according to message of the Exception.
 */
public abstract class TypeTwoException extends Exception{
    /**
     *
     * @return message that describes an error.
     */
    public abstract String getMsg();
}
