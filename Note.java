import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note
{
   public String letter;
   public boolean isMajor;
   public boolean isFlat;
   public boolean isNatural;
   public boolean isSharp;
   public String length;
   
   //[Letter, Length]
   public Note(String s, String l)
   {
      String regex = "\\d+/\\d+";
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(l);
      
      parseLetter(s); //Run checks and set letter and isMajor/Natural/Sharp values
      if(m.find())
      {
      this.length = l;
      }
      else
      {
         throw new RuntimeException("Illegal note length format");
      }
   }
   
   
   public void setLetter(char x)
   {
      if(!isLetter(x)) throw new RuntimeException("Not a valid letter");
      letter = String.valueOf(x);
   }
   
   public static boolean isLetter(char x)
   {
      return ((x == 'a') || (x == 'A') || (x == 'b') || (x == 'B') || (x == 'c') || (x == 'C') || (x == 'd') 
         || (x == 'D') || (x == 'e') || (x == 'E') || (x == 'f') || (x == 'F') || (x == 'g') || (x == 'G'));
   }
   
   public static boolean isMajor(char x)
   {
      int i = (int)x;
      return (i >= 65 && i <= 71);
   }
   
 
   private void parseLetter(String s)
   {
      
      if(s.length() > 1) //check to see if the string has more than one element
      {
         char tokens[] = s.toCharArray();
         setLetter(tokens[1]);
         
         //check to see if the note is an accidental "=^_"
         char accidental = tokens[0];
         
         if(accidental == '_')
         {
            isFlat = true;
            isNatural = false;
            isSharp = false;
         } 
         else if(accidental == '=')
         {
            isFlat = false;
            isNatural = true;
            isSharp = false;
         
         } 
         else if(accidental == '^')
         {
            isFlat = false;
            isNatural = false;
            isSharp = true;
         } 
         else //throw error
         {
            throw new RuntimeException("Not a vaild accidental");
         }
         
         this.isMajor = isMajor(tokens[1]);
      } 
      else //if it does not have more than one element, set first element
      {
         setLetter(s.charAt(0));
         this.isMajor = isMajor(s.charAt(0));
      }
   }
}