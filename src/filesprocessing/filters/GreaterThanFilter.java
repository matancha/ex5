package filesprocessing.filters;
import java.io.File;

public class GreaterThanFilter extends SizeFilter {
	private double maxSize;

	public GreaterThanFilter(double maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public boolean isPassFilter(File file) {
		return getSizeInKilobytes(file) > maxSize;
	}
}
