import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song
{
   private String title;
   private String key;
   private String noteLength; //set the default length of the notes
   public ArrayList<Measure> measures = new ArrayList<Measure>(); //this holds the measures that compose the song
      
   public Song()
   {
      title = "A";
      key = "aMaj";
      noteLength = "1/4";
   }
   public Song(String t, String k, String n)
   {
      String regex = "\\d+/\\d+";
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(n);
      
      title = t;
      key = k;
      if(m.find())   //check to see that the note length is in the proper format
      {
         noteLength = n;
      }
      else
      {
         throw new RuntimeException("Illegal note length format");
      }
   }
}