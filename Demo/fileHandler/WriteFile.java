/*
 * Author: Lakshya Chaudhary 
 */

package fileHandler;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

/*
 * Class WriteFile:-
 * A simple utility that uses Java IO operation to write contents into a file.
 * Constructor takes the output file path as argument.
 * 
 * writeContent() method reads an ArrayList passed as argument and writes it into
 * an output file. So, If the ArrayList has N element then the output file will
 * have N lines.
 */

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