/**
 * Die Klasse Motherboard represäntiert ein Motherboard, das von der Klasse Produkt erbt
 */
public class Motherboard extends Produkt{
    /**
     * Der Sockeltyp des Motherboards
     */
    private final String sockel;
    /**
     * Der Konstruktor für die Klasse Motherboard
     * @param marke Die Marke des Motherboards
     * @param modell Das Modell des Motherboards
     * @param preis Der Preis des Motherboards
     * @param sockel Der Preis des Motherboards.
     */
    public Motherboard(String marke, String modell, double preis, String sockel) {
        super(marke, modell, preis);
        this.sockel = sockel;
    }
    /**
     * Gibt den Sockeltyp des Motherboards zurück
     * @return Der Sockeltyp des Motherboards
     */
    public String getSockel() {
        return sockel;
    }
    /**
     * Gibt eine formatierte Ausgabe des Motherboards zurück
     * @return eine formatierte Ausgabe de Motherboards
     */
    public String ausgabe(){
        return "Marke: " + getMarke() + " Modell: " + getModell() + " Preis: " + getPreis() + " € Sockeltyp: " + getSockel() ;
    }
    /**
     * Gibt den Typ des Motherboards zurück
     * @return Der typ des Motherboards
     */
    public String getType(){
        return "Motherboard";
    }
}
