package fileHandler;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class ReadFile{
	private String path;
	
	public ReadFile(String file_path){
		path = file_path;
	}
	
	public List<String> OpenFile() throws IOException{
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = readLines();
		List<String> textData = new ArrayList<String>();
		
		int i;
		for(i=0;i<numberOfLines;i++){
			textData.add(textReader.readLine());
		}
		
		textReader.close();
		return textData;
	}
	
	int readLines() throws IOException{
		FileReader file_To_Read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_To_Read);
		
		String aLine;
		int numberOfLines = 0;
		
		while((aLine = bf.readLine())!=null){
			numberOfLines++;
		}
		
		bf.close();
		return numberOfLines;
	}
	
}