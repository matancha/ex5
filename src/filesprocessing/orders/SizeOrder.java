package filesprocessing.orders;
import java.io.File;
import java.util.*;

/**
 * Orders file according to their size
 */
public class SizeOrder implements Order {
	/**
	 * Returns a list of files, ordered according to the implementation
	 * @param files files to order
	 * @return ordered list
	 */
	@Override
	public List<File> getFilesInOrder(List<File> files) {
		files.sort(new SizeComparator());
		return files;
	}

	/**
	 * a Comparator, which compares files according to their size. If two files
	 * have an equal size - an absolute path ordering is imposed
	 */
	private class SizeComparator implements Comparator<File> {
		@Override
		public int compare(File o1, File o2) {
			int sizeComparison = Long.compare(o1.length(), o2.length());
			if (sizeComparison != 0) {
				return sizeComparison;
			} else {
				return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
			}
		}
	}
}
