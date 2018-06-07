package filesprocessing.orders;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * Orders files in a given order, but in reverse
 */
public class ReverseOrder implements Order {
	/**
	 * Type of ordering to reverse
	 */
	private Order order;

	/**
	 * Reverse constructor
	 * @param order Order to reverse
	 */
	ReverseOrder(Order order) {
		this.order = order;
	}

	/**
	 * Returns a list of files, ordered according to the implementation
	 * @param files files to order
	 * @return ordered list
	 */
	@Override
	public List<File> getFilesInOrder(List<File> files) {
		List<File> filesToOrder = order.getFilesInOrder(files);
		Collections.reverse(filesToOrder);
		return filesToOrder;
	}
}
