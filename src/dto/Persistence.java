package dto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistence {
	
	private static String path = "D:\\MIU";
	
	public static <T> void store(String name, T object) {		
		String filePath = path + "\\" + name;
		
		try {
			
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(object);
            objectOut.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static <T> T restore(String name) {
		String filePath = path + "\\" + name;
		 try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            T obj = (T)objectIn.readObject();
 
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}
}
