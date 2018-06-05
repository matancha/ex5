package filesprocessing.filters;
import filesprocessing.BadParametersException;
import filesprocessing.TypeOneException;

public class FilterFactory {
	public static Filter createFilter(String[] filterString) throws TypeOneException {
		Filter filter;
		switch (filterString[0]) {
			case "greater_than":
				double maxSize = Double.parseDouble(filterString[1]);
				if (maxSize < 0) {

					throw new BadParametersException();
				}
				filter = new GreaterThanFilter(maxSize);
				break;
			case "smaller_than":

				double minSize=Double.parseDouble(filterString[1]);
				if (minSize < 0) {

					throw new BadParametersException();
				}
				filter = new SmallerThanFilter(minSize);
				break;
			case "between":
				minSize=Double.parseDouble(filterString[1]);
				maxSize=Double.parseDouble(filterString[2]);
				if (minSize>maxSize){
					throw new BadParametersException();
				}else if(minSize<0||maxSize<0){
					throw new BadParametersException();
				}
				filter=new BetweenFilter(minSize,maxSize);
				break;
			case "file":
				String stringForChecking=(filterString[1]);
				filter=new FileFilter(stringForChecking);
				break;
			case "contains":
				String stringForSearching=(filterString[1]);
				filter=new ContainsFilter(stringForSearching);
				break;
			case "prefix":
				String prefix=(filterString[1]);
				filter=new PrefixFilter(prefix);
				break;
			case "suffix":
				String suffix=(filterString[1]);
				filter=new SuffixFilter(suffix);
				break;
			case "writable":
				boolean answer=turnToBoolean(filterString[1]);
				filter=new WritableFilter(answer);
				break;
			case "executable":
				answer=turnToBoolean(filterString[1]);
				filter=new ExecutableFilter(answer);
				break;
			case "hidden":
				answer=turnToBoolean(filterString[1]);
				filter=new HiddenFilter(answer);
				break;
			case "all":
				filter=new AllFilter();
				break;
			default:
				throw new BadParametersException();
		}
		if (filterString[filterString.length-1].equals("NOT")){
			filter=new NegFilter(filter);
		}


		return filter;
	}
	private static boolean turnToBoolean(String answer)throws BadParametersException{
		if(answer.equals("YES")){
			return true;
		}else if(answer.equals("NO")){
			return false;
		}
		throw new BadParametersException();
	}

}
