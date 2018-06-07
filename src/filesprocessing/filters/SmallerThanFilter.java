package filesprocessing.filters;
import java.io.File;

/**
 * This
 */
public class SmallerThanFilter extends SizeFilter {
	private double minSize;

	public SmallerThanFilter(double minSize) {
		this.minSize = minSize;
	}

	@Override
	public boolean isPassFilter(File file) {
		return getSizeInKilobytes(file) < minSize;
	}
}
