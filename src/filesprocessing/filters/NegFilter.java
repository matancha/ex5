package filesprocessing.filters;
import java.io.*;

public class NegFilter implements Filter {
	private Filter filter;

	public NegFilter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public boolean isPassFilter(File file) {
		return (!filter.isPassFilter(file));
	}
}
