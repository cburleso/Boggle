public class Random
{
   public static void main(String [] args)
   {
      int num = countChars("lellur", 'l');
      System.out.println(num);
   }
   
   public static int countChars(String s, char c)
   {
      if (s.charAt(0) == c)
          return 1 + countChars(s.substring(1), c);
      else
         return 0;
      
      
   }
}