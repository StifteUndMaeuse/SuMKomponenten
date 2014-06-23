package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Zeilenbereich extends Textbereich
  implements Serializable
{
  private JTextArea hatTextArea;
   private String zInhaltGeaendertBearbeiter = "";
   private String zMarkierungGeaendertBearbeiter = "";
  public static final String NEUERABSATZ = "\n";

  public Zeilenbereich(double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     super(pLinks, pOben, pBreite, pHoehe);
     this.hatScrollPane.setHorizontalScrollBarPolicy(30);
     this.hatTextArea = new JTextArea("", 2, 2);
     this.hatTextArea.setLineWrap(false);
     this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor(null));
     this.hatTextArea.addMouseMotionListener(new BereichMausReaktor(null));
     this.hatTextArea.addFocusListener(new BereichFokusReaktor(null));
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatTextArea);
     init(pLinks, pOben, pBreite, pHoehe, pText);
  }

  public Zeilenbereich(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     super(pFenster, pLinks, pOben, pBreite, pHoehe);
     this.hatScrollPane.setHorizontalScrollBarPolicy(30);
     this.hatTextArea = new JTextArea("", 2, 2);
     this.hatTextArea.setLineWrap(false);
     this.hatTextArea.getDocument().addDocumentListener(new DokumentReaktor(null));
     this.hatTextArea.addMouseMotionListener(new BereichMausReaktor(null));
     this.hatTextArea.addFocusListener(new BereichFokusReaktor(null));
     lerneKomponenteKennen(pFenster, this.hatTextArea);
     init(pLinks, pOben, pBreite, pHoehe, pText);
  }

  protected void inhaltGeaendert()
  {
     Class[] formparas = new Class[1];

     Zeilenbereich[] meinZeilenbereich = new Zeilenbereich[1];

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
           System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeilenbereich.class;
             Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, formparas);
             meinZeilenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeilenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Zeilenbereichs nicht gefunden.");
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

     Zeilenbereich[] meinZeilenbereich = new Zeilenbereich[1];

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
           System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeilenbereich.class;
             Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, formparas);
             meinZeilenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeilenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" eines Zeilenbereichs nicht gefunden.");
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

     Zeilenbereich[] meinZeilenbereich = new Zeilenbereich[1];

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
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeilenbereich.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meinZeilenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeilenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" eines Zeilenbereichs nicht gefunden.");
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

     Zeilenbereich[] meinZeilenbereich = new Zeilenbereich[1];

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
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Zeilenbereichs: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Zeilenbereich.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             meinZeilenbereich[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinZeilenbereich);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Zeilenbereichs: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" eines Zeilenbereichs nicht gefunden.");
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
     return this.hatTextArea.getLineCount();
  }

  public void neuerAbsatz()
  {
     this.hatTextArea.append("\n");
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void fuegeEin(String pText, int pZeile)
  {
    try
    {
       this.hatTextArea.insert(pText + '\n', this.hatTextArea.getLineStartOffset(pZeile - 1));
    }
    catch (Exception e)
    {
       System.out.println(e.toString());
    }
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void haengeAn(String pText)
  {
     this.hatTextArea.append(pText + '\n');
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void haengeAn(char pZeichen)
  {
     haengeAn("" + pZeichen);
  }

  public void haengeAn(int pZahl)
  {
     haengeAn("" + pZahl);
  }

  public void haengeAn(double pZahl)
  {
     haengeAn("" + pZahl);
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
    try
    {
       if (this.hatTextArea.getLineStartOffset(pAnfang - 1) == this.hatTextArea.getLineEndOffset(pEnde - 1)) {
         return "";
      }
       if (pEnde < anzahl()) {
         return this.hatTextArea.getText(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1) - this.hatTextArea.getLineStartOffset(pAnfang - 1) - 1);
      }

       return this.hatTextArea.getText(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1) - this.hatTextArea.getLineStartOffset(pAnfang - 1));
    }
    catch (Exception e)
    {
       System.out.println(e.toString());
     }return null;
  }

  public String markierterInhalt()
  {
     return this.hatTextArea.getSelectedText();
  }

  public void setzeMarkierung(int pAnfang, int pEnde)
  {
    try
    {
       this.hatTextArea.requestFocus();
       this.hatTextArea.select(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1));
       markierungGeaendert();
    }
    catch (Exception e)
    {
       System.out.println(e.toString());
    }
  }

  public void markiereAlles()
  {
     this.hatTextArea.requestFocus();
     this.hatTextArea.selectAll();
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
     markierungGeaendert();
  }

  public void markiereNichts()
  {
     this.hatTextArea.requestFocus();
     this.hatTextArea.select(0, 0);
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
     markierungGeaendert();
  }

  public void loescheAlles()
  {
     setzeInhalt("");
  }

  public void loescheMarkierung()
  {
     this.hatTextArea.cut();
     this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
  }

  public void loesche(int pAnfang, int pEnde)
  {
     setzeMarkierung(pAnfang, pEnde);
     loescheMarkierung();
  }

  public boolean istMarkiert()
  {
     return this.hatTextArea.getSelectionStart() < this.hatTextArea.getSelectionEnd();
  }

  public int markierungsAnfang()
  {
    try
    {
       return this.hatTextArea.getLineOfOffset(this.hatTextArea.getSelectionStart()) + 1;
    }
    catch (Exception e)
    {
       System.out.println(e.toString());
     }return 0;
  }

  public int markierungsEnde()
  {
    try
    {
       return this.hatTextArea.getLineOfOffset(this.hatTextArea.getSelectionEnd()) + 1;
    }
    catch (Exception e)
    {
       System.out.println(e.toString());
     }return 0;
  }

  private class BereichFokusReaktor
    implements FocusListener
  {
    private BereichFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Zeilenbereich.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Zeilenbereich.this.verliertFokus();
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
       Zeilenbereich.this.markierungGeaendert();
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
       Zeilenbereich.this.inhaltGeaendert();
       Zeilenbereich.this.markierungGeaendert();
    }

    public void removeUpdate(DocumentEvent e)
    {
       Zeilenbereich.this.inhaltGeaendert();
       Zeilenbereich.this.markierungGeaendert();
    }

    public void changedUpdate(DocumentEvent e)
    {
       Zeilenbereich.this.inhaltGeaendert();
       Zeilenbereich.this.markierungGeaendert();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Zeilenbereich
 * JD-Core Version:    0.6.0
 */