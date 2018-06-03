package fileParser.filters;

import fileParser.BadNameException;

public class BadFilterNameException extends BadNameException{
    @Override
    public String getMsg() {
        return "Wrong name of the Filter";
    }
}
