// Java program to illustrate renaming and
// moving a file permanently to a new loaction
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.*;

public class Test
{
	public static void main(String[] args) throws IOException
	{
			
	  Properties prop = readPropertiesFile("details.properties");
	  String source = prop.getProperty("source");
	  String target = prop.getProperty("target");
      System.out.println("Source: "+ prop.getProperty("source"));
      System.out.println("Destination: "+ prop.getProperty("target"));
			
			GetFilesAndFolders(source,target);
	}

public static void GetFilesAndFolders(String source, String target) throws IOException
{
	
	File sourcePath = new File(source);
     //List of all files and directories
    String sourceContents[] = sourcePath.list();
   
	  
	  
	File targetPath = new File(target);
    //List of all files and directories
    String targetContents[] = targetPath.list();
    
	  
	  
	   for(int i=0; i<sourceContents.length; i++) {
		   {
			   for(int j = 0; j<targetContents.length;j++)
			   {
				   if(sourceContents[i].equals(targetContents[j]))//folder match
				   {
					File filepath = new File(source+"/"+sourceContents[i]);
					//List of all files and directories
					String files[] = filepath.list();
					for(int k=0; k<files.length; k++) 
					{
					Path temp = Files.move(Paths.get(source+"/"+sourceContents[i]+"/"+files[k]),Paths.get(target+"/"+sourceContents[j]+"/"+files[k]));
					
					}
				   }
			   }
		   }
        
      }
	  
	  
}


   public static Properties readPropertiesFile(String fileName) throws IOException {
      FileInputStream fis = null;
      Properties prop = null;
      try {
         fis = new FileInputStream(fileName);
         prop = new Properties();
         prop.load(fis);
      } catch(FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         fis.close();
      }
      return prop;
   }

}


