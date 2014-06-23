package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Auswahl extends Komponente
  implements Serializable
{
   private String zGeaendertBearbeiter = "";
  private JComboBox hatComboBox;

  public Auswahl(double pLinks, double pOben, double pBreite, double pHoehe)
  {
     this.hatComboBox = new JComboBox();
     this.hatComboBox.setOpaque(true);
     Bildschirm.topFenster.privatPanel().add(this.hatComboBox, 0);
     this.hatComboBox.addItemListener(new AuswahlReaktor(null));
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatComboBox);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Auswahl(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe)
  {
     this.hatComboBox = new JComboBox();
     this.hatComboBox.setOpaque(true);
     pFenster.privatPanel().add(this.hatComboBox, 0);
     this.hatComboBox.addItemListener(new AuswahlReaktor(null));
     lerneKomponenteKennen(pFenster, this.hatComboBox);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public void setzeBearbeiterGeaendert(String pBearbeiter)
  {
     this.zGeaendertBearbeiter = pBearbeiter;
  }

  protected void gewaehlt(int pIndex, String pText)
  {
     Class[] formparas = new Class[1];

     Auswahl[] meineAuswahl = new Auswahl[1];

     if (this.zGeaendertBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Auswahl.class;
             Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, formparas);
             meineAuswahl[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineAuswahl);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  protected void bekommtFokus()
  {
     Class[] formparas = new Class[1];

     Auswahl[] meineAuswahl = new Auswahl[1];

     setzeFokusWert(true);
     if (fokusErhaltenBearbeiter().length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" einer Auswahl: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Auswahl.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meineAuswahl[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineAuswahl);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" einer Auswahl: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" einer Auswahl nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  protected void verliertFokus()
  {
     Class[] formparas = new Class[1];

     Auswahl[] meineAuswahl = new Auswahl[1];

     setzeFokusWert(false);
     if (fokusVerlorenBearbeiter().length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" einer Auswahl: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Auswahl.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             meineAuswahl[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineAuswahl);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" einer Auswahl: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" einer Auswahl nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public void haengeAn(String pText)
  {
     this.hatComboBox.addItem(pText);
  }

  public int index()
  {
     return this.hatComboBox.getSelectedIndex() + 1;
  }

  public String text()
  {
     return (String)this.hatComboBox.getSelectedItem();
  }

  public void waehle(int pIndex)
  {
     this.hatComboBox.setSelectedIndex(pIndex - 1);
  }

  public void waehle(String pText)
  {
     this.hatComboBox.setSelectedItem(pText);
  }

  public int zeilenAnzahl()
  {
     return this.hatComboBox.getItemCount();
  }

  public void entferneAlleZeilen()
  {
     this.hatComboBox.removeAllItems();
  }

  private class KnopfFokusReaktor
    implements FocusListener
  {
    private KnopfFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Auswahl.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Auswahl.this.verliertFokus();
    }
  }

  private class AuswahlReaktor
    implements ItemListener
  {
    private AuswahlReaktor()
    {
    }

    public void itemStateChanged(ItemEvent e)
    {
       JComboBox comboBox = (JComboBox)e.getItemSelectable();
       Auswahl.this.gewaehlt(comboBox.getSelectedIndex(), (String)comboBox.getSelectedItem());
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Auswahl
 * JD-Core Version:    0.6.0
 */