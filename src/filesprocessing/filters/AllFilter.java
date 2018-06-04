package filesprocessing.filters;

import java.io.File;

public class AllFilter implements Filter{
    AllFilter(){ }

    @Override
    public boolean isPassFilter(File file) {
        return true;
    }
}
