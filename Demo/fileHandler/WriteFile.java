package fileHandler;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class WriteFile{
	PrintWriter writer;
	
	public WriteFile(String path){
		try{
			writer = new PrintWriter(path,"UTF-8");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void writeContent(List<String> content){
		int i;
		for(i=0;i<content.size();i++){
			writer.println(content.get(i));
		}
		writer.close();
	}
}