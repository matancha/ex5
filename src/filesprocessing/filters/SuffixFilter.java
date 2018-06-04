package filesprocessing.filters;


import java.io.File;

public class SuffixFilter extends FileNameFilter{
    private String suffix;
    SuffixFilter(String suffix){this.suffix=suffix;}

    @Override
    public boolean isPassFilter(File file) {
        return file.getName().endsWith(suffix);
    }
}
