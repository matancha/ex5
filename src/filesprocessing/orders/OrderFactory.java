package filesprocessing.orders;
import filesprocessing.*;

/**
 * Factory pattern for creating Orders
 */
public class OrderFactory {
	private static final int ORDER_INDEX = 0;
	/**
	 * Initializes Order instances
	 * @param orderArray List containing, order + order arguments
	 * @return Order object
	 * @throws TypeOneException - when illegal parameters are given or invalid order name
	 */
	public static Order createOrder(String[] orderArray) throws TypeOneException {
		Order order;
		switch (orderArray[ORDER_INDEX]) {
			case "size":
				order = new SizeOrder();
				break;
			case "type":
				order = new TypeOrder();
				break;
			case "abs":
				order = new AbsOrder();
				break;
			default:
				throw new BadParametersException();
		}
		if (orderArray[orderArray.length-1].equals("REVERSE")){
			order = new ReverseOrder(order);
		}
		return order;
	}

	/**
	 * Gets default order object
	 * @return default
	 */
	public static Order getDefaultOrder(){
		return new AbsOrder();
	}
}
