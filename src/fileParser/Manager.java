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

		ArrayList<Subsection> subsections = Parser.parser(commandFile);
		File[] filesList = dir.listFiles();

		for (Subsection subsection : subsections) {
			File[] passedFiles = new File[filesList.length];
			/*ArrayList<File> passedFiles = new ArrayList<File>();*/
			int i = 0;
			for (File file : filesList) {
				boolean filterPassed = true;
				for (Filter filter : subsection.getFilterList()) {
					if (!filter.isPassFilter(file)) {
						filterPassed = false;
						break;
					}
				}
				if (filterPassed) {
					passedFiles[i] = file;
					i++;
				}
			}
			File[] finallyPassedFiles = new File[i];
			for (int j = 0; j < i; j++) {
				finallyPassedFiles[j] = passedFiles[j];
			}

			File[] filesInOrder = subsection.getOrder().getFilesInOrder(finallyPassedFiles);
			for (File file : filesInOrder) {
				System.out.println(file.getName());
			}
		}
	}
}
