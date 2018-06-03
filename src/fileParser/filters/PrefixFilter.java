package fileParser.filters;
import java.io.File;

public class PrefixFilter extends FileNameFilter{
    private String prefix;
    PrefixFilter(String prefix){this.prefix=prefix;}
    @Override
    public boolean isPassFilter(File file) {
        return file.getName().startsWith(prefix);
    }
}
