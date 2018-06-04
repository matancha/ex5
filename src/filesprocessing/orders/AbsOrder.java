package filesprocessing.orders;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AbsOrder implements Order {
	@Override
	public List<File> getFilesInOrder(List<File> files) {
		files.sort(Comparator.comparing(File::getAbsolutePath));
		return files;
	}
}
