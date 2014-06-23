package sum.komponenten;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;
import sum.ereignis.Schrift;

public class Tabelle extends Komponente
  implements Serializable, ScrollPaneConstants
{
   private String zInhaltGeaendertBearbeiter = "";
   private String zMarkierungGeaendertBearbeiter = "";
  private JTable hatTable;
  private JScrollPane hatScrollPane;
  private TableModel hatModel;
   protected String zAktuellFont = "Helvetica";
   protected int zSchriftStil = 0;
   protected int zSchriftGroesse = 12;
   protected Font zSchriftArt = Schrift.STANDARDSCHRIFT;

  public Tabelle(double pLinks, double pOben, double pBreite, double pHoehe, int pZeilen, int pSpalten)
  {
     this.hatTable = new JTable(pZeilen, pSpalten);
     this.hatModel = this.hatTable.getModel();
     this.hatModel.addTableModelListener(new TableDataReaktor());
     this.hatTable.addFocusListener(new BereichFokusReaktor());
     this.hatTable.getSelectionModel().addListSelectionListener(new AuswahlReaktor());
     this.hatScrollPane = new JScrollPane(22, 32);
     this.hatScrollPane.setSize(new Dimension(80, 80));
     Bildschirm.topFenster.privatPanel().add(this.hatScrollPane, 0);
     this.hatScrollPane.setViewportView(this.hatTable);
     this.hatTable.setCellSelectionEnabled(true);
     this.hatTable.setSelectionMode(1);
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatTable);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Tabelle(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pZeilen, int pSpalten)
  {
     this.hatTable = new JTable(pZeilen, pSpalten);
     this.hatModel = this.hatTable.getModel();
     this.hatModel.addTableModelListener(new TableDataReaktor());
     this.hatTable.addFocusListener(new BereichFokusReaktor());
     this.hatTable.getSelectionModel().addListSelectionListener(new AuswahlReaktor());
     this.hatScrollPane = new JScrollPane(22, 32);
     this.hatScrollPane.setSize(new Dimension(80, 80));
     pFenster.privatPanel().add(this.hatScrollPane, 0);
     this.hatScrollPane.setViewportView(this.hatTable);
     this.hatTable.setCellSelectionEnabled(true);
     this.hatTable.setSelectionMode(1);
     lerneKomponenteKennen(pFenster, this.hatTable);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  protected void inhaltGeaendert()
  {
     Class[] formparas = new Class[1];

     Tabelle[] meineTabelle = new Tabelle[1];

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
           System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" einer Tabelle: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Tabelle.class;
             Method methode = sumEreignis.getMethod(this.zInhaltGeaendertBearbeiter, formparas);
             meineTabelle[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineTabelle);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" einer Tabelle: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" einer Tabelle nicht gefunden.");
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

     Tabelle[] meineTabelle = new Tabelle[1];

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
           System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" einer Tabelle: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Tabelle.class;
             Method methode = sumEreignis.getMethod(this.zMarkierungGeaendertBearbeiter, formparas);
             meineTabelle[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineTabelle);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" einer Tabelle: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zMarkierungGeaendertBearbeiter + "\" einer Tabelle nicht gefunden.");
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

     Tabelle[] meineTabelle = new Tabelle[1];

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
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" einer Tabelle: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Tabelle.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);
             meineTabelle[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineTabelle);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" einer Tabelle: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" einer Tabelle nicht gefunden.");
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

     Tabelle[] meineTabelle = new Tabelle[1];

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
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" einer Tabelle: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Tabelle.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);
             meineTabelle[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineTabelle);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" einer Tabelle: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" einer Tabelle nicht gefunden.");
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

  public void setzeZeilenhoehe(int pHoehe)
  {
     this.hatTable.setRowHeight(pHoehe);
  }

  public void setzeSpaltenbreite(int pBreite)
  {
     this.hatTable.setAutoResizeMode(0);
     for (int i = 0; i < this.hatTable.getColumnCount(); i++)
       this.hatTable.getColumnModel().getColumn(i).setPreferredWidth(pBreite);
  }

  public int zeilenanzahl()
  {
     return this.hatTable.getRowCount();
  }

  public int spaltenanzahl()
  {
     return this.hatTable.getColumnCount();
  }

  public void setzeSpaltenanzahl(int pAnzahl)
  {
     ((DefaultTableModel)this.hatModel).setColumnCount(pAnzahl);
  }

  public void setzeZeilenanzahl(int pAnzahl)
  {
     ((DefaultTableModel)this.hatModel).setRowCount(pAnzahl);
  }

  public void haengeNeueSpalteAn()
  {
     this.hatTable.addColumn(new TableColumn());
  }

  public void haengeNeueZeileAn()
  {
     ((DefaultTableModel)this.hatModel).addRow(new Vector());
  }

  public void fuegeNeueSpalteEinAn(int pSpalte)
  {
     haengeNeueSpalteAn();
     this.hatTable.moveColumn(this.hatTable.getColumnCount() - 1, pSpalte);
  }

  public void fuegeNeueZeileEinAn(int pZeile)
  {
     ((DefaultTableModel)this.hatModel).insertRow(pZeile, new Vector());
  }

  public void entferneSpalteAn(int pSpalte)
  {
     this.hatTable.removeColumn(this.hatTable.getColumnModel().getColumn(pSpalte));
  }

  public void entferneZeileAn(int pZeile)
  {
     ((DefaultTableModel)this.hatModel).removeRow(pZeile);
  }

  public void setzeSpaltentitelAn(String pText, int pSpalte)
  {
     this.hatTable.getColumnModel().getColumn(pSpalte - 1).setHeaderValue(pText);
  }

  public String spaltentitel(int pSpalte)
  {
     return this.hatTable.getColumnName(pSpalte - 1);
  }

  public void setzeInhaltAn(String pText, int pZeile, int pSpalte)
  {
     this.hatTable.setValueAt(pText, pZeile - 1, pSpalte - 1);
  }

  public void setzeInhaltAn(char pZeichen, int pZeile, int pSpalte)
  {
     setzeInhaltAn("" + pZeichen, pZeile, pSpalte);
  }

  public void setzeInhaltAn(double pZahl, int pZeile, int pSpalte)
  {
     setzeInhaltAn("" + pZahl, pZeile, pSpalte);
  }

  public void setzeInhaltAn(int pZahl, int pZeile, int pSpalte)
  {
     setzeInhaltAn("" + pZahl, pZeile, pSpalte);
  }

  public void haengeAnAn(String pText, int pZeile, int pSpalte)
  {
     this.hatTable.setValueAt((String)this.hatTable.getValueAt(pSpalte - 1, pZeile - 1) + pText, pZeile - 1, pSpalte - 1);
  }

  public boolean inhaltIstTextAn(int pZeile, int pSpalte)
  {
     return (!inhaltIstGanzeZahlAn(pZeile, pSpalte)) && (!inhaltIstZahlAn(pZeile, pSpalte));
  }

  public boolean inhaltIstGanzeZahlAn(int pZeile, int pSpalte)
  {
    try
    {
       Integer.valueOf(inhaltAlsTextAn(pZeile, pSpalte));
       return true;
    }
    catch (Exception e) {
    }
     return false;
  }

  public boolean inhaltIstZahlAn(int pZeile, int pSpalte)
  {
    try
    {
       Double.valueOf(inhaltAlsTextAn(pZeile, pSpalte));
       return true;
    }
    catch (Exception e) {
    }
     return false;
  }

  public String inhaltAlsTextAn(int pZeile, int pSpalte)
  {
     return (String)this.hatTable.getValueAt(pZeile - 1, pSpalte - 1);
  }

  public int inhaltAlsGanzeZahlAn(int pZeile, int pSpalte)
    throws ArithmeticException
  {
     if (inhaltIstGanzeZahlAn(pZeile, pSpalte)) {
       return Integer.parseInt(inhaltAlsTextAn(pZeile, pSpalte));
    }
     throw new ArithmeticException("inhaltAlsGanzeZahlAn: ist keine ganze Zahl");
  }

  public double inhaltAlsZahlAn(int pZeile, int pSpalte)
    throws ArithmeticException
  {
     if (inhaltIstZahlAn(pZeile, pSpalte))
    {
       Double d = new Double(inhaltAlsTextAn(pZeile, pSpalte));
       return d.doubleValue();
    }

     throw new ArithmeticException("inhaltAlsZahlAn: ist keine Zahl");
  }

  public void setzeMarkierteZeilen(int pAnfang, int pEnde)
  {
     this.hatTable.addRowSelectionInterval(pAnfang - 1, pEnde - 1);
  }

  public void setzeMarkierteSpalten(int pAnfang, int pEnde)
  {
     this.hatTable.addColumnSelectionInterval(pAnfang - 1, pEnde - 1);
  }

  public void setzeMarkierteZelle(int pZeile, int pSpalte)
  {
     setzeMarkierteSpalten(pSpalte, pSpalte);
     setzeMarkierteZeilen(pZeile, pZeile);
  }

  public boolean istZelleMarkiert(int pZeile, int pSpalte)
  {
     return this.hatTable.isCellSelected(pZeile - 1, pSpalte - 1);
  }

  public boolean istZeileMarkiert(int pZeile)
  {
     return this.hatTable.isRowSelected(pZeile - 1);
  }

  public boolean istSpalteMarkiert(int pSpalte)
  {
     return this.hatTable.isColumnSelected(pSpalte - 1);
  }

  public void markiereAlles()
  {
     this.hatTable.selectAll();
  }

  public void markiereNichts()
  {
     this.hatTable.clearSelection();
  }

  public void setzeSchriftArt(String pSchriftart)
  {
     this.zAktuellFont = pSchriftart;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatTable.setFont(this.zSchriftArt);
  }

  public void setzeSchriftart(String pSchriftart)
  {
     setzeSchriftArt(pSchriftart);
  }

  public void setzeSchriftgroesse(int pGroesse)
  {
     setzeSchriftGroesse(pGroesse);
  }

  public void setzeSchriftGroesse(int pGroesse)
  {
     this.zSchriftGroesse = pGroesse;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatTable.setFont(this.zSchriftArt);
     this.hatTable.setRowHeight(this.hatTable.getFontMetrics(this.hatTable.getFont()).getHeight());
  }

  public void setzeSchriftStil(int pStil)
  {
     this.zSchriftStil = pStil;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatTable.setFont(this.zSchriftArt);
  }

  public void setzeSchriftstil(int pStil)
  {
     setzeSchriftStil(pStil);
  }

  public void setzeSchriftFarbe(Color pFarbe)
  {
     this.hatTable.setForeground(pFarbe);
  }

  public void setzeSchriftfarbe(Color pFarbe)
  {
     setzeSchriftFarbe(pFarbe);
  }

  public void setzeSchriftfarbe(int pFarbe)
  {
     setzeSchriftFarbe(pFarbe);
  }

  public void setzeSchriftFarbe(int pFarbe)
  {
     if (pFarbe < 0)
       pFarbe = 0;
     pFarbe %= 13;
     switch (pFarbe) {
    case 0:
       setzeSchriftFarbe(Color.black); break;
    case 1:
       setzeSchriftFarbe(Color.blue); break;
    case 2:
       setzeSchriftFarbe(Color.cyan); break;
    case 3:
       setzeSchriftFarbe(Color.darkGray); break;
    case 4:
       setzeSchriftFarbe(Color.gray); break;
    case 5:
       setzeSchriftFarbe(Color.green); break;
    case 6:
       setzeSchriftFarbe(Color.lightGray); break;
    case 7:
       setzeSchriftFarbe(Color.magenta); break;
    case 8:
       setzeSchriftFarbe(Color.orange); break;
    case 9:
       setzeSchriftFarbe(Color.pink); break;
    case 10:
       setzeSchriftFarbe(Color.red); break;
    case 11:
       setzeSchriftFarbe(Color.white); break;
    case 12:
       setzeSchriftFarbe(Color.yellow);
    }
  }

  private class BereichFokusReaktor
    implements FocusListener
  {
    private BereichFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Tabelle.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Tabelle.this.verliertFokus();
    }
  }

  private class AuswahlReaktor
    implements ListSelectionListener
  {
    private AuswahlReaktor()
    {
    }

    public void valueChanged(ListSelectionEvent e)
    {
       Tabelle.this.markierungGeaendert();
    }
  }

  private class TableDataReaktor
    implements TableModelListener
  {
    private TableDataReaktor()
    {
    }

    public void tableChanged(TableModelEvent e)
    {
       Tabelle.this.inhaltGeaendert();
       Tabelle.this.markierungGeaendert();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Tabelle
 * JD-Core Version:    0.6.0
 */