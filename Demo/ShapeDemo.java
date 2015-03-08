import shapes.*;
import fileHandler.ReadFile;
import java.io.IOException;

public class ShapeDemo{
	
	public static void main(String[] args) throws IOException{
		ShapeFactory shapeFactory = new ShapeFactory();
		String path = "C:\\Users\\Nomad\\Desktop\\Demo.txt";
		ReadFile file = new ReadFile(path);
		String[] fileContent = file.OpenFile();

		int i;
		int size_Of_Shape_Array = fileContent.length;
		Shape[] arrayOfShapes = new Shape[size_Of_Shape_Array];
		
		for(i=0;i<fileContent.length;i++){
			arrayOfShapes[i] = shapeFactory.getShape(fileContent[i]);
		}
		arrayOfShapes[fileContent.length-1].draw();
	}
} 