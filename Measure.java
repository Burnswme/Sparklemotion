import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Measure
{
   private String time = "3/4";
   public ArrayList<Chord> chords = new ArrayList<Chord>();
   
   public Measure(String t, ArrayList<Chord> c)
   {
      chords = c;
      time = t;
   }
}