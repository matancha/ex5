package filesprocessing.orders;
import java.io.File;
import java.util.*;

public class SizeOrder implements Order {
	SizeOrder() {
	}

	@Override
	public List<File> getFilesInOrder(List<File> files) {
		files.sort(Comparator.comparingLong(File::length));
		return files;
	}
}
