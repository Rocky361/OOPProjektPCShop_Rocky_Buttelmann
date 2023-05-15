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

    public String ausgabe(){
        String jaNein;

        if(isBeleuchtet()){
            jaNein = "Ja";
        }else {
            jaNein = "Nein";
        }

        return "Marke: " + getMarke() + " Modell: " + getModell() + " Preis: " + getPreis() + "€ Beleuchtet: " + jaNein ;
    }
    public String getType(){
        return "Tastatur";
    }


}
