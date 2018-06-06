package filesprocessing.filters;
import filesprocessing.BadParametersException;
import filesprocessing.TypeOneException;

public class FilterFactory {
	public static Filter createFilter(String[] filterString) throws TypeOneException, ClassCastException {
		Filter filter;
		switch (filterString[0]) {
			case "greater_than":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				double maxSize = Double.parseDouble(filterString[1]);
				if (maxSize < 0) {
					throw new BadParametersException();
				}
				filter = new GreaterThanFilter(maxSize);
				break;
			case "smaller_than":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				double minSize=Double.parseDouble(filterString[1]);
				if (minSize < 0) {
					throw new BadParametersException();
				}
				filter = new SmallerThanFilter(minSize);
				break;
			case "between":
				if (! checkNumOfArguments(filterString, 2)){
					throw new BadParametersException();
				};
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
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				String stringForChecking=(filterString[1]);
				filter=new FileFilter(stringForChecking);
				break;
			case "contains":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				String stringForSearching=(filterString[1]);
				filter=new ContainsFilter(stringForSearching);
				break;
			case "prefix":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				String prefix=(filterString[1]);
				filter=new PrefixFilter(prefix);
				break;
			case "suffix":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				String suffix=(filterString[1]);
				filter=new SuffixFilter(suffix);
				break;
			case "writable":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				boolean answer=turnToBoolean(filterString[1]);
				filter=new WritableFilter(answer);
				break;
			case "executable":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				answer=turnToBoolean(filterString[1]);
				filter=new ExecutableFilter(answer);
				break;
			case "hidden":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
				answer=turnToBoolean(filterString[1]);
				filter=new HiddenFilter(answer);
				break;
			case "all":
				if (! checkNumOfArguments(filterString, 1)){
					throw new BadParametersException();
				};
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

	private static boolean checkNumOfArguments(String[] args, int minNumOfArguments) throws BadParametersException {
		if (args.length > minNumOfArguments+2 || args.length < minNumOfArguments+1) {
			throw new BadParametersException();
		} else if (args.length == minNumOfArguments+2 && ! args[minNumOfArguments+1].equals("NOT")){
			throw new BadParametersException();
		} else {
			return true;
		}
	}

	public static Filter getDefaultFilter(){
		return new AllFilter();
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
