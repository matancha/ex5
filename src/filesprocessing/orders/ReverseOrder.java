package filesprocessing.orders;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class ReverseOrder implements Order {
	private Order order;

	public ReverseOrder(Order order) {
		this.order = order;
	}

	@Override
	public List<File> getFilesInOrder(List<File> files) {
		List<File> filesToOrder = order.getFilesInOrder(files);
		Collections.reverse(filesToOrder);
		return filesToOrder;
	}
}
