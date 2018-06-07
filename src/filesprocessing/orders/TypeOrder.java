package filesprocessing.orders;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class TypeOrder implements Order {
    private static final String DEFAULT_FILE_TYPE = "file";
    /**
     * Get file type - the string after the last period, or file if no periods exist
     * @param fileName Name of the file
     * @return file type
     */
    private static String getType(String fileName) {
        String fileType;
        if (fileName.contains(".")) {
            String[] splitByDelimiter = fileName.split(Pattern.quote("."));
            fileType = splitByDelimiter[splitByDelimiter.length - 1];
        } else {
            fileType = DEFAULT_FILE_TYPE;
        }
        return fileType;
    }

    /**
     * Returns a list of files, ordered according to the implementation
     * @param files files to order
     * @return ordered list
     */
    @Override
    public List<File> getFilesInOrder(List<File> files) {
        files.sort(new TypeComparator());
        return files;
    }

    /**
     * a Comparator, which compares files according to their file type. If two files
     * have an equal size - an absolute path ordering is imposed
     */
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
