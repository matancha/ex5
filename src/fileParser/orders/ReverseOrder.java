package fileParser.orders;

import java.io.File;

public class ReverseOrder implements Order {
	@Override
	public File[] getFilesInOrder(File[] files) {
		for (int i = 0; i < files.length/2; i++)
		{
			File temp = files[i];
			files[i] = files[files.length-1-i];
			files[files.length-1-i] = temp;
		}
		return files;
	}
}
