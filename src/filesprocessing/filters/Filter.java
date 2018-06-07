package filesprocessing.filters;
import java.io.*;

/**
 * This class implements abstract filter
 */
public interface Filter {
	/**
	 * this function verify if file is appropriate for filter
	 * @param file file that have to be checked
	 * @return true if file is appropriate,false otherwise.
	 */
	public boolean isPassFilter(File file);
}
