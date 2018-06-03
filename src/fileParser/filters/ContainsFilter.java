package fileParser.filters;

import java.io.File;

public class ContainsFilter extends FileNameFilter{
    private String stringForSearcing;
    ContainsFilter(String stringForSearcing){this.stringForSearcing=stringForSearcing;}
    @Override
    public boolean isPassFilter(File file) {
        return file.getName().contains(stringForSearcing);
    }
}
