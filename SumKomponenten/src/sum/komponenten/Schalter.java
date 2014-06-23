package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JCheckBox;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Schalter extends Textkomponente
  implements Serializable
{
   private String zGeklicktBearbeiter = "";
  private JCheckBox hatCheckbox;

  public Schalter(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift)
  {
     this.hatCheckbox = new JCheckBox(pAufschrift);
     this.hatCheckbox.setOpaque(true);
     Bildschirm.topFenster.privatPanel().add(this.hatCheckbox, 0);
     this.hatCheckbox.addItemListener(new SchalterReaktor());
     this.hatCheckbox.addKeyListener(new SchalterTastenReaktor());
     this.hatCheckbox.addFocusListener(new SchalterFokusReaktor());
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatCheckbox);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Schalter(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift)
  {
     this.hatCheckbox = new JCheckBox(pAufschrift);
     this.hatCheckbox.setOpaque(true);
     pFenster.privatPanel().add(this.hatCheckbox, 0);
     this.hatCheckbox.addItemListener(new SchalterReaktor());
     this.hatCheckbox.addKeyListener(new SchalterTastenReaktor());
     this.hatCheckbox.addFocusListener(new SchalterFokusReaktor());
     lerneKomponenteKennen(pFenster, this.hatCheckbox);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Schalter(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter)
  {
     this(pLinks, pOben, pBreite, pHoehe, pAufschrift);
     this.zGeklicktBearbeiter = pGeklicktBearbeiter;
  }

  public void setzeBearbeiterGeklickt(String pBearbeiter)
  {
     this.zGeklicktBearbeiter = pBearbeiter;
  }

  protected void schalterGeklickt()
  {
     Class[] formparas = new Class[1];

     Schalter[] schalter = new Schalter[1];

     if (this.zGeklicktBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method method = sumEreignis.getMethod(this.zGeklicktBearbeiter, null);
           method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Schalter \"" + inhaltAlsText() + "\": " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Schalter.class;
             Method method = sumEreignis.getMethod(this.zGeklicktBearbeiter, formparas);
             schalter[0] = this;
             method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, schalter);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Schalter \"" + inhaltAlsText() + "\": " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zGeklicktBearbeiter + "\" von Schalter \"" + inhaltAlsText() + "\" nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  protected void fokusErhalten()
  {
     Class[] formparas = new Class[1];

     Schalter[] schalter = new Schalter[1];

     setzeFokusWert(true);

     if (fokusErhaltenBearbeiter().length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method method = sumEreignis.getMethod(fokusErhaltenBearbeiter(), null);
           method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" von Schalter \"" + inhaltAlsText() + "\": " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Schalter.class;
             Method method = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             schalter[0] = this;
             method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, schalter);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" von Schalter \"" + inhaltAlsText() + "\": " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" von Schalter \"" + inhaltAlsText() + "\" nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  protected void fokusVerloren()
  {
     Class[] formparas = new Class[1];

     Schalter[] schalter = new Schalter[1];

     setzeFokusWert(false);
     if (fokusVerlorenBearbeiter().length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method method = sumEreignis.getMethod(fokusVerlorenBearbeiter(), null);
           method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" von Schalter \"" + inhaltAlsText() + "\": " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Schalter.class;
             Method method = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             schalter[0] = this;
             method.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, schalter);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" von Schalter \"" + inhaltAlsText() + "\": " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" von Schalter \"" + inhaltAlsText() + "\" nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public void schalteAn()
  {
     this.hatCheckbox.setSelected(true);
  }

  public void schalteAus()
  {
     this.hatCheckbox.setSelected(false);
  }

  public boolean angeschaltet()
  {
     return this.hatCheckbox.isSelected();
  }

  public void setzeInhalt(String pText)
  {
     this.hatCheckbox.setText(pText);
     this.kenntFenster.doUpdate(this.hatCheckbox);
  }

  public String inhaltAlsText()
  {
     return this.hatCheckbox.getText();
  }

  private class SchalterFokusReaktor
    implements FocusListener
  {
    private SchalterFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Schalter.this.fokusErhalten();
    }

    public void focusLost(FocusEvent e)
    {
       Schalter.this.fokusVerloren();
    }
  }

  private class SchalterTastenReaktor
    implements KeyListener
  {
    private SchalterTastenReaktor()
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
       if (e.getKeyCode() == 10)
         Schalter.this.schalterGeklickt();
    }

    public void keyReleased(KeyEvent e)
    {
    }
  }

  private class SchalterReaktor
    implements ItemListener
  {
    private SchalterReaktor()
    {
    }

    public void itemStateChanged(ItemEvent e)
    {
       Schalter.this.schalterGeklickt();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Schalter
 * JD-Core Version:    0.6.0
 */