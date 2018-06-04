package filesprocessing;
import java.io.*;
import java.util.*;
import filesprocessing.TypeOneException;
import filesprocessing.filters.*;
import filesprocessing.orders.*;
import java.util.regex.Pattern;

public class Parser {
	public static ArrayList<Subsection> parse(File commandsFile) {
		ArrayList<Subsection> subsectionList = new ArrayList<>();
		try {
			LineNumberReader fileContents = new LineNumberReader(new FileReader(commandsFile));
			String currentLine = fileContents.readLine();
			while (currentLine != null) {
				ArrayList<Filter> filters = new ArrayList<Filter>();
				try {
					while (! currentLine.equals("ORDER")){
						currentLine = fileContents.readLine();
						Filter filter = FilterFactory.createFilter(currentLine.split(Pattern.quote("#")));
						filters.add(filter);
						currentLine = fileContents.readLine();
					}
					currentLine = fileContents.readLine();
					Order order = OrderFactory.createOrder(currentLine.split(Pattern.quote("#")));
					subsectionList.add(new Subsection(filters, order));
					currentLine = fileContents.readLine();
				} catch (TypeOneException e) {
					System.err.println(String.format("Warning in line %d: %s", fileContents.getLineNumber(),
							e.getMsg()));
				}
			}
		} catch (IOException e) {
			return null;
		}
		return subsectionList;
	}
}
