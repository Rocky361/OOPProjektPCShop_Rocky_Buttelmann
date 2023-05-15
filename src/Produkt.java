public class Produkt {
    private String marke, modell;
    private double preis;

    public Produkt(String marke, String modell, double preis) {
        this.marke = marke;
        this.modell = modell;
        this.preis = preis;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    public String ausgabe(){
        return "Marke: " + getMarke();
    }
    public String getType(){
        return "Produkt";
    }


}
