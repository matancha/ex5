package filesprocessing;
import java.io.*;
import java.util.*;
import filesprocessing.TypeOneException;
import filesprocessing.filters.*;
import filesprocessing.orders.*;
import java.util.regex.Pattern;

public class Parser {
	public static ArrayList<Subsection> parse(File commandsFile) throws TypeTwoException, IOException {
		ArrayList<Subsection> subsectionList = new ArrayList<>();
		LineNumberReader fileContents = new LineNumberReader(new FileReader(commandsFile));
		String currentLine = fileContents.readLine();
		while (currentLine != null) {
			if (!currentLine.equals("FILTER")) {
				throw new BadSubsectionNameException();
			}
			ArrayList<String> subsectionWarnings = new ArrayList<>();
			ArrayList<Filter> filters = new ArrayList<Filter>();
			while (!currentLine.equals("ORDER")) {
				currentLine = fileContents.readLine();
				Filter filter;
				try {
					filter = FilterFactory.createFilter(currentLine.split(Pattern.quote("#")));
				} catch (TypeOneException | ClassCastException e) {
					subsectionWarnings.add("Warning in line " + fileContents.getLineNumber());
					filter = FilterFactory.getDefaultFilter();
				}
				filters.add(filter);
				currentLine = fileContents.readLine();
				if (currentLine == null) {
					throw new ComandsFileException();
				}
				if (!currentLine.equals("ORDER") && !currentLine.equals("FILTER")) {
					throw new BadSubsectionNameException();
				}
			}
			currentLine = fileContents.readLine();
			Order order;
			if (currentLine == null||currentLine.equals("FILTER")) {
				order = OrderFactory.getDefaultOrder();
			} else {
				try {
					String[] lineForOrder;
					lineForOrder = currentLine.split(Pattern.quote("#"));
					order = OrderFactory.createOrder(lineForOrder);
				} catch (TypeOneException e) {
					subsectionWarnings.add("Warning in line " + fileContents.getLineNumber());
					order = OrderFactory.getDefaultOrder();
				}
			}
			subsectionList.add(new Subsection(filters, order, subsectionWarnings));
			if (currentLine != null && !currentLine.equals("FILTER")) {
				currentLine = fileContents.readLine();
			}
		}
		return subsectionList;
	}
}
