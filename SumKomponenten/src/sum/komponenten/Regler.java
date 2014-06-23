package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Regler extends Komponente
  implements Serializable
{
   private String zGeaendertBearbeiter = "";
  private JSlider hatSlider;

  public Regler(int pStil, int pAnfangswert, int pMinwert, int pMaxwert)
  {
     this(10.0D, 10.0D, 10.0D, 10.0D, pAnfangswert, pMinwert, pMaxwert);
  }

  public Regler(double pLinks, double pOben, double pBreite, double pHoehe, int pAnfangswert, int pMinwert, int pMaxwert)
  {
     if (pHoehe > pBreite) {
       this.hatSlider = new JSlider(1, pMinwert, pMaxwert, pAnfangswert);
    }
    else {
       this.hatSlider = new JSlider(0, pMinwert, pMaxwert, pAnfangswert);
    }
     this.hatSlider.setOpaque(true);
     this.hatSlider.addChangeListener(new SliderReaktor());
     this.hatSlider.addFocusListener(new SliderFokusReaktor());
     Bildschirm.topFenster.privatPanel().add(this.hatSlider, 0);
     lerneKomponenteKennen(Bildschirm.topFenster, this.hatSlider);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public Regler(Fenster pFenster, int pStil, int pAnfangswert, int pMinwert, int pMaxwert)
  {
     this(pFenster, 10.0D, 10.0D, 10.0D, 10.0D, pAnfangswert, pMinwert, pMaxwert);
  }

  public Regler(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pAnfangswert, int pMinwert, int pMaxwert)
  {
     if (pHoehe > pBreite) {
       this.hatSlider = new JSlider(1, pMinwert, pMaxwert, pAnfangswert);
    }
    else {
       this.hatSlider = new JSlider(0, pMinwert, pMaxwert, pAnfangswert);
    }
     this.hatSlider.setOpaque(true);
     this.hatSlider.addChangeListener(new SliderReaktor());
     this.hatSlider.addFocusListener(new SliderFokusReaktor());
     pFenster.privatPanel().add(this.hatSlider, 0);
     lerneKomponenteKennen(pFenster, this.hatSlider);
     init(pLinks, pOben, pBreite, pHoehe);
  }

  public void setzeBearbeiterGeaendert(String pBearbeiter)
  {
     this.zGeaendertBearbeiter = pBearbeiter;
  }

  protected void geaendert()
  {
     Class[] formparas = new Class[1];

     Regler[] meinRegler = new Regler[1];

     if (this.zGeaendertBearbeiter.length() > 0)
    {
      try
      {
         Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();
        try
        {
           Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, null);
           methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, null);
        }
        catch (InvocationTargetException e0)
        {
           System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers: " + e0.getTargetException().toString());

           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Regler.class;
             Method methode = sumEreignis.getMethod(this.zGeaendertBearbeiter, formparas);

             meinRegler[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinRegler);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers: " + e2.getTargetException().toString());

             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers nicht gefunden.");
          }

        }

      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
     this.kenntFenster.doUpdate(this.hatSlider);
  }

  protected void bekommtFokus()
  {
     Class[] formparas = new Class[1];

     Regler[] meinRegler = new Regler[1];

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
           System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Reglers: " + e0.getTargetException().toString());

           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Regler.class;
             Method methode = sumEreignis.getMethod(fokusErhaltenBearbeiter(), formparas);

             meinRegler[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinRegler);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusErhaltenBearbeiter() + "\" eines Reglers: " + e2.getTargetException().toString());

             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusErhaltenBearbeiter() + "\" eines Reglers nicht gefunden.");
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

     Regler[] meinRegler = new Regler[1];

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
           System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Reglers: " + e0.getTargetException().toString());

           e0.printStackTrace();
        }
        catch (Exception e1)
        {
          try
          {
             formparas[0] = Regler.class;
             Method methode = sumEreignis.getMethod(fokusVerlorenBearbeiter(), formparas);

             meinRegler[0] = this;
             methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung, meinRegler);
          }
          catch (InvocationTargetException e2)
          {
             System.out.println("Fehler in Methode \"" + fokusVerlorenBearbeiter() + "\" eines Reglers: " + e2.getTargetException().toString());

             e2.printStackTrace();
          }
          catch (Exception e3)
          {
             System.out.println("Fehler: Methode \"" + fokusVerlorenBearbeiter() + "\" eines Reglers nicht gefunden.");
          }

        }

      }
      catch (Exception e4)
      {
         System.out.println("SuMAnwendung: " + e4.toString());
      }
    }
  }

  public void setzeWert(int pWert)
  {
     this.hatSlider.setValue(pWert);
     this.hatSlider.paintImmediately(0, 0, this.hatSlider.getWidth(), this.hatSlider.getHeight());

     this.hatSlider.validate();
  }

  public int wert()
  {
     return this.hatSlider.getValue();
  }

  public void setzeMinimum(int pWert)
  {
     this.hatSlider.setMinimum(pWert);
  }

  public int minimum()
  {
     return this.hatSlider.getMinimum();
  }

  public void setzeMaximum(int pWert)
  {
     this.hatSlider.setMaximum(pWert);
  }

  public int maximum()
  {
     return this.hatSlider.getMaximum();
  }

  private class SliderFokusReaktor
    implements FocusListener
  {
    private SliderFokusReaktor()
    {
    }

    public void focusGained(FocusEvent e)
    {
       Regler.this.bekommtFokus();
    }

    public void focusLost(FocusEvent e)
    {
       Regler.this.verliertFokus();
    }
  }

  private class SliderReaktor
    implements ChangeListener
  {
    private SliderReaktor()
    {
    }

    public void stateChanged(ChangeEvent e)
    {
       Regler.this.geaendert();
    }
  }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Regler
 * JD-Core Version:    0.6.0
 */