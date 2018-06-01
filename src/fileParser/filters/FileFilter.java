package fileParser.filters;
import java.io.File;

public class FileFilter extends NameFilter {
	private String value;

	public FileFilter(File file, String value) {
		this.value = value;
	}

	@Override
	public boolean isPassFilter(File file) {
		return file.getName().equals(value);
	}
}
