package filesprocessing.filters;

import filesprocessing.BadParametersException;

public class BooleanParameterException extends BadParametersException{
    @Override
    public String getMsg() {
        return "invalid boolean parameter,options YES or NO";
    }
}
