package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JCheckBox;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Schalter extends Textkomponente
        implements Serializable, KeyListener, ItemListener, FocusListener {

    private String zGeklicktBearbeiter = "";
    private JCheckBox hatCheckbox;

    public Schalter(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Schalter(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
    }

    public Schalter(double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift, String pGeklicktBearbeiter) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pAufschrift);
        this.zGeklicktBearbeiter = pGeklicktBearbeiter;
    }
    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pAufschrift){
        this.hatCheckbox = new JCheckBox(pAufschrift);
        this.hatCheckbox.setOpaque(true);
        pFenster.privatPanel().add(this.hatCheckbox, 0);
        this.hatCheckbox.addItemListener(this);
        this.hatCheckbox.addKeyListener(this);
        this.hatCheckbox.addFocusListener(this);
        lerneKomponenteKennen(pFenster, this.hatCheckbox);
        init(pLinks, pOben, pBreite, pHoehe);
    }

    public void setzeBearbeiterGeklickt(String pBearbeiter) {
        this.zGeklicktBearbeiter = pBearbeiter;
    }

    public void schalteAn() {
        this.hatCheckbox.setSelected(true);
    }

    public void schalteAus() {
        this.hatCheckbox.setSelected(false);
    }

    public boolean angeschaltet() {
        return this.hatCheckbox.isSelected();
    }

    @Override
    public void setzeInhalt(String pText) {
        this.hatCheckbox.setText(pText);
        this.kenntFenster.doUpdate(this.hatCheckbox);
    }

    @Override
    public String inhaltAlsText() {
        return this.hatCheckbox.getText();
    }

    //Fokus
    @Override
    public void focusGained(FocusEvent e) {
        this.bearbeiteEreigniss(this.fokusErhaltenBearbeiter());
    }
    @Override
    public void focusLost(FocusEvent e) {
       this.bearbeiteEreigniss(this.fokusVerlorenBearbeiter());
    }
    
    //geklickt
    @Override
    public void itemStateChanged(ItemEvent e) {
        this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
             this.bearbeiteEreigniss(this.zGeklicktBearbeiter);
        }
    }
    
    //ungenutzt
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
}

