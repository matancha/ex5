package filesprocessing;
import filesprocessing.filters.*;
import filesprocessing.orders.*;
import java.util.*;

public class Subsection {
	private ArrayList<Filter> filterList;
	private Order order;
	private List<String> warnings;

	public Subsection(ArrayList<Filter> filters, Order order,List<String> warnings){
		this.filterList = filters;
		this.order = order;
		this.warnings = warnings;
	}

	public Order getOrder() {
		return order;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public ArrayList<Filter> getFilterList() {
		return filterList;
	}
}
