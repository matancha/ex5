package filesprocessing;

/**
 * this class implements exception that thrown in case of wrong number of parameters.
 * For example if there were just 1 or 0 parameters inserted,or on the contrary,3 or more.
 */
public class ParametersNumberException extends TypeTwoException {
    /**
     *
     * @return message that wrong number of parameters were given.
     */
    public String getMsg() {
        return "Wrong number of parameters were given.";
    }
}
