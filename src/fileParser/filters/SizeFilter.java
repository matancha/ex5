package fileParser.filters;
import java.io.*;

public abstract class SizeFilter implements Filter {
	protected double getSizeInKilobytes(File file) {
		return file.length() / 1024;
	}
}
