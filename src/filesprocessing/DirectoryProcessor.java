package filesprocessing;


import filesprocessing.filters.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryProcessor {
	public static void main(String[] args) {
		try {
			if (args.length != 2) {
				throw new ParametersNumberException();
			}

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

				List<File> filesInOrder = subsection.getOrder().getFilesInOrder(approvedFiles);
				for (File toPrintFile : filesInOrder) {
					System.out.println(toPrintFile.getName());
				}
			}
		} catch (TypeTwoException e) {
			System.err.println("ERROR: " + e.getMsg());
			return;
		} catch (IOException e) {
			System.err.println("ERROR: IO problem");
			return;
		}
	}
}