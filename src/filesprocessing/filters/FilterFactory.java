package filesprocessing.filters;
import filesprocessing.BadParametersException;
import filesprocessing.TypeOneException;

/**
 * this class implements filter factory for creating filter of files.
 */
public class FilterFactory {
	/**
	 * this function creates one of existing filters,according to string that was inserted.
	 * @param filterString-string contains parameters of filter
	 * @return filter that appropriate for requirements.
	 * @throws TypeOneException-exception that thrown in case of Bad parameters.
	 * @throws ClassCastException-exceptionof java,that thrown when wrong casting was made.
	 */
	public static Filter createFilter(String[] filterString) throws TypeOneException, ClassCastException {
		Filter filter;
		switch (filterString[0]) {
			case "greater_than":
				filter=greaterThanFilter(filterString);
				break;
			case "smaller_than":
				filter=smallerThanFilter(filterString);
				break;
			case "between":
				filter=betweenFilter(filterString);
				break;
			case "file":
				filter=fileFilter(filterString);
				break;
			case "contains":
				filter=containsFilter(filterString);
				break;
			case "prefix":
				filter=prefixFilter(filterString);
				break;
			case "suffix":
				filter=suffixFilter(filterString);
				break;
			case "writable":
				filter=writableFilter(filterString);
				break;
			case "executable":
				filter=executableFilter(filterString);
				break;
			case "hidden":
				filter=hiddenFilter(filterString);
				break;
			case "all":
				filter=allFilter(filterString);
				break;
			default:
				throw new BadParametersException();
		}
		if (filterString[filterString.length-1].equals("NOT")){
			filter=new NegFilter(filter);
		}
		return filter;
	}

	/**
	 * this method correstnes of arguments
	 * @param args string of filter parameters
	 * @param minNumOfArguments-minimal number of parameters appropriate for some of filters
	 * for some of filters is different.
	 * @return true if there is appropriate number of parameters,else throw exception.
	 * @throws BadParametersException-exception that thrown if parameters are not appropriate.
	 */
	private static boolean checkNumOfArguments(String[] args, int minNumOfArguments) throws BadParametersException {
		if (args.length > minNumOfArguments+2 || args.length < minNumOfArguments+1) {
			throw new BadParametersException();
		} else if (args.length == minNumOfArguments+2 && ! args[minNumOfArguments+1].equals("NOT")){
			throw new BadParametersException();
		} else {
			return true;
		}
	}

	/**
	 * this method return default filter.
	 * @return default filter.
	 */
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

	/**
	 * this method return filter "greaterThanFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "greaterThanFilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter greaterThanFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		double maxSize = Double.parseDouble(filterString[1]);
		if (maxSize < 0) {
			throw new BadParametersException();
		}
		return new GreaterThanFilter(maxSize);
	}

	/**
	 * this method return filter "SmallerThanFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "smallerThanFilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter smallerThanFilter(String[] filterString) throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		double minSize=Double.parseDouble(filterString[1]);
		if (minSize < 0) {
			throw new BadParametersException();
		}
		return new SmallerThanFilter(minSize);
	}

	/**
	 * this method return filter "BetweenFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "BetweenThan"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter betweenFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 2)){
			throw new BadParametersException();
		};
		double minSize=Double.parseDouble(filterString[1]);
		double maxSize=Double.parseDouble(filterString[2]);
		if (minSize>maxSize){
			throw new BadParametersException();
		}else if(minSize<0||maxSize<0){
			throw new BadParametersException();
		}
		return new BetweenFilter(minSize,maxSize);
	}

	/**
	 * this method return filter "ContainsFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "containsFilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter containsFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		String stringForSearching=(filterString[1]);
		return new ContainsFilter(stringForSearching);
	}

	/**
	 * this method return filter "IdenticalNameFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "IdenticalNameFilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter fileFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		String stringForChecking=(filterString[1]);
		return new IdenticalNameFilter(stringForChecking);
	}

	/**
	 * this method return filter "prefixFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "Prefixfilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter prefixFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		String prefix=(filterString[1]);
		return new PrefixFilter(prefix);
	}

	/**
	 * this method return filter "SuffixFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "SuffixFilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter suffixFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		String suffix=(filterString[1]);
		return new SuffixFilter(suffix);
	}

	/**
	 * this method return filter "WritableFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "WritableFilter"
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter writableFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		boolean answer=turnToBoolean(filterString[1]);
		return new WritableFilter(answer);
	}

	/**
	 * this method return filter "executableFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "executableFilter".
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter executableFilter(String[] filterString)throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		}
		boolean answer=turnToBoolean(filterString[1]);
		return new ExecutableFilter(answer);
	}

	/**
	 * this method return filter "hiddenFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "hiddenFilter".
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter hiddenFilter(String[] filterString) throws BadParametersException{
		if (! checkNumOfArguments(filterString, 1)){
			throw new BadParametersException();
		};
		boolean answer=turnToBoolean(filterString[1]);
		return new HiddenFilter(answer);
	}

	/**
	 * this method return filter "allFilter" according to inserted parameters.
	 * @param filterString string that contains filter parameters.
	 * @return filter "all".
	 * @throws BadParametersException-exception that thrown in case of invalid parameters.
	 */
	private static Filter allFilter(String[] filterString) throws BadParametersException{
		if (! checkNumOfArguments(filterString, 0)){
			throw new BadParametersException();
		}
		return new AllFilter();
	}

}
