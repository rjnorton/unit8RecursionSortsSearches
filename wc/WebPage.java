import java.util.Scanner;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WebPage
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter URL: ");
        String address = s.next();
        
        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter("out.txt");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("You are wrong");
        }
        URL pageLocation = null;
        try
        {
            pageLocation = new URL(address);
        }
        catch(MalformedURLException e)
        {
            System.out.println("Invalid URL");
        }
        
        Scanner in = null;
        try
        {
            in = new Scanner(pageLocation.openStream());
        }
        catch(IOException e)
        {
            System.out.println("Invalid URL");
        }
        
        while(in.hasNext())
        {
            pw.println(in.next());
        }
        in.close();
    }
}
