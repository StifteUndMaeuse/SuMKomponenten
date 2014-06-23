package sum.komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Radioknopf extends Knopf
  implements Serializable
{
   protected String zGeklicktBearbeiter = "";
  protected JRadioButton hatRadioButton;

  public Radioknopf(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift)
  {
     this.hatRadioButton = new JRadioButton(pAufschrift);
     this.hatButton = this.hatRadioButton;
     this.hatButton.setOpaque(true);
     Bildschirm.topFenster.privatPanel().add(this.hatButton, 0);
     this.hatButton.addActionListener(new KnopfReaktor(null));
     this.hatButton.addKeyListener(new KnopfTastenReaktor(null));
     this.hatButton.addFocusListener(new KnopfFokusReaktor(null));
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatButton);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Radioknopf(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter)
  {
     this(pLinks, pOben, pBreite, pHoehe, pAufschrift);
     this.zGeklicktBearbeiter = pGeklicktBearbeiter;
  }

  public Radioknopf(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift)
  {
     this.hatRadioButton = new JRadioButton(pAufschrift);
     this.hatButton = this.hatRadioButton;
     this.hatButton.setOpaque(true);
     pFenster.privatPanel().add(this.hatButton, 0);
     this.hatButton.addActionListener(new KnopfReaktor(null));
     this.hatButton.addKeyListener(new KnopfTastenReaktor(null));
     this.hatButton.addFocusListener(new KnopfFokusReaktor(null));
     lerneKomponenteKennen(pFenster, this.hatButton);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Radioknopf(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter)
  {
     this(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
     this.zGeklicktBearbeiter = pGeklicktBearbeiter;
  }

  public void setzeBearbeiterGeklickt(String pBearbeiter)
  {
     this.zGeklicktBearbeiter = pBearbeiter;
  }

  protected void knopfGeklickt()
  {
     Class[] formparas = new Class[1];

     Knopf[] meinKnopf = new Knopf[1];

     if (this.zGeklicktBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(this.zGeklicktBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + inhaltAlsText() + "\": " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Knopf.class;
             Method methode = sumEreignis.getMethod(this.zGeklicktBearbeiter, formparas);
             meinKnopf[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinKnopf);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + inhaltAlsText() + "\": " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + inhaltAlsText() + "\" nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("Knopf: " + e4.toString());
      }
    }
  }

  protected void bekommtFokus()
  {
     Class[] formparas = new Class[1];

     Knopf[] meinKnopf = new Knopf[1];

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
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" von Knopf \"" + inhaltAlsText() + "\": " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Knopf.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meinKnopf[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinKnopf);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" von Knopf \"" + inhaltAlsText() + "\": " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" von Knopf \"" + inhaltAlsText() + "\" nicht gefunden.");
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

     Knopf[] meinKnopf = new Knopf[1];

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
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" von Knopf \"" + inhaltAlsText() + "\": " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Knopf.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             meinKnopf[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinKnopf);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" von Knopf \"" + inhaltAlsText() + "\": " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" von Knopf \"" + inhaltAlsText() + "\" nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public boolean istGewaehlt()
  {
     return this.hatButton.isSelected();
  }

  public void waehle()
  {
     this.hatButton.setSelected(true);
  }

  private class KnopfFokusReaktor
    implements FocusListener
  {
    private KnopfFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Radioknopf.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Radioknopf.this.verliertFokus();
    }
  }

  private class KnopfTastenReaktor
    implements KeyListener
  {
    private KnopfTastenReaktor()
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
       if (e.getKeyCode() == 10)
         Radioknopf.this.knopfGeklickt();
    }

    public void keyReleased(KeyEvent e)
    {
    }
  }

  private class KnopfReaktor
    implements ActionListener
  {
    private KnopfReaktor()
    {
    }

    public void actionPerformed(ActionEvent e)
    {
       Radioknopf.this.knopfGeklickt();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Radioknopf
 * JD-Core Version:    0.6.0
 */