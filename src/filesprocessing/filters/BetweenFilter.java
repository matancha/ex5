package filesprocessing.filters;
import java.io.File;

/**
 * this filter implement filter that verify that size of file is between to inserted numbers.
 */
public class BetweenFilter extends SizeFilter {
	/*minimal size bound . */
	private double minSize;
	/*maximal size bound. */
	private double maxSize;

	/**
	 * this method is create filter with inserted bounds
	 * @param minSize lower bound
	 * @param maxSize higher bound
	 */
	public BetweenFilter(double minSize, double maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}

	/**
	 * this function verify if file is appropriate for filter
	 * @param file file that have to be checked
	 * @return true if file is appropriate,false otherwise.
	 */
	@Override
	public boolean isPassFilter(File file) {
		return getSizeInKilobytes(file) >= minSize && getSizeInKilobytes(file) <= maxSize;
	}
}
