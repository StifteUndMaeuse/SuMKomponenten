package sum.komponenten;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;

public class Menue extends Textkomponente
  implements Serializable
{
  private ActionListener hatListener;
  private JMenu hatMenu;

  public Menue(String pTitel)
  {
     this(pTitel, null);
  }

  protected Menue(String pTitel, JMenu pObermenu)
  {
     JMenuBar lMenuBar = Bildschirm.topFenster.getJMenuBar();
     this.hatMenu = new JMenu(pTitel);
     this.hatListener = new MenueReaktor(null);
     this.hatMenu.addActionListener(this.hatListener);
     if (pObermenu == null)
    {
       if (lMenuBar == null)
      {
         lMenuBar = new JMenuBar();
         Bildschirm.topFenster.setJMenuBar(lMenuBar);
      }
       lMenuBar.add(this.hatMenu);
    }
    else {
       pObermenu.add(this.hatMenu);
     }lMenuBar.setVisible(false);
     lMenuBar.setVisible(true);
  }

  protected void gewaehlt(String pAuftrag)
  {
     Class[] formparas = new Class[1];

     Menue[] meineAuswahl = new Menue[1];

     if (pAuftrag.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           methode = sumEreignis.getMethod(pAuftrag, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + pAuftrag + "\" eines Menues: " + e0.getTargetException().toString());
           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Menue.class;
             Method methode = sumEreignis.getMethod(pAuftrag, formparas);
             meineAuswahl[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meineAuswahl);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + pAuftrag + "\" eines Menues: " + e2.getTargetException().toString());
             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + pAuftrag + "\" eines Menues nicht gefunden.");
          }
        }
      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public void haengeZeileAn(String pText, String pAuftrag)
  {
     JMenuItem mi = new JMenuItem(pText);
     mi.addActionListener(this.hatListener);
     mi.setActionCommand(pAuftrag);
     this.hatMenu.add(mi);
  }

  public void haengeZeileAn(String pText, char pZeichen, boolean pMitShift, String pAuftrag)
  {
     KeyStroke msc = KeyStroke.getKeyStroke(pZeichen, 1, false);
     JMenuItem mi = new JMenuItem(pText);
     mi.setAccelerator(msc);
     mi.addActionListener(this.hatListener);
     mi.setActionCommand(pAuftrag);
     this.hatMenu.add(mi);
  }

  public void setzeInhalt(String pText)
  {
     this.hatMenu.setText(pText);
  }

  public String inhaltAlsText()
  {
     return this.hatMenu.getText();
  }

  public void setzeBearbeiterGewaehlt(int pZeile, String pAuftrag)
  {
     this.hatMenu.getItem(pZeile).setActionCommand(pAuftrag);
  }

  public Menue neuesUntermenue(String pText)
  {
     return new Menue(pText, this.hatMenu);
  }

  public void haengeTrennungAn()
  {
     this.hatMenu.addSeparator();
  }

  public int zeilenAnzahl()
  {
     return this.hatMenu.getItemCount();
  }

  public void deaktiviere()
  {
     this.hatMenu.setEnabled(false);
  }

  public void aktiviere()
  {
     this.hatMenu.setEnabled(true);
  }

  public boolean istAktiv()
  {
     return this.hatMenu.isEnabled();
  }

  public void deaktiviereZeile(int pZeile)
  {
     this.hatMenu.getItem(pZeile).setEnabled(false);
  }

  public void aktiviereZeile(int pZeile)
  {
     this.hatMenu.getItem(pZeile).setEnabled(true);
  }

  public boolean istZeileAktiv(int pZeile)
  {
     return this.hatMenu.getItem(pZeile).isEnabled();
  }

  public void setzeSchriftArt(String pSchriftart)
  {
     this.zAktuellFont = pSchriftart;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatMenu.setFont(this.zSchriftArt);
  }

  public void setzeSchriftGroesse(int pGroesse)
  {
     this.zSchriftGroesse = pGroesse;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatMenu.setFont(this.zSchriftArt);
  }

  public void setzeSchriftStil(int pStil)
  {
     this.zSchriftStil = pStil;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatMenu.setFont(this.zSchriftArt);
  }

  public void setzeSchriftstil(int pStil)
  {
     setzeSchriftStil(pStil);
  }

  public void setzeSchriftFarbe(Color pFarbe)
  {
  }

  protected void lerneKomponenteKennen(JComponent pKomponente)
  {
  }

  public void setzeBearbeiterFokusVerloren(String pBearbeiter)
  {
  }

  public void setzeBearbeiterFokusErhalten(String pBearbeiter)
  {
  }

  public void setzePosition(double pWohinH, double pWohinV)
  {
  }

  public void setzeGroesse(double pBreite, double pHoehe)
  {
  }

  public void setzeFarbe(Color pFarbe)
  {
  }

  public int links()
  {
     return 0;
  }

  public int oben()
  {
     return 0;
  }

  public int breite()
  {
     return 0;
  }

  public int hoehe()
  {
     return 0;
  }

  public void verstecke()
  {
  }

  public void zeige()
  {
  }

  public boolean istSichtbar()
  {
     return true;
  }

  public void setzeFokus()
  {
  }

  private class MenueReaktor
    implements ActionListener
  {
    private MenueReaktor()
    {
    }

    public void actionPerformed(ActionEvent e)
    {
       String cmd = e.getActionCommand();
       Menue.this.gewaehlt(cmd);
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Menue
 * JD-Core Version:    0.6.0
 */