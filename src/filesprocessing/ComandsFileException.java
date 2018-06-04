package filesprocessing;

public class ComandsFileException extends TypeTwoException{
    @Override
    public String getMsg() {
        return "Bad format of the commands file.";
    }
}
