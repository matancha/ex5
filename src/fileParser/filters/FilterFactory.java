package fileParser.filters;
import fileParser.TypeOneException;

public class FilterFactory {
	public static Filter createFilter(String[] filterString) throws TypeOneException {
		Filter filter;

		switch (filterString[0]) {
			case "greater_than":
				double maxSize = Double.parseDouble(filterString[1]);
				if (maxSize < 0) {
					throw new NegativeSizeException();
				}
				filter = new GreaterThanFilter(maxSize);
				break;
			case "smaller_than":
				filter = new SmallerThanFilter(Double.parseDouble(filterString[1]));
			default:
				throw new NoMatchedFilterException();
		}

		return filter;
	}
}
