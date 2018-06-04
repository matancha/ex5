package filesprocessing;
import filesprocessing.filters.*;
import filesprocessing.orders.*;

import java.util.ArrayList;

public class Subsection {
	private ArrayList<Filter> filterList;
	private Order order;

	public Subsection(ArrayList<Filter> filters, Order order){
		this.filterList = filters;
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public ArrayList<Filter> getFilterList() {
		return filterList;
	}
}
