package filesprocessing.filters;
import java.io.*;

public interface Filter {
	public boolean isPassFilter(File file);
}
