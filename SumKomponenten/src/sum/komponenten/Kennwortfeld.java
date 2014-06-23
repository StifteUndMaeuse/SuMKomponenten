package sum.komponenten;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;
import sum.ereignis.Fenster;

public class Kennwortfeld extends Textfeld
        implements Serializable, FocusListener, KeyListener, MouseMotionListener, DocumentListener {

    protected JPasswordField hatPasswordField;

    public Kennwortfeld(double pLinks, double pOben, double pBreite, double pHoehe, char pEchozeichen) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pEchozeichen);
    }

    public Kennwortfeld(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, char pEchozeichen) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pEchozeichen);
    }

    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, char pEchozeichen) {
        this.hatPasswordField = new JPasswordField();
        this.hatPasswordField.setOpaque(true);
        this.hatTextField = this.hatPasswordField;
        this.hatPasswordField.getDocument().addDocumentListener(this);
        this.hatPasswordField.addMouseMotionListener(this);
        this.hatPasswordField.addFocusListener(this);
        this.hatPasswordField.addKeyListener(this);
        this.hatPasswordField.setEchoChar(pEchozeichen);
        pFenster.privatPanel().add(this.hatPasswordField, 0);
        lerneKomponenteKennen(pFenster, this.hatPasswordField);
        init(pLinks, pOben, pBreite, pHoehe, "");
    }

    private void bearbeiteEreigniss(String methodenName) {

        if (!methodenName.isEmpty()) {

            Method methode;
            Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();

            try {
                methode = sumEreignis.getMethod(methodenName);
                methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung);
            } catch (NoSuchMethodException e1) {
                System.out.println("Fehler: Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds nicht gefunden.");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e2) {
                System.out.println("Fehler in Methode \"" + this.zInhaltGeaendertBearbeiter + "\" eines Textfelds: " + e2.getMessage());
                Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
    }

    @Override
    public void setzeBearbeiterEingabeBestaetigt(String pBearbeiter) {
        this.zEingabeBestaetigtBearbeiter = pBearbeiter;
    }

    public void setzeKennwortzeichen(char pZeichen) {
        this.hatPasswordField.setEchoChar(pZeichen);
    }

    public void setzeKennwortZeichen(char pZeichen) {
        this.hatPasswordField.setEchoChar(pZeichen);
    }

    public char kennwortzeichen() {
        return this.hatPasswordField.getEchoChar();
    }

    public char kennwortZeichen() {
        return this.hatPasswordField.getEchoChar();
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

    //Enter gedrückt

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            this.bearbeiteEreigniss(this.zEingabeBestaetigtBearbeiter);
        }
    }

    //Makierung geändert

    @Override
    public void mouseDragged(MouseEvent e) {
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }

    //Zeichen eingefügt

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    //Zeichen entfernt
    @Override
    public void removeUpdate(DocumentEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    //Zeichen geändert
    @Override
    public void changedUpdate(DocumentEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }

    //nicht genutzt
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
