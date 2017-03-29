public class Measure
{
   private String time = "3/4";
   private ArrayList<Chord> chords = new ArrayList<Chord>();
   
   public Measure(String t, ArrayList<Chord> c)
   {
      chords = c;
      time = t;
   }
}