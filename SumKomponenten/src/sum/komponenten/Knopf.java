package sum.komponenten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import sum.ereignis.Bildschirm;
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
        this.zBearbeiterText = "eines Knopfes";
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
    
    @Override
    public void setzeInhalt(String pText) {
        this.hatButton.setText(pText);

    }

    @Override
    public String inhaltAlsText() {
        return this.hatButton.getText();
    }

    //Knopf geklickt
    @Override
    public void actionPerformed(ActionEvent e) {
        this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
    }

    //Fokus erhalten
    @Override
    public void focusGained(FocusEvent e) {
        setzeFokusWert(true);
        this.bearbeiteEreigniss(fokusErhaltenBearbeiter());
    }

    //Fokus verloren
    @Override
    public void focusLost(FocusEvent e) {
        setzeFokusWert(false);
        this.bearbeiteEreigniss(fokusVerlorenBearbeiter());
    }

    //Taste gedrückt
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
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
