package fileParser.filters;
import fileParser.BadParametersException;

public class NegativeSizeException extends BadParametersException {
    @Override
    public String getMsg() {
        return "negative bound was inserted";
    }
}
