package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Zeichenbereich extends Textbereich
        implements Serializable, MouseMotionListener, FocusListener, DocumentListener {

    private JTextArea hatTextArea;
    private String zInhaltGeaendertBearbeiter = "";
    private String zMarkierungGeaendertBearbeiter = "";
    public static final String NEUERABSATZ = "\n";
    
    public Zeichenbereich(double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.erzeugen(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pText);
    }
    
    public Zeichenbereich(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.erzeugen(pFenster, pLinks, pOben, pBreite, pHoehe, pText);
    }

    private void erzeugen(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        this.hatTextArea = new JTextArea("", 2, 2);
        this.hatTextArea.setLineWrap(true);
        this.hatTextArea.setWrapStyleWord(true);
        this.hatTextArea.getDocument().addDocumentListener(this);
        this.hatTextArea.addMouseMotionListener(this);
        this.hatTextArea.addFocusListener(this);
        lerneKomponenteKennen(pFenster, this.hatTextArea);
        init(pLinks, pOben, pBreite, pHoehe, pText);        
    }
    
    @Override
    public void setzeBearbeiterInhaltGeaendert(String pBearbeiter) {
        this.zInhaltGeaendertBearbeiter = pBearbeiter;
    }
    
    @Override
    public void setzeBearbeiterMarkierungGeaendert(String pBearbeiter) {
        this.zMarkierungGeaendertBearbeiter = pBearbeiter;
    }
    
    public int anzahl() {
        return this.hatTextArea.getText().length();
    }
    
    public void neuerAbsatz() {
        this.hatTextArea.append("\n");
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void fuegeEin(String pText, int pStelle) {
        this.hatTextArea.insert(pText, pStelle - 1);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(String pText) {
        this.hatTextArea.append(pText);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(char pZeichen) {
        this.hatTextArea.append("" + pZeichen);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(int pZahl) {
        this.hatTextArea.append("" + pZahl);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void haengeAn(double pZahl) {
        this.hatTextArea.append("" + pZahl);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public void setzeInhalt(String pText) {
        this.hatTextArea.setText(pText);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }
    
    @Override
    public String inhaltAlsText() {
        return this.hatTextArea.getText();
    }
    
    @Override
    public String teilinhalt(int pAnfang, int pEnde) {
        String s = this.hatTextArea.getText();
        return s.substring(pAnfang - 1, pEnde);
    }
    
    @Override
    public String markierterInhalt() {
        return this.hatTextArea.getSelectedText();
    }
    
    @Override
    public void setzeMarkierung(int pAnfang, int pEnde) {
        this.hatTextArea.requestFocus();
        this.hatTextArea.select(pAnfang - 1, pEnde);
        markierungGeaendert();
    }
    
    @Override
    public void markiereAlles() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.selectAll();
        markierungGeaendert();
    }
    
    @Override
    public void markiereNichts() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.select(0, 0);
        markierungGeaendert();
    }
    
    @Override
    public void loescheAlles() {
        setzeInhalt("");
    }
    
    @Override
    public void loescheMarkierung() {
        String s = this.hatTextArea.getText();
        int von = this.hatTextArea.getSelectionStart();
        int bis = this.hatTextArea.getSelectionEnd();
        if (bis > von) {
            String s1 = s.substring(0, von);
            String s2 = s.substring(bis, s.length());
            setzeInhalt(s1 + s2);
            markierungGeaendert();
        }
    }
    
    @Override
    public void loesche(int pAnfang, int pEnde) {
        String s = this.hatTextArea.getText();
        String s1 = s.substring(0, pAnfang - 1);
        String s2 = s.substring(pEnde, s.length());
        setzeInhalt(s1 + s2);
        markierungGeaendert();
    }
    
    @Override
    public boolean istMarkiert() {
        return this.hatTextArea.getSelectionStart() < this.hatTextArea.getSelectionEnd();
    }
    
    @Override
    public int markierungsAnfang() {
        return this.hatTextArea.getSelectionStart() + 1;
    }
    
    @Override
    public int markierungsEnde() {
        return this.hatTextArea.getSelectionEnd();
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
    public void mouseMoved(MouseEvent e) {
    }
    
    @Override
    protected void markierungGeaendert() {
        
    }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Zeichenbereich
 * JD-Core Version:    0.6.0
 */
