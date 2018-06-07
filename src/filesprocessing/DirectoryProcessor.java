package filesprocessing;

import filesprocessing.filters.*;
import java.io.*;
import java.util.*;

/**
 * The main class of the program. Responsible for the general flow.
 */
public class DirectoryProcessor {
	/* Number of command-line arguments */
	private static final int NUM_ARGUMENTS = 2;

	/* Index of dir path in program args */
	private static final int DIR_PATH_INDEX = 0;

	/* Index of commands file path in program args */
	private static final int COMMANDS_FILE_PATH = 1;

	/**
	 * Main function of program
	 * @param args (1) Source directory (2) commands file path
	 */
	public static void main(String[] args) {
		try {
			validateNumArgs(args);
			String dirPath = args[DIR_PATH_INDEX];
			String commandsPath = args[COMMANDS_FILE_PATH];

			File dir = new File(dirPath);
			File commandFile = new File(commandsPath);
			if (isFileEmpty(commandFile)){
				return;
			}

			File[] filesList = getFilesList(dir);
			ArrayList<Subsection> subsections = Parser.parse(commandFile);
			for (Subsection subsection : subsections) {
				ArrayList<File> approvedFiles = getApprovedFiles(filesList, subsection.getFilterList());
				List<File> filesInOrder = subsection.getOrder().getFilesInOrder(approvedFiles);
				printResults(subsection.getWarnings(), filesInOrder);
			}
		} catch (TypeTwoException e) {
			System.err.println("ERROR: " + e.getMsg());
		} catch (IOException e) {
			System.err.println("ERROR: IO problem");
		}
	}

	/**
	 * Prints warnings + filtered files
	 * @param warnings warnings for the user
	 * @param filesInOrder files that passed filtering
	 */
	private static void printResults(List<String> warnings, List<File> filesInOrder) {
		for (String warning: warnings) {
			System.err.println(warning);
		}
		for (File toPrintFile : filesInOrder) {
			System.out.println(toPrintFile.getName());
		}
	}

	/**
	 * Gets filtered files for the supplied subsection
	 * @param filesList List of files in dir
	 * @param filtersList filters the files need to pass
	 * @return list of approved files
	 */
	private static ArrayList<File> getApprovedFiles(File[] filesList, ArrayList<Filter> filtersList) {
		ArrayList<File> approvedFiles = new ArrayList<File>();
		for (File file : filesList) {
			boolean filterPassed = true;
			for (Filter filter : filtersList) {
				if (!filter.isPassFilter(file)) {
					filterPassed = false;
					break;
				}
			}
			if (filterPassed) {
				approvedFiles.add(file);
			}
		}
		return approvedFiles;
	}

	/**
	 * Gets file list in source dir, not including dirs
	 * @param dir source directory
	 * @return list of files
	 */
	private static File[] getFilesList(File dir) {
		return dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile();
			}
		});
	}

	/**
	 * validates the number of arguments supplied, was valid
	 * @param args program args
	 * @throws ParametersNumberException - Thrown if number of arguments varies than the expected
	 */
	private static void validateNumArgs(String[] args) throws ParametersNumberException {
		if (args.length != NUM_ARGUMENTS) {
			throw new ParametersNumberException();
		}
	}

	/**
	 * Checks if file is empty
	 * @param filePath path to file
	 * @return true or false
	 */
	private static boolean isFileEmpty(File filePath) {
		return filePath.length()==0;
	}
}