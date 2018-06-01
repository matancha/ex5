package fileParser;
import java.io.*;
import java.util.*;
import fileParser.TypeOneException;
import fileParser.filters.*;
import fileParser.orders.*;
import java.util.regex.Pattern;

public class Parser {
	public static ArrayList<Subsection> parser(File commandsFile) throws TypeOneException {
		ArrayList<Subsection> subsectionList = new ArrayList<Subsection>();
		try {
			Scanner sc = new Scanner(commandsFile);
			while (sc.hasNextLine()) {
				String line=sc.nextLine();
				ArrayList<Filter> filters = new ArrayList<Filter>();
				while (! line.equals("ORDER")){
					String filterLine = sc.nextLine();
					Filter filter = FilterFactory.createFilter(filterLine.split(Pattern.quote("#")));
					filters.add(filter);
					line=sc.nextLine();
				}
				line=sc.nextLine();
				Order order = OrderFactory.createOrder(line.split(Pattern.quote("#")));
				subsectionList.add(new Subsection(filters, order));
			}
		} catch (IOException e) {
			return null;
		}
		return subsectionList;
	}
}
