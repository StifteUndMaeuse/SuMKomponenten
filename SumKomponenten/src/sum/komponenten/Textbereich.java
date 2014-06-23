 package sum.komponenten;
 
 import java.awt.Dimension;
 import java.io.Serializable;
 import javax.swing.JComponent;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.ScrollPaneConstants;
 import sum.ereignis.Bildschirm;
 import sum.ereignis.Fenster;
 
 public abstract class Textbereich extends Markierungskomponente
   implements Serializable, ScrollPaneConstants
 {
   protected JScrollPane hatScrollPane;
 
   public Textbereich(double pLinks, double pOben, double pBreite, double pHoehe)
   {
     this.hatScrollPane = new JScrollPane(22, 31);
     this.hatScrollPane.setSize(new Dimension(10, 10));
     Bildschirm.topFenster.privatPanel().add(this.hatScrollPane, 0);
   }
 
   public Textbereich(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe)
   {
     this.hatScrollPane = new JScrollPane(22, 31);
     this.hatScrollPane.setSize(new Dimension(10, 10));
     pFenster.privatPanel().add(this.hatScrollPane, 0);
   }
 
   protected void lerneKomponenteKennen(Bildschirm pFenster, JComponent pKomponente)
   {
     this.hatScrollPane.setViewportView(pKomponente);
     super.lerneKomponenteKennen(pFenster, pKomponente);
   }
 
   public void setzeGroesse(double pBreite, double pHoehe)
   {
     super.setzeGroesse(pBreite, pHoehe);
     this.hatScrollPane.setSize((int)pBreite, (int)pHoehe);
     this.hatScrollPane.revalidate();
   }
 
   public void setzePosition(double pWohinH, double pWohinV)
   {
     this.hatScrollPane.setLocation((int)pWohinH, (int)pWohinV);
   }
 
   public abstract void fuegeEin(String paramString, int paramInt);
 
   public abstract void haengeAn(String paramString);
 
   public abstract void haengeAn(char paramChar);
 
   public abstract void haengeAn(int paramInt);
 
   public abstract void haengeAn(double paramDouble);
 }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Textbereich
 * JD-Core Version:    0.6.0
 */