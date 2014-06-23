package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Textfeld extends Markierungskomponente
  implements Serializable
{
   protected String zEingabeBestaetigtBearbeiter = "";
  protected JTextField hatTextField;

  public Textfeld(double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     this.hatTextField = new JTextField();
     this.hatTextField.setOpaque(true);
     this.hatTextField.getDocument().addDocumentListener(new DokumentReaktor(null));
     this.hatTextField.addMouseMotionListener(new FeldMausReaktor(null));
     this.hatTextField.addFocusListener(new FeldFokusReaktor(null));
     this.hatTextField.addKeyListener(new FeldTastenReaktor(null));
     Bildschirm.topFenster.privatPanel().add(this.hatTextField, 0);
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatTextField);
     init(pLinks, pOben, pBreite, pHoehe, pText);
  }

  public Textfeld(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     this.hatTextField = new JTextField();
     this.hatTextField.setOpaque(true);
     this.hatTextField.getDocument().addDocumentListener(new DokumentReaktor(null));
     this.hatTextField.addMouseMotionListener(new FeldMausReaktor(null));
     this.hatTextField.addFocusListener(new FeldFokusReaktor(null));
     this.hatTextField.addKeyListener(new FeldTastenReaktor(null));
     pFenster.privatPanel().add(this.hatTextField, 0);
     lerneKomponenteKennen(pFenster, this.hatTextField);
     init(pLinks, pOben, pBreite, pHoehe, pText);
  }

  public Textfeld()
  {
  }

  public void setzeBearbeiterEingabeBestaetigt(String pBearbeiter)
  {
     this.zEingabeBestaetigtBearbeiter = pBearbeiter;
  }

  protected void inhaltGeaendert()
  {
     Class[] formparas = new Class[1];

     Textfeld[] meinTextfeld = new Textfeld[1];

     if (this.zInhaltGeaendertBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Textfeld.class;
             Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
             e2.printStackTrace();
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

     Textfeld[] meinTextfeld = new Textfeld[1];

     if (this.zEingabeBestaetigtBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(this.zEingabeBestaetigtBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Textfeld.class;
             Method methode = sumEreignis.getMethod(this.zEingabeBestaetigtBearbeiter, formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zEingabeBestaetigtBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
             e2.printStackTrace();
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

     Textfeld[] meinTextfeld = new Textfeld[1];

     if (this.zMarkierungGeaendertBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Textfeld.class;
             Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Textfelds: " + e2.getTargetException().toString());
             e2.printStackTrace();
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

     Textfeld[] meinTextfeld = new Textfeld[1];

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
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Textfelds: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Textfeld.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meinTextfeld[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinTextfeld);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Textfelds: " + e2.getTargetException().toString());
             e2.printStackTrace();
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

     Textfeld[] meinTextfeld = new Textfeld[1];

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

  public void setzeInhalt(String pText)
  {
     this.hatTextField.setText(pText);
  }

  public String inhaltAlsText()
  {
     return this.hatTextField.getText();
  }

  public String teilinhalt(int pAnfang, int pEnde)
  {
     String s = this.hatTextField.getText();
     return s.substring(pAnfang - 1, pEnde);
  }

  public void fuegeEin(String pText, int pStelle)
  {
     String s = this.hatTextField.getText();
     String s1 = s.substring(0, pStelle - 1);
     String s2 = s.substring(pStelle - 1, s.length());
     setzeInhalt(s1 + pText + s2);
  }

  public void haengeAn(String pText)
  {
     setzeInhalt(this.hatTextField.getText() + pText);
  }

  public void haengeAn(char pZeichen)
  {
     setzeInhalt(this.hatTextField.getText() + pZeichen);
  }

  public void haengeAn(int pZahl)
  {
     setzeInhalt(this.hatTextField.getText() + pZahl);
  }

  public void haengeAn(double pZahl)
  {
     setzeInhalt(this.hatTextField.getText() + pZahl);
  }

  public String markierterInhalt()
  {
     return this.hatTextField.getSelectedText();
  }

  public void setzeMarkierung(int pAnfang, int pEnde)
  {
     this.hatTextField.requestFocus();
     this.hatTextField.select(pAnfang - 1, pEnde);
     markierungGeaendert();
  }

  public void markiereAlles()
  {
     this.hatTextField.requestFocus();
     this.hatTextField.selectAll();
     markierungGeaendert();
  }

  public void markiereNichts()
  {
     this.hatTextField.requestFocus();
     this.hatTextField.select(0, 0);
     markierungGeaendert();
  }

  public void loescheAlles()
  {
     setzeInhalt("");
  }

  public void loescheMarkierung()
  {
     String s = this.hatTextField.getText();
     int von = this.hatTextField.getSelectionStart();
     int bis = this.hatTextField.getSelectionEnd();
     if (bis > von)
    {
       String s1 = s.substring(0, von);
       String s2 = s.substring(bis, s.length());
       setzeInhalt(s1 + s2);
       markierungGeaendert();
    }
  }

  public void loesche(int pAnfang, int pEnde)
  {
     String s = this.hatTextField.getText();
     String s1 = s.substring(0, pAnfang - 1);
     String s2 = s.substring(pEnde, s.length());
     setzeInhalt(s1 + s2);
     markierungGeaendert();
  }

  public boolean istMarkiert()
  {
     return this.hatTextField.getSelectionStart() < this.hatTextField.getSelectionEnd();
  }

  public int markierungsAnfang()
  {
     return this.hatTextField.getSelectionStart() + 1;
  }

  public int markierungsEnde()
  {
     return this.hatTextField.getSelectionEnd();
  }

  public void setzeAusrichtung(int pAusrichtung)
  {
     switch (pAusrichtung) {
    case 0:
       this.hatTextField.setHorizontalAlignment(2); break;
    case 1:
       this.hatTextField.setHorizontalAlignment(0); break;
    case 2:
       this.hatTextField.setHorizontalAlignment(4);
    }
  }

  private class FeldFokusReaktor
    implements FocusListener
  {
    private FeldFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Textfeld.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Textfeld.this.verliertFokus();
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
         Textfeld.this.eingabeBestaetigt();
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
       Textfeld.this.markierungGeaendert();
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
       Textfeld.this.inhaltGeaendert();
       Textfeld.this.markierungGeaendert();
    }

    public void removeUpdate(DocumentEvent e)
    {
       Textfeld.this.inhaltGeaendert();
       Textfeld.this.markierungGeaendert();
    }

    public void changedUpdate(DocumentEvent e)
    {
       Textfeld.this.inhaltGeaendert();
       Textfeld.this.markierungGeaendert();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Textfeld
 * JD-Core Version:    0.6.0
 */