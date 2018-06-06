package filesprocessing.orders;
import java.io.File;
import java.util.*;

public class SizeOrder implements Order {
	SizeOrder() {
	}

	@Override
	public List<File> getFilesInOrder(List<File> files) {
		files.sort(new SizeComparator());
		return files;
	}

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
