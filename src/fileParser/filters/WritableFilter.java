package fileParser.filters;
import java.io.File;

public class WritableFilter extends Filter {
	private File file;

	public WritableFilter(File file) {
		this.file = file;
	}

	@Override
	public boolean isPassFilter() {
		return file.canWrite();
	}
}
