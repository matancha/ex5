package filesprocessing.orders;
import java.io.*;
import java.util.*;

public interface Order {
	List<File> getFilesInOrder(List<File> files);
}
