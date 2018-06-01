package fileParser.filters;

public class NegFilter implements Filter {
	private Filter filter;

	public NegFilter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public boolean isPassFilter() {
		return (!filter.isPassFilter());
	}
}
