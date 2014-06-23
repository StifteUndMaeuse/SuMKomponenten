package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Kennwortfeld extends Textfeld
  implements Serializable
{
   protected String zEingabeBestaetigtBearbeiter = "";
  protected JPasswordField hatPasswordField;

  public Kennwortfeld(double pLinks, double pOben, double pBreite, double pHoehe, char pEchozeichen)
  {
     this.hatPasswordField = new JPasswordField();
     this.hatPasswordField.setOpaque(true);
     this.hatTextField = this.hatPasswordField;
     this.hatPasswordField.getDocument().addDocumentListener(new DokumentReaktor());
     this.hatPasswordField.addMouseMotionListener(new FeldMausReaktor());
     this.hatPasswordField.addFocusListener(new FeldFokusReaktor());
     this.hatPasswordField.addKeyListener(new FeldTastenReaktor());
     this.hatPasswordField.setEchoChar(pEchozeichen);
     Bildschirm.topFenster.privatPanel().add(this.hatPasswordField, 0);
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatPasswordField);
     init(pLinks, pOben, pBreite, pHoehe, "");
  }

  public Kennwortfeld(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, char pEchozeichen)
  {
     this.hatPasswordField = new JPasswordField();
     this.hatPasswordField.setOpaque(true);
     this.hatTextField = this.hatPasswordField;
     this.hatPasswordField.getDocument().addDocumentListener(new DokumentReaktor());
     this.hatPasswordField.addMouseMotionListener(new FeldMausReaktor());
     this.hatPasswordField.addFocusListener(new FeldFokusReaktor());
     this.hatPasswordField.addKeyListener(new FeldTastenReaktor());
     this.hatPasswordField.setEchoChar(pEchozeichen);
     pFenster.privatPanel().add(this.hatPasswordField, 0);
     lerneKomponenteKennen(pFenster, this.hatPasswordField);
     init(pLinks, pOben, pBreite, pHoehe, "");
  }

  public void setzeBearbeiterEingabeBestaetigt(String pBearbeiter)
  {
     this.zEingabeBestaetigtBearbeiter = pBearbeiter;
  }

  protected void inhaltGeaendert()
  {
     Class[] formparas = new Class[1];

     Kennwortfeld[] meinTextfeld = new Kennwortfeld[1];

     if (this.zInhaltGeaendertBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
            Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e0);
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Kennwortfeld.class;
             Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
             Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  protected void eingabeBestaetigt()
  {
     Class[] formparas = new Class[1];

     Kennwortfeld[] meinTextfeld = new Kennwortfeld[1];

     if (this.zEingabeBestaetigtBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method methode = sumEreignis.getMethod(this.zEingabeBestaetigtBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
           Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e0);
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Kennwortfeld.class;
             Method methode = sumEreignis.getMethod(this.zEingabeBestaetigtBearbeiter, formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
             Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  protected void markierungGeaendert()
  {
     Class[] formparas = new Class[1];

     Kennwortfeld[] meinTextfeld = new Kennwortfeld[1];

     if (this.zMarkierungGeaendertBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
           Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e0);
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Kennwortfeld.class;
             Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
             Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds nicht gefunden.");
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

     Kennwortfeld[] meinTextfeld = new Kennwortfeld[1];

     setzeFokusWert(true);
     if (fokusErhaltenBearbeiter().length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Textfelds: " + e0.getTargetException().toString());
           Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e0);
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Kennwortfeld.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Textfelds: " + e2.getTargetException().toString());
             Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" eines Textfelds nicht gefunden.");
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

     Kennwortfeld[] meinTextfeld = new Kennwortfeld[1];

     setzeFokusWert(false);
     if (fokusVerlorenBearbeiter().length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Textfelds: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Textfeld.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Textfelds: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" eines Textfelds nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public void setzeKennwortzeichen(char pZeichen)
  {
     this.hatPasswordField.setEchoChar(pZeichen);
  }

  public void setzeKennwortZeichen(char pZeichen)
  {
     this.hatPasswordField.setEchoChar(pZeichen);
  }

  public char kennwortzeichen()
  {
     return this.hatPasswordField.getEchoChar();
  }

  public char kennwortZeichen()
  {
     return this.hatPasswordField.getEchoChar();
  }

  private class FeldFokusReaktor
    implements FocusListener
  {
    private FeldFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Kennwortfeld.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Kennwortfeld.this.verliertFokus();
    }
  }

  private class FeldTastenReaktor
    implements KeyListener
  {
    private FeldTastenReaktor()
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
       if (e.getKeyCode() == 10)
         Kennwortfeld.this.eingabeBestaetigt();
    }

    public void keyReleased(KeyEvent e)
    {
    }
  }

  private class FeldMausReaktor
    implements MouseMotionListener
  {
    private FeldMausReaktor()
    {
    }

    public void mouseDragged(MouseEvent e)
    {
       Kennwortfeld.this.markierungGeaendert();
    }

    public void mouseMoved(MouseEvent e)
    {
    }
  }

  private class DokumentReaktor
    implements DocumentListener
  {
    private DokumentReaktor()
    {
    }

    public void insertUpdate(DocumentEvent e)
    {
       Kennwortfeld.this.inhaltGeaendert();
       Kennwortfeld.this.markierungGeaendert();
    }

    public void removeUpdate(DocumentEvent e)
    {
       Kennwortfeld.this.inhaltGeaendert();
       Kennwortfeld.this.markierungGeaendert();
    }

    public void changedUpdate(DocumentEvent e)
    {
       Kennwortfeld.this.inhaltGeaendert();
       Kennwortfeld.this.markierungGeaendert();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Kennwortfeld
 * JD-Core Version:    0.6.0
 */