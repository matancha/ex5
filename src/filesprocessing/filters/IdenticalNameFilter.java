package filesprocessing.filters;
import java.io.File;

/**
 * this class implements filter that check if name of file is the same as inserted file's name.
 */
public class IdenticalNameFilter extends FileNameFilter {
	/*string that will be compared with name of the file. */
	private String value;

	/**
	 * this method creates filter with inserted string.
	 * @param value-string that will be searched in name of file.
	 */
	public IdenticalNameFilter(String value) {
		this.value = value;
	}

	/**
	 * this function verify if file is appropriate for filter
	 * @param file file that have to be checked
	 * @return true if file is appropriate,false otherwise.
	 */
	@Override
	public boolean isPassFilter(File file) {
		return file.getName().equals(value);
	}
}
