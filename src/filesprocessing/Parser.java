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
			if (!currentLine.equals("FILTER")){
				throw new BadSubsectionNameException();
			}
			while (currentLine != null) {
				ArrayList<Filter> filters = new ArrayList<Filter>();
				try {
					while (! currentLine.equals("ORDER")){
						currentLine = fileContents.readLine();
						try {
							Filter filter = FilterFactory.createFilter(currentLine.split(Pattern.quote("#")));
							filters.add(filter);
						} catch (TypeOneException e) {
							System.err.println("Warning in line " +fileContents.getLineNumber());
							currentLine=fileContents.readLine();
						}
						currentLine = fileContents.readLine();
						if (currentLine==null){
							throw new ComandsFileException();
						}
						if (!currentLine.equals("ORDER")&&!currentLine.equals("FILTER")){
							throw new BadSubsectionNameException();
						}
					}
					currentLine = fileContents.readLine();
					String[] lineForOrder=null;
					if (currentLine!=null){
						lineForOrder=currentLine.split(Pattern.quote("#"));
					}
					try {
						Order order = OrderFactory.createOrder(lineForOrder);
					} catch (TypeOneException e) {
						System.err.println("Warning in line " +fileContents.getLineNumber());
						currentLine=fileContents.readLine();
					}
					subsectionList.add(new Subsection(filters, order));
					if (currentLine!=null&&!currentLine.equals("FILTER")){
						currentLine = fileContents.readLine();
					}
				}
			}
		} catch (IOException e) {
			System.err.println("ERROR:"+e.getMessage());
			return null;
		}catch (TypeTwoException e){
			System.err.println("ERROR:"+e.getMsg());
			return null;
		}
		return subsectionList;
	}
}
