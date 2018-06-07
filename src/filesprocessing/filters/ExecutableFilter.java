package filesprocessing.filters;

import java.io.File;

/**
 * this class implements filter that check that inserted file is executable
 * and verify it with string that was inserted.
 */
public class ExecutableFilter extends FileFeaturesFilter{
    /*true if file have to be executable,false otherwise. */
    private boolean answer;

    /**
     * this method implements constructor of filter that check if file is executable.
     * @param answer true if file have to be executable,false otherwise.
     */
    public ExecutableFilter(boolean answer) {this.answer=answer;}

    /**
     * this function verify if file is appropriate for filter
     * according to answer.
     * @param file-file that have to be checked
     * @return true if file is appropriate,false otherwise.
     */
    @Override
    public boolean isPassFilter(File file) {
        return file.canExecute()==answer;
    }
}
