package filesprocessing;

/**
 * this subsection is thrown in case that strings "FILTER" or "ORDER"
 * were not founded on places where they have to be.
 */
public class BadSubsectionNameException extends TypeTwoException{
    /**
     *
     * @return massage that invalid name of subsection.
     */
    @Override
    public String getMsg() {
        return "invalid sub-section name";
    }
}
