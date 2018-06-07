package filesprocessing.filters;
import java.io.File;

/**
 * This class implements filter that verify that size of checked file is greater than lower bound.
 */
public class SmallerThanFilter extends SizeFilter {
	/*minimal size bound. */
	private double minSize;

	/**
	 * this method is create filter with inserted minimal bound
	 * @param minSize minimal appropriate size.
	 */
	public SmallerThanFilter(double minSize) {
		this.minSize = minSize;
	}

	/**
	 * this function verify if file is appropriate for filter
	 * @param file file that have to be checked
	 * @return true if file is appropriate,false otherwise.
	 */
	@Override
	public boolean isPassFilter(File file) {
		return getSizeInKilobytes(file) < minSize;
	}
}
