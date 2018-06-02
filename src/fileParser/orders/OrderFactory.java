package fileParser.orders;
import fileParser.TypeOneException;

public class OrderFactory {
	public static Order createOrder(String[] filterString) throws TypeOneException {
		Order order;

		switch (filterString[0]) {
			case "size":
				order = new SizeOrder();
				break;
			case "type":
				order = new TypeOrder();
				break;
			default:
		}

		return order;
	}
}
