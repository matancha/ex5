package fileParser.filters;

import fileParser.BadParametersException;

public class BooleanParameterException extends BadParametersException{
    @Override
    public String getMsg() {
        return "invalid boolean parameter,options YES or NO";
    }
}
