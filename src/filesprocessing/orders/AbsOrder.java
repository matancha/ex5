package filesprocessing.orders;
import java.io.*;
import java.util.Arrays;

public class AbsOrder implements Order {
	AbsOrder() {
	}

	@Override
	public File[] getFilesInOrder(File[] files) {
		Arrays.sort(files, (o1, o2) -> o1.getAbsolutePath().compareTo(o2.getAbsolutePath()));
		return files;
	}
}
