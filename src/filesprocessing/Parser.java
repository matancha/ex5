package filesprocessing;
import java.io.*;
import java.util.*;
import filesprocessing.filters.*;
import filesprocessing.orders.*;
import java.util.regex.Pattern;

/**
 * Class responsible for parsing the commands file according to a defined format.
 */
public class Parser {
	/* Header of filter */
	private static final String FILTER_HEADER = "FILTER";
	/* Header of Order */
	private static final String ORDER_HEADER = "ORDER";
	/* The first line in a subsection */
	private static final String SUBSECTION_BEGINNING_STRING = "FILTER";
	/* Delimiter for separating arguments */
	private static final String ARGS_DELIMITER = "#";
	/* Format of warning */
	private static final String WARNING_STR = "Warning in line ";

	/**
	 * This function is responsible for parsing the commands file
	 * @param commandsFile File to parse
	 * @return List of Subsection objects
	 * @throws TypeTwoException Error that stops the program's run
	 * @throws IOException Problem with IO while reading
	 */
	public static ArrayList<Subsection> parse(File commandsFile) throws TypeTwoException, IOException {
		ArrayList<Subsection> subsectionList = new ArrayList<>();
		LineNumberReader fileContents = new LineNumberReader(new FileReader(commandsFile));

		String currentLine = fileContents.readLine();
		while (currentLine != null) {
			if (! currentLine.equals(SUBSECTION_BEGINNING_STRING)) {
				throw new BadSubsectionNameException();
			}
			ArrayList<String> subsectionWarnings = new ArrayList<>();
			ArrayList<Filter> filters = getFilters(fileContents, currentLine, subsectionWarnings);

			currentLine = fileContents.readLine();
			Order order = getOrder(fileContents, currentLine, subsectionWarnings);
			subsectionList.add(new Subsection(filters, order, subsectionWarnings));

			if (isLeft(currentLine)) {
				currentLine = fileContents.readLine();
			}
		}
		return subsectionList;
	}

	/**
	 * Checks if there is information left in file
	 * @param currentLine line in commands file
	 * @return true - if left
	 */
	private static boolean isLeft(String currentLine) {
		return currentLine != null && !currentLine.equals(FILTER_HEADER);
	}

	/**
	 * Get Order according to string
	 * @param fileContents reader of file
	 * @param currentLine line in commands file
	 * @param subsectionWarnings list of warnings to add to
	 * @return Order object
	 */
	private static Order getOrder(LineNumberReader fileContents, String currentLine,
	                              ArrayList<String> subsectionWarnings) {
		Order order;
		if (isOrderNotSpecified(currentLine)) {
			order = OrderFactory.getDefaultOrder();
		} else {
			try {
				String[] lineForOrder;
				lineForOrder = currentLine.split(Pattern.quote(ARGS_DELIMITER));
				order = OrderFactory.createOrder(lineForOrder);
			} catch (TypeOneException e) {
				subsectionWarnings.add(WARNING_STR + fileContents.getLineNumber());
				order = OrderFactory.getDefaultOrder();
			}
		}
		return order;
	}

	/**
	 * Checks whether the implementation of order is not specified in the file
	 * @param currentLine current line in commands file
	 * @return true - if it is unspecified
	 */
	private static boolean isOrderNotSpecified(String currentLine) {
		return currentLine == null||currentLine.equals(FILTER_HEADER);
	}

	/**
	 * Get Filters according to string
	 * @param fileContents reader of file
	 * @param currentLine line in commands file
	 * @param subsectionWarnings list of warnings to add to
	 * @return Filter objects list
	 */
	private static ArrayList<Filter> getFilters(LineNumberReader fileContents, String currentLine,
	                               ArrayList<String> subsectionWarnings) throws IOException,
						CommandsFileException, BadSubsectionNameException {
		ArrayList<Filter> filters = new ArrayList<Filter>();
		while (!currentLine.equals(ORDER_HEADER)) {
			currentLine = fileContents.readLine();
			Filter filter;
			try {
				filter = FilterFactory.createFilter(currentLine.split(Pattern.quote(ARGS_DELIMITER)));
			} catch (TypeOneException | ClassCastException e) {
				subsectionWarnings.add(WARNING_STR + fileContents.getLineNumber());
				filter = FilterFactory.getDefaultFilter();
			}
			filters.add(filter);

			currentLine = fileContents.readLine();
			if (currentLine == null) {
				throw new CommandsFileException();
			} else if (!currentLine.equals(ORDER_HEADER) && !currentLine.equals(FILTER_HEADER)) {
				throw new BadSubsectionNameException();
			}
		}
		return filters;
	}
}
