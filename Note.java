public class Note
{
   public String letter;
   public boolean isMajor;
   public boolean isFlat;
   public boolean isNatural;
   public boolean isSharp;
   public String length;
   
   //[Letter, Length]
   public Note(String s, String l){
      parseLetter(s); //Run checks and set letter and isMajor/Natural/Sharp values
      this.length = l;
   }
   
   
   public void setLetter(char x)
   {
      if(!isValidLetter(x)) throws new RuntimeException("Not a valid letter");
      letter = String.valueOf(x);
   }
   
   public static boolean isLetter(String x){
      return ((x == 'a') || (x == 'A') || (x == 'b') || (x == 'B') || (x == 'c') || (x == 'C') || (x == 'd') 
         || (x == 'D') || (x == 'e') || (x == 'E') || (x == 'f') || (x == 'F') || (x == 'g') || (x == 'G'));
   }
   
   public static boolean isMajor(char x){
      int i = (int)x;
      return (i >= 65 && i <= 71);
   }
   
 
   private void parseLetter(String s){
      
      if(s.length() > 1){
         char tokens[] = s.toCharArray(s);
         setLetter(tokens[1]);
         //check =^_
         char accidental = tokens[0];
         if(accidental == '_'){
            isFlat = true;
            isNatural = false;
            isSharp = false;
         } else if(accidental == '='){
            isFlat = false;
            isNatural = true;
            isSharp = false;
         
         } else if(accidental == '^'){
            isFlat = false;
            isNatural = false;
            isSharp = true;
         } else {
            //throw error
            throws new RuntimeException("Not a vaild accidental");
         }
         
         this.isMajor = isMajor(tokens[1]);
      } else {
         setLetter(s);
         this.isMajor = isMajor(s.charAt(0));
      }
   }
}