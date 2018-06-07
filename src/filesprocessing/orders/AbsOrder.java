package filesprocessing.orders;
import java.io.*;
import java.util.Comparator;
import java.util.List;

/**
 * Orders file according to their absolute path in the filesystem.
 */
public class AbsOrder implements Order {
	/**
	 * Returns a list of files, ordered according to the implementation
	 * @param files files to order
	 * @return ordered list
	 */
	@Override
	public List<File> getFilesInOrder(List<File> files) {
		files.sort(Comparator.comparing(File::getAbsolutePath));
		return files;
	}
}
