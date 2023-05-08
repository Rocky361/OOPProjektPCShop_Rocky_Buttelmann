public class Maus extends Produkt{
    int tasten;

    public Maus(String marke, String modell, double preis, int tasten) {
        super(marke, modell, preis);
        this.tasten = tasten;
    }

    public int getTasten() {
        return tasten;
    }

    public void setTasten(int tasten) {
        this.tasten = tasten;
    }
}
