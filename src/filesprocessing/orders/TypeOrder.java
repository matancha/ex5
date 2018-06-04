package filesprocessing.orders;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class TypeOrder implements Order {
    private String getType(String fileName) {
        String[] splitByDelimiter = fileName.split(Pattern.quote("."));
        return splitByDelimiter[splitByDelimiter.length - 1];
    }

    private void swap(File[] files, int index) {
        File fileForSwap = files[index];
        files[index] = files[index + 1];
        files[index + 1] = fileForSwap;
    }

    @Override
    public List<File> getFilesInOrder(List<File> files) {
        files.sort(new TypeComparator());
        return files;
    }

    private class TypeComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            int typeComparison = getType(o1.getName()).compareTo(getType(o2.getName()));
            if (typeComparison != 0) {
                return typeComparison;
            } else {
                return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
            }
        }
    }
}
