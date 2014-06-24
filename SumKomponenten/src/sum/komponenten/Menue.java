package sum.komponenten;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;

public class Menue extends Textkomponente
  implements Serializable, ActionListener
{
  private JMenu hatMenu;

  public Menue(String pTitel)
  {
     this(pTitel, null);
  }

  public Menue(String pTitel, JMenu pObermenu)
  {
     JMenuBar lMenuBar = Bildschirm.topFenster.getJMenuBar();
     this.hatMenu = new JMenu(pTitel);
     this.hatMenu.addActionListener(this);
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
     }
     lMenuBar.setVisible(false);
     lMenuBar.setVisible(true);
  }


  private void bearbeiteEreigniss(String methodenName) {

        if (!methodenName.isEmpty()) {
            
            Method methode;
            Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();

            try {
                methode = sumEreignis.getMethod(methodenName);
                methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung);
            } catch (NoSuchMethodException e1) {
                System.out.println("Fehler: Methode \"" + methodenName + "\" eines Menues nicht gefunden.");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e2) {
                System.out.println("Fehler in Methode \"" + methodenName + "\" eines Menues: " + e2.getMessage());
                Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
    }
  public void haengeZeileAn(String pText, String pAuftrag)
  {
     JMenuItem mi = new JMenuItem(pText);
     mi.addActionListener(this);
     mi.setActionCommand(pAuftrag);
     this.hatMenu.add(mi);
  }

  public void haengeZeileAn(String pText, char pZeichen, boolean pMitShift, String pAuftrag)
  {
     KeyStroke msc = KeyStroke.getKeyStroke(pZeichen, 1, false);
     JMenuItem mi = new JMenuItem(pText);
     mi.setAccelerator(msc);
     mi.addActionListener(this);
     mi.setActionCommand(pAuftrag);
     this.hatMenu.add(mi);
  }

  @Override
  public void setzeInhalt(String pText)
  {
     this.hatMenu.setText(pText);
  }

  @Override
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

  @Override
  public void deaktiviere()
  {
     this.hatMenu.setEnabled(false);
  }

  @Override
  public void aktiviere()
  {
     this.hatMenu.setEnabled(true);
  }

  @Override
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

  @Override
  public void setzeSchriftArt(String pSchriftart)
  {
     this.zAktuellFont = pSchriftart;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatMenu.setFont(this.zSchriftArt);
  }

  @Override
  public void setzeSchriftGroesse(int pGroesse)
  {
     this.zSchriftGroesse = pGroesse;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatMenu.setFont(this.zSchriftArt);
  }

  @Override
  public void setzeSchriftStil(int pStil)
  {
     this.zSchriftStil = pStil;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatMenu.setFont(this.zSchriftArt);
  }

  @Override
  public void setzeSchriftstil(int pStil)
  {
     setzeSchriftStil(pStil);
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

  public boolean istSichtbar()
  {
     return true;
  }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.bearbeiteEreigniss(e.getActionCommand());
    }


}

