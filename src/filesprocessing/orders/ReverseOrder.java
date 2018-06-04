package filesprocessing.orders;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class ReverseOrder implements Order {
	@Override
	public List<File> getFilesInOrder(List<File> files) {
		Collections.reverse(files);
		return files;
	}
}
