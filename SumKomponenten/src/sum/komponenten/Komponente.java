package sum.komponenten;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import sum.ereignis.Bildschirm;
import sum.ereignis.Ereignisanwendung;

public abstract class Komponente {

    private String zFokusErhaltenBearbeiter = "";
    private String zFokusVerlorenBearbeiter = "";
    private boolean zHatFokus = false;
    protected JComponent hatComponent;
    protected Bildschirm kenntFenster;
    protected String zBearbeiterText = "einer Komponente";

    protected void init(double pLinks, double pOben, double pBreite, double pHoehe) {
        setzePosition(pLinks, pOben);
        setzeGroesse(pBreite, pHoehe);
        setzeFarbe(this.kenntFenster.hintergrundfarbe());
    }

    protected void lerneKomponenteKennen(Bildschirm pFenster, JComponent pKomponente) {
        this.hatComponent = pKomponente;
        this.kenntFenster = pFenster;
    }
    protected void bearbeiteEreigniss(String methodenName) {

        if (!methodenName.isEmpty()) {

            Method methode;
            Class sumEreignis = Ereignisanwendung.hatSuMPrivateAnwendung.getClass();

            try {
                methode = sumEreignis.getMethod(methodenName);
                methode.invoke(Ereignisanwendung.hatSuMPrivateAnwendung);
            } catch (NoSuchMethodException e1) {
                System.out.println("Fehler: Methode \"" + methodenName+ "\" "+this.zBearbeiterText+" nicht gefunden.");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e2) {
                System.out.println("Fehler: Methode \"" + methodenName + "\" "+this.zBearbeiterText+": " + e2.getMessage());
                Logger.getLogger(Kennwortfeld.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
    }

    protected void setzeFokusWert(boolean pFokus) {
        this.zHatFokus = pFokus;
    }

    public void setzeBearbeiterFokusVerloren(String pBearbeiter) {
        this.zFokusVerlorenBearbeiter = pBearbeiter;
    }

    public void setzeBearbeiterFokusErhalten(String pBearbeiter) {
        this.zFokusErhaltenBearbeiter = pBearbeiter;
    }

    protected String fokusVerlorenBearbeiter() {
        return this.zFokusVerlorenBearbeiter;
    }

    protected String fokusErhaltenBearbeiter() {
        return this.zFokusErhaltenBearbeiter;
    }

    public void setzePosition(double pWohinH, double pWohinV) {
        this.hatComponent.setLocation((int) pWohinH, (int) pWohinV);
    }

    public void setzeGroesse(double pBreite, double pHoehe) {
        this.hatComponent.setSize((int) pBreite, (int) pHoehe);
    }

    public void setzeFarbe(Color pFarbe) {
        this.hatComponent.setBackground(pFarbe);
        this.hatComponent.repaint();
    }

    public void setzeFarbe(int pFarbe) {
        if (pFarbe < 0) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        switch (pFarbe) {
            case 0:
                setzeFarbe(Color.black);
                break;
            case 1:
                setzeFarbe(Color.blue);
                break;
            case 2:
                setzeFarbe(Color.cyan);
                break;
            case 3:
                setzeFarbe(Color.darkGray);
                break;
            case 4:
                setzeFarbe(Color.gray);
                break;
            case 5:
                setzeFarbe(Color.green);
                break;
            case 6:
                setzeFarbe(Color.lightGray);
                break;
            case 7:
                setzeFarbe(Color.magenta);
                break;
            case 8:
                setzeFarbe(Color.orange);
                break;
            case 9:
                setzeFarbe(Color.pink);
                break;
            case 10:
                setzeFarbe(Color.red);
                break;
            case 11:
                setzeFarbe(Color.white);
                break;
            case 12:
                setzeFarbe(Color.yellow);
        }

        this.hatComponent.repaint();
    }

    public Color farbe() {
        return this.hatComponent.getBackground();
    }

    public int links() {
        return this.hatComponent.getLocation().x;
    }

    public int oben() {
        return this.hatComponent.getLocation().y;
    }

    public int breite() {
        return this.hatComponent.getSize().width;
    }

    public int hoehe() {
        return this.hatComponent.getSize().height;
    }

    public void verstecke() {
        this.hatComponent.setVisible(false);
    }

    public void zeige() {
        this.hatComponent.setVisible(true);
    }

    public boolean istSichtbar() {
        return this.hatComponent.isVisible();
    }

    public void deaktiviere() {
        this.hatComponent.setEnabled(false);
    }

    public void aktiviere() {
        this.hatComponent.setEnabled(true);
    }

    public boolean istAktiv() {
        return this.hatComponent.isEnabled();
    }

    public boolean besitztFokus() {
        return this.zHatFokus;
    }

    public void setzeFokus() {
        this.hatComponent.requestFocus();
    }

    public void setzeHinweis(String pText) {
        this.hatComponent.setToolTipText(pText);
    }

    public void gibFrei() {
    }
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Komponente
 * JD-Core Version:    0.6.0
 */
