package sum.komponenten;

import java.awt.Dimension;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;

public abstract class Textbereich extends Markierungskomponente
        implements Serializable, ScrollPaneConstants {

    protected JScrollPane hatScrollPane;
    
    public Textbereich(double pLinks, double pOben, double pBreite, double pHoehe) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe);
    }
    
    public Textbereich(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe);
    }
    
    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe) {
        this.hatScrollPane = new JScrollPane(22, 31);
        this.hatScrollPane.setSize(new Dimension(10, 10));
        pFenster.privatPanel().add(this.hatScrollPane, 0);
    }
    
    @Override
    protected void lerneKomponenteKennen(Bildschirm pFenster, JComponent pKomponente) {
        this.hatScrollPane.setViewportView(pKomponente);
        super.lerneKomponenteKennen(pFenster, pKomponente);
    }
    
    @Override
    public void setzeGroesse(double pBreite, double pHoehe) {
        super.setzeGroesse(pBreite, pHoehe);
        this.hatScrollPane.setSize((int) pBreite, (int) pHoehe);
        this.hatScrollPane.revalidate();
    }
    
    @Override
    public void setzePosition(double pWohinH, double pWohinV) {
        this.hatScrollPane.setLocation((int) pWohinH, (int) pWohinV);
    }
    
    @Override
    public abstract void fuegeEin(String paramString, int paramInt);
    
    @Override
    public abstract void haengeAn(String paramString);
    
    @Override
    public abstract void haengeAn(char paramChar);
    
    @Override
    public abstract void haengeAn(int paramInt);
    
    @Override
    public abstract void haengeAn(double paramDouble);
}
