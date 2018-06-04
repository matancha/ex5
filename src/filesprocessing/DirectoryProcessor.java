package filesprocessing;


import filesprocessing.filters.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryProcessor {
	public static void main(String[] args) {
		String dirPath = args[0];
		String commandsPath = args[1];

		File dir = new File(dirPath);
		File commandFile = new File(commandsPath);

		ArrayList<Subsection> subsections = Parser.parse(commandFile);
		File[] filesList = dir.listFiles();

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

			File[] approvedFilesArray = new File[approvedFiles.size()];
			List<File> filesInOrder = subsection.getOrder().getFilesInOrder(approvedFiles);
			for (File toPrintFile : filesInOrder) {
				System.out.println(toPrintFile.getName());
			}
		}
	}
}