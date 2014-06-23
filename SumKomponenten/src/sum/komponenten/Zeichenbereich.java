package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Zeichenbereich extends Textbereich
  implements Serializable
{
  private JTextArea hatTextArea;
   private String zInhaltGeaendertBearbeiter = "";
   private String zMarkierungGeaendertBearbeiter = "";
  public static final String NEUERABSATZ = "\n";

  public Zeichenbereich(double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     super(pLinks, pOben, pBreite, pHoehe);
     this.hatTextArea = new JTextArea("", 2, 2);
     this.hatTextArea.setLineWrap(true);
     this.hatTextArea.setWrapStyleWord(true);
     this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor());
     this.hatTextArea.addMouseMotionListener(new BereichMausReaktor());
     this.hatTextArea.addFocusListener(new BereichFokusReaktor());
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatTextArea);
     init(pLinks, pOben, pBreite, pHoehe, pText);
  }

  public Zeichenbereich(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     super(pLinks, pOben, pBreite, pHoehe);
     this.hatTextArea = new JTextArea("", 2, 2);
     this.hatTextArea.setLineWrap(true);
     this.hatTextArea.setWrapStyleWord(true);
     this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor());
     this.hatTextArea.addMouseMotionListener(new BereichMausReaktor());
     this.hatTextArea.addFocusListener(new BereichFokusReaktor());
     lerneKomponenteKennen(pFenster, this.hatTextArea);
     init(pLinks, pOben, pBreite, pHoehe, pText);
  }

  protected void inhaltGeaendert()
  {
     Class[] formparas = new Class[1];

     Zeichenbereich[] meinZeichenbereich = new Zeichenbereich[1];

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
           System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeichenbereich.class;
             Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, formparas);
             meinZeichenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeichenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeichenbereichs nicht gefunden.");
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

     Zeichenbereich[] meinZeichenbereich = new Zeichenbereich[1];

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
           System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeichenbereich.class;
             Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, formparas);
             meinZeichenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeichenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeichenbereichs nicht gefunden.");
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

     Zeichenbereich[] meinZeichenbereich = new Zeichenbereich[1];

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
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeichenbereich.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meinZeichenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeichenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" eines Zeichenbereichs nicht gefunden.");
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

     Zeichenbereich[] meinZeichenbereich = new Zeichenbereich[1];

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
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Zeichenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeichenbereich.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             meinZeichenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeichenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Zeichenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" eines Zeichenbereichs nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public void setzeBearbeiterInhaltGeaendert(String pBearbeiter)
  {
     this.zInhaltGeaendertBearbeiter = pBearbeiter;
  }

  public void setzeBearbeiterMarkierungGeaendert(String pBearbeiter)
  {
     this.zMarkierungGeaendertBearbeiter = pBearbeiter;
  }

  public int anzahl()
  {
     return this.hatTextArea.getText().length();
  }

  public void neuerAbsatz()
  {
     this.hatTextArea.append("\n");
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void fuegeEin(String pText, int pStelle)
  {
     this.hatTextArea.insert(pText, pStelle - 1);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void haengeAn(String pText)
  {
     this.hatTextArea.append(pText);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void haengeAn(char pZeichen)
  {
     this.hatTextArea.append("" + pZeichen);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void haengeAn(int pZahl)
  {
     this.hatTextArea.append("" + pZahl);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void haengeAn(double pZahl)
  {
     this.hatTextArea.append("" + pZahl);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void setzeInhalt(String pText)
  {
     this.hatTextArea.setText(pText);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public String inhaltAlsText()
  {
     return this.hatTextArea.getText();
  }

  public String teilinhalt(int pAnfang, int pEnde)
  {
     String s = this.hatTextArea.getText();
     return s.substring(pAnfang - 1, pEnde);
  }

  public String markierterInhalt()
  {
     return this.hatTextArea.getSelectedText();
  }

  public void setzeMarkierung(int pAnfang, int pEnde)
  {
     this.hatTextArea.requestFocus();
     this.hatTextArea.select(pAnfang - 1, pEnde);
     markierungGeaendert();
  }

  public void markiereAlles()
  {
     this.hatTextArea.requestFocus();
     this.hatTextArea.selectAll();
     markierungGeaendert();
  }

  public void markiereNichts()
  {
     this.hatTextArea.requestFocus();
     this.hatTextArea.select(0, 0);
     markierungGeaendert();
  }

  public void loescheAlles()
  {
     setzeInhalt("");
  }

  public void loescheMarkierung()
  {
     String s = this.hatTextArea.getText();
     int von = this.hatTextArea.getSelectionStart();
     int bis = this.hatTextArea.getSelectionEnd();
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
     String s = this.hatTextArea.getText();
     String s1 = s.substring(0, pAnfang - 1);
     String s2 = s.substring(pEnde, s.length());
     setzeInhalt(s1 + s2);
     markierungGeaendert();
  }

  public boolean istMarkiert()
  {
     return this.hatTextArea.getSelectionStart() < this.hatTextArea.getSelectionEnd();
  }

  public int markierungsAnfang()
  {
     return this.hatTextArea.getSelectionStart() + 1;
  }

  public int markierungsEnde()
  {
     return this.hatTextArea.getSelectionEnd();
  }

  private class BereichFokusReaktor
    implements FocusListener
  {
    private BereichFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Zeichenbereich.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Zeichenbereich.this.verliertFokus();
    }
  }

  private class BereichMausReaktor
    implements MouseMotionListener
  {
    private BereichMausReaktor()
    {
    }

    public void mouseDragged(MouseEvent e)
    {
       Zeichenbereich.this.markierungGeaendert();
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
       Zeichenbereich.this.inhaltGeaendert();
       Zeichenbereich.this.markierungGeaendert();
    }

    public void removeUpdate(DocumentEvent e)
    {
       Zeichenbereich.this.inhaltGeaendert();
       Zeichenbereich.this.markierungGeaendert();
    }

    public void changedUpdate(DocumentEvent e)
    {
       Zeichenbereich.this.inhaltGeaendert();
       Zeichenbereich.this.markierungGeaendert();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Zeichenbereich
 * JD-Core Version:    0.6.0
 */