package fileParser;

public abstract class BadNameException extends fileParser.TypeOneException {
    @Override
    public abstract String getMsg();
}
