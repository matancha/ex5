package filesprocessing.filters;
import java.io.File;

public class IdenticalNameFilter extends FileNameFilter {
	private String value;

	public IdenticalNameFilter(String value) {
		this.value = value;
	}

	@Override
	public boolean isPassFilter(File file) {
		return file.getName().equals(value);
	}
}
