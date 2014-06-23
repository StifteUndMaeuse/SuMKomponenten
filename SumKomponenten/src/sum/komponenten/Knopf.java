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
import javax.swing.AbstractButton;
import javax.swing.JButton;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Knopf extends Textkomponente
        implements Serializable, ActionListener, FocusListener, KeyListener {

    private String zGeklicktBearbeiter = "";
    protected AbstractButton hatButton;

    public Knopf(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Knopf(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter) {
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Knopf(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Knopf(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter) {
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Knopf() {

    }

    private void erzeuge(Bildschirm fenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.hatButton = new JButton(pAufschrift);
        this.hatButton.setOpaque(true);
        fenster.privatPanel().add(this.hatButton, 0);
        this.hatButton.addActionListener(this);
        this.hatButton.addKeyListener(this);
        this.hatButton.addFocusListener(this);
        lerneKomponenteKennen(fenster, this.hatButton);
        init(pLinks, pOben, pBreite, pHoehe);
    }

    public void setzeBearbeiterGeklickt(String pBearbeiter) {
        this.zGeklicktBearbeiter = pBearbeiter;
    }

    private void knopfGeklickt() {
        if (!this.zGeklicktBearbeiter.isEmpty()) {
            this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
        }
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

    private void bekommtFokus() {
        setzeFokusWert(true);
        this.bearbeiteEreigniss(fokusErhaltenBearbeiter());
    }

    private void verliertFokus() {
        setzeFokusWert(false);
        this.bearbeiteEreigniss(fokusVerlorenBearbeiter());
    }

    @Override
    public void setzeInhalt(String pText) {
        this.hatButton.setText(pText);
        //Bildschirm.topFenster.doUpdate(this.hatButton);

    }

    @Override
    public String inhaltAlsText() {
        return this.hatButton.getText();
    }

    //Knopf geklickt
    @Override
    public void actionPerformed(ActionEvent e) {
        this.knopfGeklickt();
    }

    //Fokus erhalten
    @Override
    public void focusGained(FocusEvent e) {
        this.bekommtFokus();
    }

    //Fokus verloren
    @Override
    public void focusLost(FocusEvent e) {
        this.verliertFokus();
    }

    //Taste gedrückt
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.knopfGeklickt();
        }
    }

    //Implementiert aber nicht genutzt
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //Implementiert aber nicht genutzt

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
