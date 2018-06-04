package filesprocessing.filters;

import java.io.File;

public class BetweenFilter extends SizeFilter {
	private double minSize;
	private double maxSize;

	public BetweenFilter(double minSize, double maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}

	@Override
	public boolean isPassFilter(File file) {
		return getSizeInKilobytes(file) >= minSize && getSizeInKilobytes(file) <= maxSize;
	}
}
