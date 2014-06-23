package sum.komponenten;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import sum.ereignis.Schrift;

public abstract class Textkomponente extends Komponente
{
   protected String zAktuellFont = "Helvetica";
   protected int zSchriftStil = 0;
   protected int zSchriftGroesse = 12;
   protected Font zSchriftArt = Schrift.STANDARDSCHRIFT;

  protected void init(double pLinks, double pOben, double pBreite, double pHoehe, String pInhalt)
  {
     super.init(pLinks, pOben, pBreite, pHoehe);
     setzeInhalt(pInhalt);
  }

  public abstract void setzeInhalt(String paramString);

  public void setzeInhalt(char pZeichen)
  {
     setzeInhalt("" + pZeichen);
  }

  public void setzeInhalt(int pZahl)
  {
     setzeInhalt("" + pZahl);
  }

  public void setzeInhalt(long pZahl)
  {
     setzeInhalt("" + pZahl);
  }

  public void setzeInhalt(double pZahl)
  {
     setzeInhalt("" + pZahl);
  }

  public boolean inhaltIstText()
  {
     return (!inhaltIstGanzeZahl()) && (!inhaltIstZahl());
  }

  public boolean inhaltIstGanzeZahl()
  {
    try
    {
       Integer.valueOf(inhaltAlsText());
       return true;
    }
    catch (Exception e) {
    }
     return false;
  }

  public boolean inhaltIstLangeGanzeZahl()
  {
    try
    {
       Long.valueOf(inhaltAlsText());
       return true;
    }
    catch (Exception e) {
    }
     return false;
  }

  public boolean inhaltIstZahl()
  {
    try
    {
       Double.valueOf(inhaltAlsText());
       return true;
    }
    catch (Exception e) {
    }
     return false;
  }

  public abstract String inhaltAlsText();

  public int inhaltAlsGanzeZahl()
    throws ArithmeticException
  {
     if (inhaltIstGanzeZahl()) {
       return Integer.parseInt(inhaltAlsText());
    }
     throw new ArithmeticException("inhaltAlsGanzeZahl: ist keine ganze Zahl");
  }

  public long inhaltAlsLangeGanzeZahl()
    throws ArithmeticException
  {
     if (inhaltIstLangeGanzeZahl()) {
       return Long.parseLong(inhaltAlsText());
    }
     throw new ArithmeticException("inhaltAlsLangeGanzeZahl: ist keine lange ganze Zahl");
  }

  public double inhaltAlsZahl()
    throws ArithmeticException
  {
     if (inhaltIstZahl())
    {
       Double d = new Double(inhaltAlsText());
       return d.doubleValue();
    }

     throw new ArithmeticException("inhaltAlsZahl: ist keine Zahl");
  }

  public void setzeSchriftArt(String pSchriftart)
  {
     this.zAktuellFont = pSchriftart;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatComponent.setFont(this.zSchriftArt);
     this.hatComponent.repaint();
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
     this.hatComponent.setFont(this.zSchriftArt);
     this.hatComponent.repaint();
  }

  public void setzeSchriftStil(int pStil)
  {
     this.zSchriftStil = pStil;
     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
     this.hatComponent.setFont(this.zSchriftArt);
     this.hatComponent.repaint();
  }

  public void setzeSchriftstil(int pStil)
  {
     setzeSchriftStil(pStil);
  }

  public void setzeSchriftFarbe(Color pFarbe)
  {
     this.hatComponent.setForeground(pFarbe);
     this.hatComponent.repaint();
  }

  public void setzeSchriftfarbe(Color pFarbe)
  {
     setzeSchriftFarbe(pFarbe);
  }

  public void setzeSchriftfarbe(int pFarbe)
  {
     setzeSchriftFarbe(pFarbe);
  }

  public Color schriftfarbe()
  {
     return this.hatComponent.getForeground();
  }

  public Color schriftFarbe()
  {
     return schriftfarbe();
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
     this.hatComponent.repaint();
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Textkomponente
 * JD-Core Version:    0.6.0
 */