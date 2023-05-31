/**
 *
 * Die Mutterklasse Produkt repräsentiert ein generisches Produkt.
 */
public class Produkt {
    /**
     * Die Marke des Produkts
     */
    private final String marke;
    /**
     * Das Modell des Produkts
     */
    private final String modell;
    /**
     * Der Preis des Produkts
     */
    private final double preis;
    /**
     * Konstruktor für die Klasse Produkt.
     * @param marke Die Marke des Produkts.
     * @param modell Das Modell des Produkts.
     * @param preis Der Preis des Produkts.
     */
    public Produkt(String marke, String modell, double preis) {
        this.marke = marke;
        this.modell = modell;
        this.preis = preis;
    }
    /**
     * Gibt die Marke des Produkts zurück
     * @return Die Marke des Produkts
     */
    public String getMarke() {
        return marke;
    }
    /**
     * Gibt das Modell des Produkts zurück
     * @return Das Modell des Produkts
     */
    public String getModell() {
        return modell;
    }
    /**
     * Gibt den Preis des Produkts zurück
     * @return Der Preis des Produkts
     */
    public double getPreis() {
        return preis;
    }
    /**
     * Gibt eine formatierte Ausgabe des Produkts zurück
     * @return Eine formatierte Ausgabe des Produkts
     */
    public String ausgabe(){
        return "Marke: " + getMarke();
    }
    /**
     * Gibt den Typ des Produkts zurück
     * @return Der Typ des Produkts
     */
    public String getType(){
        return "Produkt";
    }
}
