public class Motherboard extends Produkt{
    private String sockel;

    public Motherboard(String marke, String modell, double preis, String sockel) {
        super(marke, modell, preis);
        this.sockel = sockel;
    }

    public String getSockel() {
        return sockel;
    }

    public void setSockel(String sockel) {
        this.sockel = sockel;
    }
}
