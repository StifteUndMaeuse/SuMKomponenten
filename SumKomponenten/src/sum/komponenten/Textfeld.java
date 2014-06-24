package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Textfeld extends Markierungskomponente
        implements Serializable, MouseMotionListener, FocusListener, DocumentListener, KeyListener {
    
    protected String zEingabeBestaetigtBearbeiter = "";
    protected JTextField hatTextField;
    
    public Textfeld(double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Textfeld(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Textfeld() {
    }
    
    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        this.hatTextField = new JTextField();
        this.hatTextField.setOpaque(true);
        this.hatTextField.getDocument().addDocumentListener(this);
        this.hatTextField.addMouseMotionListener(this);
        this.hatTextField.addFocusListener(this);
        this.hatTextField.addKeyListener(this);
        pFenster.privatPanel().add(this.hatTextField, 0);
        lerneKomponenteKennen(pFenster, this.hatTextField);
        init(pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public void setzeBearbeiterEingabeBestaetigt(String pBearbeiter) {
        this.zEingabeBestaetigtBearbeiter = pBearbeiter;
    }
    
    @Override
    public void setzeInhalt(String pText) {
        this.hatTextField.setText(pText);
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatTextField.getText();
    }
    
    @Override
    public String teilinhalt(int pAnfang, int pEnde) {
        String s = this.hatTextField.getText();
        return s.substring(pAnfang - 1, pEnde);
    }
    
    @Override
    public void fuegeEin(String pText, int pStelle) {
        String s = this.hatTextField.getText();
        String s1 = s.substring(0, pStelle - 1);
        String s2 = s.substring(pStelle - 1, s.length());
        setzeInhalt(s1 + pText + s2);
    }
    
    @Override
    public void haengeAn(String pText) {
        setzeInhalt(this.hatTextField.getText() + pText);
    }
    
    @Override
    public void haengeAn(char pZeichen) {
        setzeInhalt(this.hatTextField.getText() + pZeichen);
    }
    
    @Override
    public void haengeAn(int pZahl) {
        setzeInhalt(this.hatTextField.getText() + pZahl);
    }
    
    @Override
    public void haengeAn(double pZahl) {
        setzeInhalt(this.hatTextField.getText() + pZahl);
    }
    
    @Override
    public String markierterInhalt() {
        return this.hatTextField.getSelectedText();
    }
    
    @Override
    public void setzeMarkierung(int pAnfang, int pEnde) {
        this.hatTextField.requestFocus();
        this.hatTextField.select(pAnfang - 1, pEnde);
        markierungGeaendert();
    }
    
    @Override
    public void markiereAlles() {
        this.hatTextField.requestFocus();
        this.hatTextField.selectAll();
        markierungGeaendert();
    }
    
    @Override
    public void markiereNichts() {
        this.hatTextField.requestFocus();
        this.hatTextField.select(0, 0);
        markierungGeaendert();
    }
    
    @Override
    public void loescheAlles() {
        setzeInhalt("");
    }
    
    @Override
    public void loescheMarkierung() {
        String s = this.hatTextField.getText();
        int von = this.hatTextField.getSelectionStart();
        int bis = this.hatTextField.getSelectionEnd();
        if (bis > von) {
            String s1 = s.substring(0, von);
            String s2 = s.substring(bis, s.length());
            setzeInhalt(s1 + s2);
            markierungGeaendert();
        }
    }
    
    @Override
    public void loesche(int pAnfang, int pEnde) {
        String s = this.hatTextField.getText();
        String s1 = s.substring(0, pAnfang - 1);
        String s2 = s.substring(pEnde, s.length());
        setzeInhalt(s1 + s2);
        markierungGeaendert();
    }
    
    @Override
    public boolean istMarkiert() {
        return this.hatTextField.getSelectionStart() < this.hatTextField.getSelectionEnd();
    }
    
    @Override
    public int markierungsAnfang() {
        return this.hatTextField.getSelectionStart() + 1;
    }
    
    @Override
    public int markierungsEnde() {
        return this.hatTextField.getSelectionEnd();
    }
    
    public void setzeAusrichtung(int pAusrichtung) {
        switch (pAusrichtung) {
            case 0:
                this.hatTextField.setHorizontalAlignment(2);
                break;
            case 1:
                this.hatTextField.setHorizontalAlignment(0);
                break;
            case 2:
                this.hatTextField.setHorizontalAlignment(4);
        }
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
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.bearbeiteEreigniss(this.zEingabeBestaetigtBearbeiter);
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    @Override
    protected void markierungGeaendert() {
        
    }
    
}
