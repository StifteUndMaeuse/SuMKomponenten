package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import javax.swing.JComboBox;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Auswahl extends Komponente
        implements Serializable, ItemListener, FocusListener{

    private String zGeaendertBearbeiter = "";
    private JComboBox hatComboBox;

    public Auswahl(double pLinks, double pOben, double pBreite, double pHoehe) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe);
    }

    public Auswahl(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe);
    }

    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe) {
        this.zBearbeiterText = "einer Auswahl";
        this.hatComboBox = new JComboBox();
        this.hatComboBox.setOpaque(true);
        pFenster.privatPanel().add(this.hatComboBox, 0);
        this.hatComboBox.addItemListener(this);
        this.hatComboBox.addFocusListener(this);
        lerneKomponenteKennen(pFenster, this.hatComboBox);
        init(pLinks, pOben, pBreite, pHoehe);
    }

    public void setzeBearbeiterGeaendert(String pBearbeiter) {
        this.zGeaendertBearbeiter = pBearbeiter;
    }


    public void haengeAn(String pText) {
        this.hatComboBox.addItem(pText);
    }

    public int index() {
        return this.hatComboBox.getSelectedIndex() + 1;
    }

    public String text() {
        return (String) this.hatComboBox.getSelectedItem();
    }

    public void waehle(int pIndex) {
        this.hatComboBox.setSelectedIndex(pIndex - 1);
    }

    public void waehle(String pText) {
        this.hatComboBox.setSelectedItem(pText);
    }

    public int zeilenAnzahl() {
        return this.hatComboBox.getItemCount();
    }

    public void entferneAlleZeilen() {
        this.hatComboBox.removeAllItems();
    }
    
    //Auswahl wurde geändert
    @Override
    public void itemStateChanged(ItemEvent e) {
        this.bearbeiteEreigniss(this.zGeaendertBearbeiter);  
    }
    //Fokus erhalten
    @Override
    public void focusGained(FocusEvent e) {
        setzeFokusWert(true);
        this.bearbeiteEreigniss(this.fokusErhaltenBearbeiter());
    }
    //Fokus verloren
    @Override
    public void focusLost(FocusEvent e) {
        setzeFokusWert(false);
        this.bearbeiteEreigniss(this.fokusVerlorenBearbeiter());
    }
}