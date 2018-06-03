package fileParser;


import fileParser.filters.*;

import java.io.File;
import java.util.ArrayList;

public class Manager {
	public static void main(String[] args) {
		String dirPath = args[0];
		String commandsPath = args[1];

		File dir = new File(dirPath);
		File commandFile = new File(commandsPath);

		ArrayList<Subsection> subsections = Parser.parse(commandFile);
		File[] filesList = dir.listFiles();

		for (Subsection subsection : subsections) {
			ArrayList<File> approvedFiles = new ArrayList<File>();

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

			File[] filesInOrder = subsection.getOrder().getFilesInOrder((File[]) approvedFiles.toArray());
			for (File toPrintFile : filesInOrder) {
				System.out.println(toPrintFile.getName());
			}
		}
	}
}