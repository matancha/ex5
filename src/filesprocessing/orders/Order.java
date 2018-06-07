package filesprocessing.orders;
import java.io.*;
import java.util.*;

/**
 * Ordering interface for
 */
public interface Order {
	/**
	 * Returns a list of files, ordered according to the implementation
	 * @param files files to order
	 * @return ordered list
	 */
	List<File> getFilesInOrder(List<File> files);
}
