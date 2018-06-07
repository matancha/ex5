package filesprocessing.filters;

import java.io.File;

/**
 * this class implements filter that check if name of file is contains an inserted string.
 */
public class ContainsFilter extends FileNameFilter{
    /*string that will be searched in name of the file. */
    private String stringForSearcing;

    /**
     * this method creates filter with inserted string.
     * @param stringForSearcing-string that will be searched in name of file.
     */
    ContainsFilter(String stringForSearcing){this.stringForSearcing=stringForSearcing;}

    /**
     * this function verify if file is appropriate for filter
     * @param file file that have to be checked
     * @return true if file is appropriate,false otherwise.
     */
    @Override
    public boolean isPassFilter(File file) {
        return file.getName().contains(stringForSearcing);
    }
}
