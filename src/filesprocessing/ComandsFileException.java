package filesprocessing;

/**
 * this class implements exception that thrown in case that format of commands file is not appropriate.
 */
public class ComandsFileException extends TypeTwoException{

    /**
     *
     * @return Massage that commands file format is not appropriate.
     */
    @Override
    public String getMsg() {
        return "Bad format of the commands file.";
    }
}
