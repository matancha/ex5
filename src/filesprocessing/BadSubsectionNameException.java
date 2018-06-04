package filesprocessing;

public class BadSubsectionNameException extends TypeTwoException{
    @Override
    public String getMsg() {
        return "invalid sub-section name";
    }
}
