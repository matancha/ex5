package filesprocessing.filters;
import java.io.*;

/**
 * this class implements decorator for inserted filter. It will return opposite result of inserted filter.
 * In other words it will return false when original filter will return true and wise versa.
 */
public class NegFilter implements Filter {
	/*filter for decoration. */
	private Filter filter;

	/**
	 * this method create wrapper of inserted filter.
	 * @param filter for decoration.
	 */
	public NegFilter(Filter filter) {
		this.filter = filter;
	}

	/**
	 * this function verify if file is NOT appropriate for inserted filter
	 * @param file file that have to be checked
	 * @return true if file is not appropriate for original filter,false otherwise.
	 */
	@Override
	public boolean isPassFilter(File file) {
		return (!filter.isPassFilter(file));
	}
}
