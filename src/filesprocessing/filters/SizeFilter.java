package filesprocessing.filters;
import java.io.*;

/**
 * This filter implements abstract filter that are connected in some way to size bounds.
 */
public abstract class SizeFilter implements Filter {

	/**
	 * this method is transfer size of file from bites to kbites.
	 * @param file file which size will be transferred
	 * @return size in kbites.
	 */
	protected double getSizeInKilobytes(File file) {
		return file.length() / 1024.0;
	}
}
