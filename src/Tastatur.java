/**
 * Die Klasse Tastatur repräsentiert eine Tastatur, die von der Klasse Produkt erbt
 */
public class Tastatur extends Produkt{
    /**
     * Gibt an ob die Tastatur beleuchtet ist
     */
    private final boolean beleuchtet;
    /**
     * Der Konstruktor der Klasse Tastatur
     * @param marke Die Marke der Tastatur
     * @param modell Das Modell der Tastatur
     * @param preis Der Preis der Tastatur
     * @param beleuchtet Gibt an ob die Tastatur beleuchtet ist
     */
    public Tastatur(String marke, String modell, double preis, boolean beleuchtet) {
        super(marke, modell, preis);
        this.beleuchtet = beleuchtet;
    }
    /**
     * Prüft ob die Tastatur beleuchtet ist
     * @return true, wenn die Tastatur beleuchtet ist, sonst false
     */
    public boolean isBeleuchtet() {
        return beleuchtet;
    }
    /**
     * Gibt eine formatierte Ausgabe der Tastatur zurück
     * @return eine formatierte Ausgabe der Tastatur
     */
    public String ausgabe(){
        String jaNein;

        if(isBeleuchtet()){
            jaNein = "Ja";
        }else {
            jaNein = "Nein";
        }
        return "Marke: " + getMarke() + " Modell: " + getModell() + " Preis: " + getPreis() + " € Beleuchtet: " + jaNein ;
    }
    /**
     * Gibt den Typ der Tastatur zurück
     * @return Der Typ der Tastatur
     */
    public String getType(){
        return "Tastatur";
    }
}
