/**
 * Die Klasse Monitor repräsentiert einen Monitor, der von der Klasse Produkt erbt.
 */
public class Monitor extends Produkt{
    /**
     * Die größe des Monitors
     */
    private final int groesse;
    /**
     * Konstruktor für die Klasse Monitor
     * @param marke Die Marke des Monitors
     * @param modell Das Modell des Monitors
     * @param preis Der Preis des Monitors
     * @param groesse Die Größe des Monitors
     */
    public Monitor(String marke, String modell, double preis, int groesse) {
        super(marke, modell, preis);
        this.groesse = groesse;
    }
    /**
     * Gibt die Größe des Monitors zurück
     * @return Die Größe des Monitors
     */
    public double getGroesse() {
        return groesse;
    }
    /**
     * Gibt eine formatierte Ausgabe des Monitors zurück
     * @return Eine formatierte Ausgabe des Monitors
     */
    public String ausgabe(){
        return "Marke: " + getMarke() + " Modell: " + getModell() + " Preis: " + getPreis() + " € Größe: " + getGroesse() + " Zoll";
    }
    /**
     * Gibt den Typ des Monitors zurück
     * @return Der Typ des Monitors
     */
    public String getType(){
        return "Monitor";
    }
}
