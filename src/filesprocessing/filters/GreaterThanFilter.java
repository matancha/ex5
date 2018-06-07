package filesprocessing.filters;
import java.io.File;


/**
 * This filter is implement filter that verify that size of checked file is less than upper bound.
 */
public class GreaterThanFilter extends SizeFilter {
	/*maximal size bound. */
	private double maxSize;

	/**
	 * this method is create filter with inserted maximal bound
	 * @param maxSize maximal appropriate size.
	 */
	public GreaterThanFilter(double maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * this function verify if file is appropriate for filter
	 * @param file file that have to be checked
	 * @return true if file is appropriate,false otherwise.
	 */
	@Override
	public boolean isPassFilter(File file) {
		return getSizeInKilobytes(file) > maxSize;
	}
}
