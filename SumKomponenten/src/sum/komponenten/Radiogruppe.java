 package sum.komponenten;
 
 import java.io.Serializable;
 import javax.swing.AbstractButton;
 import javax.swing.ButtonGroup;
 
 public class Radiogruppe extends ButtonGroup
   implements Serializable
 {
   public void fuegeEin(Radioknopf pKnopf)
   {
     add((AbstractButton)pKnopf.hatComponent);
   }
 
   public void entferne(Radioknopf pKnopf)
   {
     remove((AbstractButton)pKnopf.hatComponent);
   }
 }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Radiogruppe
 * JD-Core Version:    0.6.0
 */