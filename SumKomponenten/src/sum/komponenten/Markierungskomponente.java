package sum.komponenten;

public abstract class Markierungskomponente extends Textkomponente
{
   protected String zInhaltGeaendertBearbeiter = "";
   protected String zMarkierungGeaendertBearbeiter = "";

  public void setzeBearbeiterInhaltGeaendert(String pBearbeiter)
  {
     this.zInhaltGeaendertBearbeiter = pBearbeiter;
  }

  public void setzeBearbeiterMarkierungGeaendert(String pBearbeiter)
  {
     this.zMarkierungGeaendertBearbeiter = pBearbeiter;
  }

  protected abstract void markierungGeaendert();

  public abstract String teilinhalt(int paramInt1, int paramInt2);

  public String teilInhalt(int pAnfang, int pEnde)
  {
     return teilinhalt(pAnfang, pEnde);
  }

  public abstract void fuegeEin(String paramString, int paramInt);

  public abstract void haengeAn(String paramString);

  public abstract void haengeAn(char paramChar);

  public abstract void haengeAn(int paramInt);

  public abstract void haengeAn(double paramDouble);

  public abstract String markierterInhalt();

  public abstract void setzeMarkierung(int paramInt1, int paramInt2);

  public abstract void markiereAlles();

  public abstract void markiereNichts();

  public void loescheAlles()
  {
     setzeInhalt("");
  }

  public abstract void loescheMarkierung();

  public abstract void loesche(int paramInt1, int paramInt2);

  public abstract boolean istMarkiert();

  public abstract int markierungsAnfang();

  public abstract int markierungsEnde();
}

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMKomponenten.jar
 * Qualified Name:     sum.komponenten.Markierungskomponente
 * JD-Core Version:    0.6.0
 */