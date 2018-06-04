package fileParser.orders;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TypeOrder implements Order {
	TypeOrder() {
	}

	public String getType(String fileName) {
		String[] splitByDelimiter = fileName.split(Pattern.quote("."));
		return splitByDelimiter[splitByDelimiter.length-1];
	}
	private void swap(File[] files,int index){
		File fileForSwap=files[index];
		files[index]=files[index+1];
		files[index+1]=fileForSwap;
	}


	@Override
	public File[] getFilesInOrder(File[] files) {
		for (int i=0;i<files.length;i++){
			for(int j=i+1;j<files.length;j++){
				String firstFileType = getType(files[j].getName());
				String SecondFileType=getType(files[j+1].getName());
				if (firstFileType.compareTo(SecondFileType)>0){
					swap(files,j);
				}
			}
		}
		for (int i=0;i<files.length;i++){
			int j=i;
			while (getType(files[j].getName()).equals(getType(files[j+1].getName()))) {
				j++;
			}
			File[] absOrder = new AbsOrder().getFilesInOrder(Arrays.copyOfRange(files, i, j));
			for (int c=i;c<j;c++){
				files[c] = absOrder[c-i];
			}
			i=j;
		}
		return files;
	}
}
