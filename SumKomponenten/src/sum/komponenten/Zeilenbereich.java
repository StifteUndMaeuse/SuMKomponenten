package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public class Zeilenbereich extends Textbereich
        implements Serializable, MouseMotionListener, FocusListener, DocumentListener {

    private JTextArea hatTextArea;
    private String zInhaltGeaendertBearbeiter = "";
    private String zMarkierungGeaendertBearbeiter = "";
    public static final String NEUERABSATZ = "\n";

    public Zeilenbereich(double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        super(pLinks, pOben, pBreite, pHoehe);
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pText);
    }

    public Zeilenbereich(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText) {
        super(pFenster, pLinks, pOben, pBreite, pHoehe);
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pText);
    }
    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, String pText){
        this.hatScrollPane.setHorizontalScrollBarPolicy(30);
        this.hatTextArea = new JTextArea("", 2, 2);
        this.hatTextArea.setLineWrap(false);
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
        return this.hatTextArea.getLineCount();
    }

    public void neuerAbsatz() {
        this.hatTextArea.append("\n");
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }

    @Override
    public void fuegeEin(String pText, int pZeile) {
        try {
            this.hatTextArea.insert(pText + '\n', this.hatTextArea.getLineStartOffset(pZeile - 1));
        } catch (BadLocationException e) {
            System.out.println(e.toString());
        }
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }

    @Override
    public void haengeAn(String pText) {
        this.hatTextArea.append(pText + '\n');
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }

    @Override
    public void haengeAn(char pZeichen) {
        haengeAn("" + pZeichen);
    }

    @Override
    public void haengeAn(int pZahl) {
        haengeAn("" + pZahl);
    }

    @Override
    public void haengeAn(double pZahl) {
        haengeAn("" + pZahl);
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
        try {
            if (this.hatTextArea.getLineStartOffset(pAnfang - 1) == this.hatTextArea.getLineEndOffset(pEnde - 1)) {
                return "";
            }
            if (pEnde < anzahl()) {
                return this.hatTextArea.getText(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1) - this.hatTextArea.getLineStartOffset(pAnfang - 1) - 1);
            }

            return this.hatTextArea.getText(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1) - this.hatTextArea.getLineStartOffset(pAnfang - 1));
        } catch (BadLocationException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    public String markierterInhalt() {
        return this.hatTextArea.getSelectedText();
    }

    @Override
    public void setzeMarkierung(int pAnfang, int pEnde) {
        try {
            this.hatTextArea.requestFocus();
            this.hatTextArea.select(this.hatTextArea.getLineStartOffset(pAnfang - 1), this.hatTextArea.getLineEndOffset(pEnde - 1));
            markierungGeaendert();
        } catch (BadLocationException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void markiereAlles() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.selectAll();
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
        markierungGeaendert();
    }

    @Override
    public void markiereNichts() {
        this.hatTextArea.requestFocus();
        this.hatTextArea.select(0, 0);
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
        markierungGeaendert();
    }

    @Override
    public void loescheAlles() {
        setzeInhalt("");
    }

    @Override
    public void loescheMarkierung() {
        this.hatTextArea.cut();
        this.hatTextArea.paintImmediately(0, 0, this.hatTextArea.getWidth(), this.hatTextArea.getHeight());
    }

    @Override
    public void loesche(int pAnfang, int pEnde) {
        setzeMarkierung(pAnfang, pEnde);
        loescheMarkierung();
    }

    @Override
    public boolean istMarkiert() {
        return this.hatTextArea.getSelectionStart() < this.hatTextArea.getSelectionEnd();
    }

    @Override
    public int markierungsAnfang() {
        try {
            return this.hatTextArea.getLineOfOffset(this.hatTextArea.getSelectionStart()) + 1;
        } catch (BadLocationException e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    @Override
    public int markierungsEnde() {
        try {
            return this.hatTextArea.getLineOfOffset(this.hatTextArea.getSelectionEnd()) + 1;
        } catch (BadLocationException e) {
            System.out.println(e.toString());
        }
        return 0;
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
