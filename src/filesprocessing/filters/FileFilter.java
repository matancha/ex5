package filesprocessing.filters;
import java.io.File;

public class FileFilter extends FileNameFilter {
	private String value;

	public FileFilter(String value) {
		this.value = value;
	}

	@Override
	public boolean isPassFilter(File file) {
		return file.getName().equals(value);
	}
}
