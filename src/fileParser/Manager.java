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

		for (Subsection subsection: subsections) {
			ArrayList<File> passedFiles = new ArrayList<File>();
			for (File file: filesList) {
				boolean filterPassed = true;
				for (Filter filter: subsection.getFilterList()) {
					if (! filter.isPassFilter(file)){
						filterPassed = false;
						break;
					}
				}
				if (filterPassed) {
					passedFiles.add(file);
				}
			}
		}
	}
}
