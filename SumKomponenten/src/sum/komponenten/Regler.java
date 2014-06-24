package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Regler extends Komponente
        implements Serializable, FocusListener, ChangeListener {

    private String zGeaendertBearbeiter = "";
    private JSlider hatSlider;

    public Regler(int pStil, int pAnfangswert, int pMinwert, int pMaxwert) {
        this.erzeuge(Bildschirm.topFenster,10.0D, 10.0D, 10.0D, 10.0D, pAnfangswert, pMinwert, pMaxwert);
    }

    public Regler(double pLinks, double pOben, double pBreite, double pHoehe, int pAnfangswert, int pMinwert, int pMaxwert) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAnfangswert, pMinwert, pMaxwert);
    }

    public Regler(Fenster pFenster, int pStil, int pAnfangswert, int pMinwert, int pMaxwert) {
        this.erzeuge(pFenster, 10.0D, 10.0D, 10.0D, 10.0D, pAnfangswert, pMinwert, pMaxwert);
    }

    public Regler(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pAnfangswert, int pMinwert, int pMaxwert) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pAnfangswert, pMinwert, pMaxwert);
    }
    
    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pAnfangswert, int pMinwert, int pMaxwert){
        if (pHoehe > pBreite) {
            this.hatSlider = new JSlider(1, pMinwert, pMaxwert, pAnfangswert);
        } else {
            this.hatSlider = new JSlider(0, pMinwert, pMaxwert, pAnfangswert);
        }
        this.hatSlider.setOpaque(true);
        this.hatSlider.addChangeListener(this);
        this.hatSlider.addFocusListener(this);
        pFenster.privatPanel().add(this.hatSlider, 0);
        lerneKomponenteKennen(pFenster, this.hatSlider);
        init(pLinks, pOben, pBreite, pHoehe);
    }
    
    public void setzeBearbeiterGeaendert(String pBearbeiter) {
        this.zGeaendertBearbeiter = pBearbeiter;
    }

    private void bearbeiteEreigniss(String methodenName) {

        if (!methodenName.isEmpty()) {

            Method methode;
            Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();

            try {
                methode = sumEreignis.getMethod(methodenName);
                methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung);
            } catch (NoSuchMethodException e1) {
                System.out.println("Fehler: Methode \"" + this.zGeaendertBearbeiter + "\" einer Auswahl nicht gefunden.");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e2) {
                System.out.println("Fehler: Methode \"" + this.zGeaendertBearbeiter + "\" eines Reglers nicht gefunden.");
                Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
    }

    public void setzeWert(int pWert) {
        this.hatSlider.setValue(pWert);
        this.hatSlider.paintImmediately(0, 0, this.hatSlider.getWidth(), this.hatSlider.getHeight());

        this.hatSlider.validate();
    }

    public int wert() {
        return this.hatSlider.getValue();
    }

    public void setzeMinimum(int pWert) {
        this.hatSlider.setMinimum(pWert);
    }

    public int minimum() {
        return this.hatSlider.getMinimum();
    }

    public void setzeMaximum(int pWert) {
        this.hatSlider.setMaximum(pWert);
    }

    public int maximum() {
        return this.hatSlider.getMaximum();
    }

    @Override
    public void focusGained(FocusEvent e) {
       this.bearbeiteEreigniss(this.fokusErhaltenBearbeiter());
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.bearbeiteEreigniss(this.fokusVerlorenBearbeiter());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.bearbeiteEreigniss(this.zGeaendertBearbeiter);
    }
}

