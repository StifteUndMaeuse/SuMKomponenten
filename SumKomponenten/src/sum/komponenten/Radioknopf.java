package sum.komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Radioknopf extends Knopf
        implements Serializable, ActionListener, KeyListener, FocusListener {

    protected String zGeklicktBearbeiter = "";
    protected JRadioButton hatRadioButton;

    public Radioknopf(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Radioknopf(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
    }

    public Radioknopf(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Radioknopf(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
    }

    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.hatRadioButton = new JRadioButton(pAufschrift);
        this.hatButton = this.hatRadioButton;
        this.hatButton.setOpaque(true);
        pFenster.privatPanel().add(this.hatButton, 0);
        this.hatButton.addActionListener(this);
        this.hatButton.addKeyListener(this);
        this.hatButton.addFocusListener(this);
        lerneKomponenteKennen(pFenster, this.hatButton);
        init(pLinks, pOben, pBreite, pHoehe);
    }

    @Override
    public void setzeBearbeiterGeklickt(String pBearbeiter) {
        this.zGeklicktBearbeiter = pBearbeiter;
    }

    private void bearbeiteEreigniss(String methodenName) {

        if (!methodenName.isEmpty()) {

            Method methode;
            Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();

            try {
                methode = sumEreignis.getMethod(methodenName);
                methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung);
            } catch (NoSuchMethodException e1) {
                System.out.println("Fehler: Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + inhaltAlsText() + "\" nicht gefunden.");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e2) {
                System.out.println("Fehler in Methode \"" + this.zGeklicktBearbeiter + "\" von Knopf \"" + inhaltAlsText() + "\": " + e2.getMessage());
                Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
    }

    public boolean istGewaehlt() {
        return this.hatButton.isSelected();
    }

    public void waehle() {
        this.hatButton.setSelected(true);
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
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
    }

}
