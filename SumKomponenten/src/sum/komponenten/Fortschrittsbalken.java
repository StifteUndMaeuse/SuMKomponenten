package sum.komponenten;

import java.io.Serializable;
import javax.swing.JProgressBar;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Fortschrittsbalken extends Komponente
  implements Serializable
{
  private JProgressBar hatProgressBar;

  public Fortschrittsbalken(Fenster pFenster, int pStil, int pMinWert, int pMaxWert)
  {
     this.erzeuge(pFenster, 10.0D, 10.0D, 10.0D, 10.0D, pMinWert, pMaxWert);
  }

  public Fortschrittsbalken(int pStil, int pMinWert, int pMaxWert)
  {
     this.erzeuge(Bildschirm.topFenster,10.0D, 10.0D, 10.0D, 10.0D, pMinWert, pMaxWert);
  }

  public Fortschrittsbalken(double pLinks, double pOben, double pBreite, double pHoehe, int pMinWert, int pMaxWert)
  {
     this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pMinWert, pMaxWert);
  }

  public Fortschrittsbalken(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pMinWert, int pMaxWert)
  {
    this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pMinWert, pMaxWert);
  }
  
  private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pMinWert, int pMaxWert){
      if (pHoehe > pBreite) {
       this.hatProgressBar = new JProgressBar(1, pMinWert, pMaxWert);
    }
    else {
       this.hatProgressBar = new JProgressBar(0, pMinWert, pMaxWert);
    }
     this.hatProgressBar.setOpaque(true);
     pFenster.privatPanel().add(this.hatProgressBar, 0);
     lerneKomponenteKennen(pFenster, this.hatProgressBar);
     init(pLinks, pOben, pBreite, pHoehe);
  }
  
  
  

  public void setzeWert(int pWert)
  {
     this.hatProgressBar.setValue(pWert);
     this.hatProgressBar.paintImmediately(0, 0, this.hatProgressBar.getWidth(), this.hatProgressBar.getHeight());
  }

  public int wert()
  {
     return this.hatProgressBar.getValue();
  }

  public void setzeMinimum(int pWert)
  {
     this.hatProgressBar.setMinimum(pWert);
  }

  public int minimum()
  {
     return this.hatProgressBar.getMinimum();
  }

  public void setzeMaximum(int pWert)
  {
     this.hatProgressBar.setMaximum(pWert);
  }

  public int maximum()
  {
     return this.hatProgressBar.getMaximum();
  }
}

