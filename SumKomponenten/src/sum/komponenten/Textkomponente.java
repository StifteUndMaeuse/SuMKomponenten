package sum.komponenten;

import java.awt.Color;
import java.awt.Font;
import sum.ereignis.Schrift;

public abstract class Textkomponente extends Komponente {

    protected String zAktuellFont = "Helvetica";
    protected int zSchriftStil = 0;
    protected int zSchriftGroesse = 12;
    protected Font zSchriftArt = Schrift.STANDARDSCHRIFT;

    protected void init(double pLinks, double pOben, double pBreite, double pHoehe, String pInhalt) {
        super.init(pLinks, pOben, pBreite, pHoehe);
        setzeInhalt(pInhalt);
    }

    public abstract void setzeInhalt(String paramString);

    public void setzeInhalt(char pZeichen) {
        setzeInhalt("" + pZeichen);
    }

    public void setzeInhalt(int pZahl) {
        setzeInhalt("" + pZahl);
    }

    public void setzeInhalt(long pZahl) {
        setzeInhalt("" + pZahl);
    }

    public void setzeInhalt(double pZahl) {
        setzeInhalt("" + pZahl);
    }

    public boolean inhaltIstText() {
        return (!inhaltIstGanzeZahl()) && (!inhaltIstZahl());
    }

    public boolean inhaltIstGanzeZahl() {
        try {
            Integer.valueOf(inhaltAlsText());
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public boolean inhaltIstLangeGanzeZahl() {
        try {
            Long.valueOf(inhaltAlsText());
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public boolean inhaltIstZahl() {
        try {
            Double.valueOf(inhaltAlsText());
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public abstract String inhaltAlsText();

    public int inhaltAlsGanzeZahl()
            throws ArithmeticException {
        if (inhaltIstGanzeZahl()) {
            return Integer.parseInt(inhaltAlsText());
        }
        throw new ArithmeticException("inhaltAlsGanzeZahl: ist keine ganze Zahl");
    }

    public long inhaltAlsLangeGanzeZahl()
            throws ArithmeticException {
        if (inhaltIstLangeGanzeZahl()) {
            return Long.parseLong(inhaltAlsText());
        }
        throw new ArithmeticException("inhaltAlsLangeGanzeZahl: ist keine lange ganze Zahl");
    }

    public double inhaltAlsZahl()
            throws ArithmeticException {
        if (inhaltIstZahl()) {
            Double d = new Double(inhaltAlsText());
            return d;
        }

        throw new ArithmeticException("inhaltAlsZahl: ist keine Zahl");
    }

    public void setzeSchriftArt(String pSchriftart) {
        this.zAktuellFont = pSchriftart;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatComponent.setFont(this.zSchriftArt);
        this.hatComponent.repaint();
    }

    public void setzeSchriftart(String pSchriftart) {
        setzeSchriftArt(pSchriftart);
    }

    public void setzeSchriftgroesse(int pGroesse) {
        setzeSchriftGroesse(pGroesse);
    }

    public void setzeSchriftGroesse(int pGroesse) {
        this.zSchriftGroesse = pGroesse;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatComponent.setFont(this.zSchriftArt);
        this.hatComponent.repaint();
    }

    public void setzeSchriftStil(int pStil) {
        this.zSchriftStil = pStil;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatComponent.setFont(this.zSchriftArt);
        this.hatComponent.repaint();
    }

    public void setzeSchriftstil(int pStil) {
        setzeSchriftStil(pStil);
    }

    public void setzeSchriftFarbe(Color pFarbe) {
        this.hatComponent.setForeground(pFarbe);
        this.hatComponent.repaint();
    }

    public void setzeSchriftfarbe(Color pFarbe) {
        setzeSchriftFarbe(pFarbe);
    }

    public void setzeSchriftfarbe(int pFarbe) {
        setzeSchriftFarbe(pFarbe);
    }

    public Color schriftfarbe() {
        return this.hatComponent.getForeground();
    }

    public Color schriftFarbe() {
        return schriftfarbe();
    }

    public void setzeSchriftFarbe(int pFarbe) {
        setzeSchriftFarbe(KomponentenHelper.getColorbyFarbnummer(pFarbe));
        this.hatComponent.repaint();
    }
}
