package filesprocessing.filters;


import java.io.File;

/**
 * this class implements filter that verify if a filter ends with inserted suffix.
 */
public class SuffixFilter extends FileNameFilter{

    /*pattern for verifying.*/
    private String suffix;

    /**
     * this method creates filter that check if some file ends with inserted string
     * @param suffix string for verifying.
     */
    SuffixFilter(String suffix){this.suffix=suffix;}


    /**
     * this function verify if file is appropriate for filter
     * according to suffix.
     * @param file file that have to be checked
     * @return true if file is appropriate,false otherwise.
     */
    @Override
    public boolean isPassFilter(File file) {
        return file.getName().endsWith(suffix);
    }
}
