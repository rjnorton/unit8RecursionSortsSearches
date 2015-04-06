public class StringReverse
{
    public static String reverse(String text)
    {
        if(text.length() <= 1)
        {
            return text;
        }
        
        char c = text.charAt(0);
        String rest = text.substring(1);
        String reverseText = reverse(rest) + c;
        return reverseText;
    }
    
    public static void main(String[] args)
    {
        System.out.println(reverse("System.out.println(reverse(\"String\"));"));
        System.out.println(reverseIter("System.out.println(reverse(\"String\"));"));
    }
    
    public static String reverseIter(String text)
    {
        if(text.length() <= 1)
        {
            return text;
        }
        
        String reverseText = "";
        for(int i = text.length() - 1; i >= 0; i--)
        {
            char c = text.charAt(i);
            reverseText += c;
        }
        
        return reverseText;
    }
}
