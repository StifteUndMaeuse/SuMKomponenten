package sum.komponenten;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import sum.ereignis.Bildschirm;
import sum.ereignis.Fenster;
import sum.ereignis.Schrift;

public class Tabelle extends Komponente
        implements Serializable, ScrollPaneConstants, TableModelListener, FocusListener, ListSelectionListener {

    private String zInhaltGeaendertBearbeiter = "";
    private String zMarkierungGeaendertBearbeiter = "";
    private JTable hatTable;
    private JScrollPane hatScrollPane;
    private TableModel hatModel;
    protected String zAktuellFont = "Helvetica";
    protected int zSchriftStil = 0;
    protected int zSchriftGroesse = 12;
    protected Font zSchriftArt = Schrift.STANDARDSCHRIFT;
    
    public Tabelle(double pLinks, double pOben, double pBreite, double pHoehe, int pZeilen, int pSpalten) {
        this.erzeuge(Bildschirm.topFenster, pLinks, pOben, pBreite, pHoehe, pZeilen, pSpalten);
    }
    
    public Tabelle(Fenster pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pZeilen, int pSpalten) {
        this.erzeuge(pFenster, pLinks, pOben, pBreite, pHoehe, pZeilen, pSpalten);
    }
    
    public void setzeBearbeiterInhaltGeaendert(String pBearbeiter) {
        this.zInhaltGeaendertBearbeiter = pBearbeiter;
    }
    
    public void setzeBearbeiterMarkierungGeaendert(String pBearbeiter) {
        this.zMarkierungGeaendertBearbeiter = pBearbeiter;
    }
    private void erzeuge(Bildschirm pFenster, double pLinks, double pOben, double pBreite, double pHoehe, int pZeilen, int pSpalten){
        this.hatTable = new JTable(pZeilen, pSpalten);
        this.hatModel = this.hatTable.getModel();
        this.hatModel.addTableModelListener(this);
        this.hatTable.addFocusListener(this);
        this.hatTable.getSelectionModel().addListSelectionListener(this);
        this.hatScrollPane = new JScrollPane(22, 32);
        this.hatScrollPane.setSize(new Dimension(80, 80));
        pFenster.privatPanel().add(this.hatScrollPane, 0);
        this.hatScrollPane.setViewportView(this.hatTable);
        this.hatTable.setCellSelectionEnabled(true);
        this.hatTable.setSelectionMode(1);
        lerneKomponenteKennen(pFenster, this.hatTable);
        init(pLinks, pOben, pBreite, pHoehe);
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
    
    public void setzeZeilenhoehe(int pHoehe) {
        this.hatTable.setRowHeight(pHoehe);
    }
    
    public void setzeSpaltenbreite(int pBreite) {
        this.hatTable.setAutoResizeMode(0);
        for (int i = 0; i < this.hatTable.getColumnCount(); i++) {
            this.hatTable.getColumnModel().getColumn(i).setPreferredWidth(pBreite);
        }
    }
    
    public int zeilenanzahl() {
        return this.hatTable.getRowCount();
    }
    
    public int spaltenanzahl() {
        return this.hatTable.getColumnCount();
    }
    
    public void setzeSpaltenanzahl(int pAnzahl) {
        ((DefaultTableModel) this.hatModel).setColumnCount(pAnzahl);
    }
    
    public void setzeZeilenanzahl(int pAnzahl) {
        ((DefaultTableModel) this.hatModel).setRowCount(pAnzahl);
    }
    
    public void haengeNeueSpalteAn() {
        this.hatTable.addColumn(new TableColumn());
    }
    
    public void haengeNeueZeileAn() {
        ((DefaultTableModel) this.hatModel).addRow(new Vector());
    }
    
    public void fuegeNeueSpalteEinAn(int pSpalte) {
        haengeNeueSpalteAn();
        this.hatTable.moveColumn(this.hatTable.getColumnCount() - 1, pSpalte);
    }
    
    public void fuegeNeueZeileEinAn(int pZeile) {
        ((DefaultTableModel) this.hatModel).insertRow(pZeile, new Vector());
    }
    
    public void entferneSpalteAn(int pSpalte) {
        this.hatTable.removeColumn(this.hatTable.getColumnModel().getColumn(pSpalte));
    }
    
    public void entferneZeileAn(int pZeile) {
        ((DefaultTableModel) this.hatModel).removeRow(pZeile);
    }
    
    public void setzeSpaltentitelAn(String pText, int pSpalte) {
        this.hatTable.getColumnModel().getColumn(pSpalte - 1).setHeaderValue(pText);
    }
    
    public String spaltentitel(int pSpalte) {
        return this.hatTable.getColumnName(pSpalte - 1);
    }
    
    public void setzeInhaltAn(String pText, int pZeile, int pSpalte) {
        this.hatTable.setValueAt(pText, pZeile - 1, pSpalte - 1);
    }
    
    public void setzeInhaltAn(char pZeichen, int pZeile, int pSpalte) {
        setzeInhaltAn("" + pZeichen, pZeile, pSpalte);
    }
    
    public void setzeInhaltAn(double pZahl, int pZeile, int pSpalte) {
        setzeInhaltAn("" + pZahl, pZeile, pSpalte);
    }
    
    public void setzeInhaltAn(int pZahl, int pZeile, int pSpalte) {
        setzeInhaltAn("" + pZahl, pZeile, pSpalte);
    }
    
    public void haengeAnAn(String pText, int pZeile, int pSpalte) {
        this.hatTable.setValueAt((String) this.hatTable.getValueAt(pSpalte - 1, pZeile - 1) + pText, pZeile - 1, pSpalte - 1);
    }
    
    public boolean inhaltIstTextAn(int pZeile, int pSpalte) {
        return (!inhaltIstGanzeZahlAn(pZeile, pSpalte)) && (!inhaltIstZahlAn(pZeile, pSpalte));
    }
    
    public boolean inhaltIstGanzeZahlAn(int pZeile, int pSpalte) {
        try {
            Integer.valueOf(inhaltAlsTextAn(pZeile, pSpalte));
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    
    public boolean inhaltIstZahlAn(int pZeile, int pSpalte) {
        try {
            Double.valueOf(inhaltAlsTextAn(pZeile, pSpalte));
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    
    public String inhaltAlsTextAn(int pZeile, int pSpalte) {
        return (String) this.hatTable.getValueAt(pZeile - 1, pSpalte - 1);
    }
    
    public int inhaltAlsGanzeZahlAn(int pZeile, int pSpalte)
            throws ArithmeticException {
        if (inhaltIstGanzeZahlAn(pZeile, pSpalte)) {
            return Integer.parseInt(inhaltAlsTextAn(pZeile, pSpalte));
        }
        throw new ArithmeticException("inhaltAlsGanzeZahlAn: ist keine ganze Zahl");
    }
    
    public double inhaltAlsZahlAn(int pZeile, int pSpalte)
            throws ArithmeticException {
        if (inhaltIstZahlAn(pZeile, pSpalte)) {
            Double d = new Double(inhaltAlsTextAn(pZeile, pSpalte));
            return d;
        }
        
        throw new ArithmeticException("inhaltAlsZahlAn: ist keine Zahl");
    }
    
    public void setzeMarkierteZeilen(int pAnfang, int pEnde) {
        this.hatTable.addRowSelectionInterval(pAnfang - 1, pEnde - 1);
    }
    
    public void setzeMarkierteSpalten(int pAnfang, int pEnde) {
        this.hatTable.addColumnSelectionInterval(pAnfang - 1, pEnde - 1);
    }
    
    public void setzeMarkierteZelle(int pZeile, int pSpalte) {
        setzeMarkierteSpalten(pSpalte, pSpalte);
        setzeMarkierteZeilen(pZeile, pZeile);
    }
    
    public boolean istZelleMarkiert(int pZeile, int pSpalte) {
        return this.hatTable.isCellSelected(pZeile - 1, pSpalte - 1);
    }
    
    public boolean istZeileMarkiert(int pZeile) {
        return this.hatTable.isRowSelected(pZeile - 1);
    }
    
    public boolean istSpalteMarkiert(int pSpalte) {
        return this.hatTable.isColumnSelected(pSpalte - 1);
    }
    
    public void markiereAlles() {
        this.hatTable.selectAll();
    }
    
    public void markiereNichts() {
        this.hatTable.clearSelection();
    }
    
    public void setzeSchriftArt(String pSchriftart) {
        this.zAktuellFont = pSchriftart;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatTable.setFont(this.zSchriftArt);
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
        this.hatTable.setFont(this.zSchriftArt);
        this.hatTable.setRowHeight(this.hatTable.getFontMetrics(this.hatTable.getFont()).getHeight());
    }
    
    public void setzeSchriftStil(int pStil) {
        this.zSchriftStil = pStil;
        this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
        this.hatTable.setFont(this.zSchriftArt);
    }
    
    public void setzeSchriftstil(int pStil) {
        setzeSchriftStil(pStil);
    }
    
    public void setzeSchriftFarbe(Color pFarbe) {
        this.hatTable.setForeground(pFarbe);
    }
    
    public void setzeSchriftfarbe(Color pFarbe) {
        setzeSchriftFarbe(pFarbe);
    }
    
    public void setzeSchriftfarbe(int pFarbe) {
        setzeSchriftFarbe(pFarbe);
    }
    
    public void setzeSchriftFarbe(int pFarbe) {
       this.setzeSchriftFarbe(KomponentenHelper.getColorbyFarbnummer(pFarbe));
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        this.bearbeiteEreigniss(this.fokusErhaltenBearbeiter());
    }
    
    @Override
    public void focusLost(FocusEvent e) {
        this.bearbeiteEreigniss(this.fokusVerlorenBearbeiter());
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        this.bearbeiteEreigniss(this.zInhaltGeaendertBearbeiter);
        this.bearbeiteEreigniss(this.zMarkierungGeaendertBearbeiter);
    }
    
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Tabelle
 * JD-Core Version:    0.6.0
 */
