package fileParser.orders;
import com.sun.glass.ui.Size;
import fileParser.TypeOneException;

public class OrderFactory {
	public static Order createOrder(String[] filterString) throws TypeOneException {
		Order order;

		switch (filterString[0]) {
			case "size":
				order = new SizeOrder();
				break;
			default:
		}

		return order;
	}
}
