public class Tastatur extends Produkt{
    private boolean beleuchtet;

    public Tastatur(String marke, String modell, double preis, boolean beleuchtet) {
        super(marke, modell, preis);
        this.beleuchtet = beleuchtet;
    }

    public boolean isBeleuchtet() {
        return beleuchtet;
    }

    public void setBeleuchtet(boolean beleuchtet) {
        this.beleuchtet = beleuchtet;
    }
}
