public class Monitor extends Produkt{
    private int groesse;

    public Monitor(String marke, String modell, double preis, int groesse) {
        super(marke, modell, preis);
        this.groesse = groesse;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public String ausgabe(){
        return "Marke: " + getMarke() + " Modell: " + getModell() + " Preis: " + getPreis() + "€ Größe: " + getGroesse() + " Zoll";
    }



    public String getType(){
        return "Monitor";
    }
}
