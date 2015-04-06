import java.util.Scanner;
import java.io.File;
import java.lang.Character;
import java.io.FileNotFoundException;

public class WC
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String name = in.next();
        
        int words = readWords(name);
        System.out.println("There are " + words + " words.");
        
        int chars = readChars(name);
        System.out.println("There are " + chars + " characters.");
    }

    public static int readWords(String name)
    {
      Scanner filescanner = null;
      try
      {
          File file = new File(name);
          filescanner = new Scanner(file);
      }        
      catch(FileNotFoundException e)
      {
          System.out.println("No file or somethign");
      }  
        
      int counter = 0;
        
      while(filescanner.hasNext())
      {
          filescanner.next();
          counter++;
      }
      
      filescanner.close();
      return counter;
    }
    
    public static int readChars(String name)
    {
        Scanner filescanner = null;
        try
        {
            File file = new File(name);
            filescanner = new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("no file");
        }
        
        int counter = 0;
        char c = 'f';
        filescanner.useDelimiter("");
        while(filescanner.hasNext())
        {
            c = filescanner.next().charAt(0);
            if(isLetter(c))
            {
                counter++;
            }
        }
        
        filescanner.close();
        return counter;
    }
}
