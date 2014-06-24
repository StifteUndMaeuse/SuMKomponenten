package sum.komponenten;

import java.io.Serializable;
import javax.swing.JLabel;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Etikett extends Textkomponente
  implements Serializable
{
  private JLabel hatLabel;

  public Etikett(double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, "" + pText);
  }

  public Etikett(double pLinks, double pOben, double pBreite, double pHoehe, int pZahl)
  {
     this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, "" + pZahl);
  }

  public Etikett(double pLinks, double pOben, double pBreite, double pHoehe, double pZahl)
  {
      this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, "" + pZahl);
  }

  public Etikett(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText)
  {
     this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pText);
  }

  public Etikett(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pZahl)
  {
     this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, "" + pZahl);
  }

  public Etikett(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, double pZahl)
  {
     this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, "" + pZahl);
  }
  
  private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText){
     this.hatLabel = new JLabel(pText);
     this.hatLabel.setOpaque(false);
     pFenster.privatPanel().add(this.hatLabel, 0);
     lerneKomponenteKennen(pFenster, this.hatLabel);
     init(pLinks, pOben, pBreite, pHoehe, pText); 
  }

  @Override
  public void setzeInhalt(String pText)
  {
     this.hatLabel.setText(pText);
     //this.kenntFenster.doUpdate(this.hatLabel);
  }

  public void fuegeEin(String pText, int pStelle)
  {
     String s = this.hatLabel.getText();
     String s1 = s.substring(0, pStelle - 1);
     String s2 = s.substring(pStelle, s.length());
     this.hatLabel.setText(s1 + pText + s2);
     //this.kenntFenster.doUpdate(this.hatLabel);
  }

  public void haengeAn(String pText)
  {
     this.hatLabel.setText(this.hatLabel.getText() + pText);
     //this.kenntFenster.doUpdate(this.hatLabel);
  }

  public void haengeAn(char pZeichen)
  {
     this.hatLabel.setText(this.hatLabel.getText() + pZeichen);
     //this.kenntFenster.doUpdate(this.hatLabel);
  }

  public void haengeAn(int pZahl)
  {
     this.hatLabel.setText(this.hatLabel.getText() + pZahl);
    // this.kenntFenster.doUpdate(this.hatLabel);
  }

  public void haengeAn(double pZahl)
  {
     this.hatLabel.setText(this.hatLabel.getText() + pZahl);
    // this.kenntFenster.doUpdate(this.hatLabel);
  }

  public void setzeAusrichtung(int pAusrichtung)
  {
     switch (pAusrichtung) {
    case 0:
       this.hatLabel.setHorizontalAlignment(2); break;
    case 1:
       this.hatLabel.setHorizontalAlignment(0); break;
    case 2:
       this.hatLabel.setHorizontalAlignment(4);
    }
  }

  @Override
  public String inhaltAlsText()
  {
     return this.hatLabel.getText();
  }
}

