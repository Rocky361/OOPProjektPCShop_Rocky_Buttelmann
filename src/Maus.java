/**
 * Die Klasse Maus repräsentiert eine Computermaus, die von der Klasse Produkt erbt
 */
public class Maus extends Produkt{
    /**
     * Die Anzahl der Tasten der Maus
     */
    int tasten;

    /**
     * Konstruktor für die Klasse Maus
     * @param marke Die Marke der Maus
     * @param modell Das Modell der Maus
     * @param preis Der Preis der Maus
     * @param tasten Anzahl der Tastend der Maus
     */
    public Maus(String marke, String modell, double preis, int tasten) {
        super(marke, modell, preis);
        this.tasten = tasten;
    }
    /**
     * Gibt die Anzahl der Tasten der Maus zurück
     * @return Anzahl der Tastend der Maus
     */
    public int getTasten() {
        return tasten;
    }
    /**
     * Gibt eine formatierte Ausgabe der Maus zurück
     * @return eine formatierte Ausgabe der Maus
     */
    public String ausgabe(){
        return "Marke: " + getMarke() + " Modell: " + getModell() + " Preis: " + getPreis() +  " € Tasten: " + getTasten() ;
    }
    /**
     * Gibt den Typ der Maus zurück
     * @return Der Typ der Maus
     */
    public String getType(){
        return "Maus";
    }
}
