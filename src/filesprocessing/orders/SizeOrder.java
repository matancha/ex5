package filesprocessing.orders;
import java.io.File;
import java.util.*;

public class SizeOrder implements Order {
	SizeOrder() {
	}

	@Override
	public File[] getFilesInOrder(File[] files) {
		Arrays.sort(files, (o1, o2) -> Long.compare(o1.length(), o2.length()));
		return files;
	}
}
