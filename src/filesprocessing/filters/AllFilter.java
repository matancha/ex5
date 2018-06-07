package filesprocessing.filters;

import java.io.File;

/**
 * this filter implements filter that passes each file.
 */
public class AllFilter implements Filter{
    AllFilter(){ }

    /**
     * this function verify if file is appropriate for filter
     * @param file file that have to be checked
     * @return true if file is appropriate,false otherwise.
     */
    @Override
    public boolean isPassFilter(File file) {
        return true;
    }
}
