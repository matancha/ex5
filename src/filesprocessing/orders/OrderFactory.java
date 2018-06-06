package filesprocessing.orders;
import filesprocessing.BadParametersException;
import filesprocessing.TypeOneException;

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
			case "abs":
				order=new AbsOrder();
				break;
			default:
				throw new BadParametersException();
		}

		if (filterString[filterString.length-1].equals("REVERSE")){
			order=new ReverseOrder(order);
		}

		return order;
	}
	public static Order getDefaultOrder(){
		return new AbsOrder();
	}
}
