package filesprocessing.orders;
import filesprocessing.TypeOneException;

public class OrderFactory {
	public static Order createOrder(String[] filterString) throws TypeOneException {
		Order order;
		if (filterString!=null){
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
					order = new AbsOrder();
					break;
			}
		}else {
			order=new AbsOrder();
		}


		return order;
	}
}
