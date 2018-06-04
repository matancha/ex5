package filesprocessing.filters;

import java.io.File;

public class HiddenFilter extends FileFeaturesFilter{
    private boolean answer;
    public HiddenFilter(boolean answer) {this.answer=answer;}

    @Override
    public boolean isPassFilter(File file) {
        return file.isHidden()==answer;
    }
}
