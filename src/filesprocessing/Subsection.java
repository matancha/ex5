package filesprocessing;
import filesprocessing.filters.*;
import filesprocessing.orders.*;
import java.util.*;

/**
 * Class representing a subsection in commands file
 */
public class Subsection {
	/* List of filters to apply to files */
	private ArrayList<Filter> filterList;
	/* Order to apply */
	private Order order;
	/* Warnings from run */
	private List<String> warnings;

	/**
	 * Constructor
	 * @param filters filters to apply
	 * @param order order
	 * @param warnings warnings from run
	 */
	Subsection(ArrayList<Filter> filters, Order order,List<String> warnings){
		this.filterList = filters;
		this.order = order;
		this.warnings = warnings;
	}

	/**
	 * Get order
	 * @return Order obj
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Get warnings
	 * @return List of warnings
	 */
	public List<String> getWarnings() {
		return warnings;
	}

	/**
	 * Get filters list
	 * @return Filters List
	 */
	public ArrayList<Filter> getFilterList() {
		return filterList;
	}
}
