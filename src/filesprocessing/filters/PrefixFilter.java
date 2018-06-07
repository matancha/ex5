package filesprocessing.filters;
import java.io.File;

/**
 * this class implements filter that verify if a filter starts with inserted prefix.
 */
public class PrefixFilter extends FileNameFilter{

    /*string for verifying. */
    private String prefix;

    /**
     * creates filter with inserted string
     * @param prefix string that will be searched in the start of the word.
     */
    PrefixFilter(String prefix){this.prefix=prefix;}

    /**
     * this function verify if file is appropriate for filter
     * according to prefix.
     * @param file file that have to be checked
     * @return true if file is appropriate,false otherwise.
     */
    @Override
    public boolean isPassFilter(File file) {
        return file.getName().startsWith(prefix);
    }
}
