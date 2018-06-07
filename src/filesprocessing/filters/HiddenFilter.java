package filesprocessing.filters;

import java.io.File;

/**
 * this class implements filter that check that inserted file is hidden
 * and verify it with string that was inserted.
 */
public class HiddenFilter extends FileFeaturesFilter{

    /*true if file have to be executable,false otherwise. */
    private boolean answer;

    /**
     * this method implements constructor of filter that check if file is hidden.
     * @param answer -true if file have to be hidden,false otherwise.
     */
    public HiddenFilter(boolean answer) {this.answer=answer;}

    /**
     * this function verify if file is appropriate for filter
     * according to answer.
     * @param file file that have to be checked
     * @return true if file is appropriate,false otherwise.
     */
    @Override
    public boolean isPassFilter(File file) {
        return file.isHidden()==answer;
    }
}
