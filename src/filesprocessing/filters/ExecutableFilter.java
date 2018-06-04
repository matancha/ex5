package filesprocessing.filters;

import java.io.File;

public class ExecutableFilter extends FileFeaturesFilter{
    private boolean answer;
    public ExecutableFilter(boolean answer) {this.answer=answer;}

    @Override
    public boolean isPassFilter(File file) {
        return file.canExecute()==answer;
    }
}
