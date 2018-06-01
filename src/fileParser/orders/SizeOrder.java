package fileParser.orders;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SizeOrder implements Order {
	SizeOrder() {
	}

	@Override
	public File[] getFilesInOrder(File[] files) {
		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return Long.compare(o1.length(), o2.length());
			}
		});
	}
}
