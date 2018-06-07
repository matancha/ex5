package filesprocessing;


import filesprocessing.filters.*;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryProcessor {
	public static void main(String[] args) {
		try {
			checkNumberOfArgs(args);

			String dirPath = args[0];
			String commandsPath = args[1];

			File dir = new File(dirPath);
			File commandFile = new File(commandsPath);
			File[] filesList = dir.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.isFile();
				}
			});

			if (isComandFileEmpty(commandFile)){
				return;
			}
			ArrayList<Subsection> subsections = Parser.parse(commandFile);

			for (Subsection subsection : subsections) {
				ArrayList<File> approvedFiles = new ArrayList<>();

				for (File file : filesList) {
					boolean filterPassed = true;
					for (Filter filter : subsection.getFilterList()) {
						if (!filter.isPassFilter(file)) {
							filterPassed = false;
							break;
						}
					}
					if (filterPassed) {
						approvedFiles.add(file);
					}
				}

				List<File> filesInOrder = subsection.getOrder().getFilesInOrder(approvedFiles);
				for (String warning: subsection.getWarnings()) {
					System.err.println(warning);
				}
				for (File toPrintFile : filesInOrder) {
					System.out.println(toPrintFile.getName());
				}
			}
		} catch (TypeTwoException e) {
			System.err.println("ERROR: " + e.getMsg());
		} catch (IOException e) {
			System.err.println("ERROR: IO problem");
		}
	}private static void checkNumberOfArgs(String[] args)throws ParametersNumberException{
		if (args.length != 2) {
			throw new ParametersNumberException();
		}
	}
	private static boolean isComandFileEmpty(File comandsPath){return  comandsPath.length()==0;}
}