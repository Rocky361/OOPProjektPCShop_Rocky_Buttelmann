import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author rocky buttelmann
 */
public class MainShop {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Produkt> alleProdukte = new ArrayList<>();
    public static void main(String[] args) {
        hauptMenue();
    }
    /**
     *
     *  Zeigt das Hauptmenü vom PC-Shop an. User wird aufgefordert, eine Eingabe zu tätigen,
     *  je nach Auswahl wird die entsprechende Methode aufgerufen.
     *  Bei einer fehlerhaften Eingabe wird eine Fehlermeldung ausgegeben und das Hauptmenü erneut aufgerufen.
     *
     */
    public static void hauptMenue(){
        try {
            System.out.println("""
                    -------------------------------------------------------------------------------------
                    PC-Shop                 Hauptmenü                            von:  Rocky Buttelmann
                    -------------------------------------------------------------------------------------
                        1) Produkt anlegen
                        2) Produkt bearbeiten
                        3) Produkt suchen\s
                        4) Produkt löschen
                        5) mit Produkten Füllen
                        0) Shop beenden
                    -------------------------------------------------------------------------------------
                    Bitte wählen:
                    """);
            scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            switch (eingabe) {
                case "1" -> produktAnlegen();
                case "2" -> produktBearbeiten();
                case "3" -> produktSuchen();
                case "4" -> produktLoeschen();
                case "0" -> shopBeenden();
                case "5" -> produkteFuellen();
                default -> {
                    System.out.println("Fehlerhafte eingabe!");
                    hauptMenue();
                }
            }
            // Die catch Anweisung fängt einen Fehler ab, wenn z.B. ein String für eine Integer Variable verwendet wird und führt dann den Code aus, statt das Programm mit einem Fehler zu beenden.
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte eingabe!");
            hauptMenue();
        }
    }
    /**
     *
     * Das Menü für das Anlegen der Produkte wird angezeigt. Der User wird aufgefordert, eine Eingabe zu tätigen,
     * je nach Auswahl wird die entsprechende Methode aufgerufen.
     * Bei einer fehlerhaften Eingabe wird eine Fehlermeldung ausgegeben und das Hauptmenü erneut aufgerufen.
     *
     */
    public static void produktAnlegen(){
        System.out.println("""
                -------------------------------------------------------------------------------------
                PC-Shop                 Produkt anlegen                      von:  Rocky Buttelmann
                -------------------------------------------------------------------------------------
                    Produktkategorie
                    1) Monitor
                    2) Motherboard\s
                    3) Tastatur
                    4) Maus
                    0) zurück
                -------------------------------------------------------------------------------------
                Bitte wählen:
                """);
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        switch (eingabe) {
            case "1" -> monitor();
            case "2" -> motherboard();
            case "3" -> tastatur();
            case "4" -> maus();
            case "0" -> hauptMenue();
            default -> {
                System.out.println("Fehlerhafte Eingabe!");
                hauptMenue();
            }
        }
    }
    /**
     *
     * Das Menü für das bearbeiten der Produkte wird angezeigt.
     * Es werden alle Produkte durchnummeriert ausgegeben. Wenn keine Vorhanden sind, gibt es eine Ausgabe und es wird das Hauptmenü angezeigt.
     * Der User wird aufgefordert ein Produkt auszuwählen, welches bearbeitet werden soll. Je nach Produkttyp wird der User aufgefordert Produktparameter einzugeben.
     * Hat der user eine Falsche Eingabe bei der Auswahl des Produktes gemacht, kommt eine Meldung, dass das Produkt nicht gefunden wurde und er kommt wieder zum Anfang der Produkt bearbeiten Methode.
     * Hat der User bei einem Parameter nichts eingegeben kommt eine Fehlermeldung und das Hauptmenü wird aufgerufen.
     * Nach erfolgreicher Eingabe der Produktparameter wird der User gefragt ob er noch ein Produkt bearbeiten möchte.
     * Bei einer fehlerhaften Eingabe wird eine Fehlermeldung ausgegeben und das Hauptmenü erneut aufgerufen.
     *
     */
    public static void produktBearbeiten(){
        // Menü anzeigen für das Bearbeiten eines Produkts
        System.out.println("""
            -------------------------------------------------------------------------------------
            PC-Shop                 Produkt bearbeiten                   von:  Rocky Buttelmann
            -------------------------------------------------------------------------------------
            Bitte wählen:
            """);
        try {
            boolean checkAgain = true;
            // Schleife wird so lange wiederholt bis der User kein Produkt mehr bearbeiten möchte
            while(checkAgain) {
                System.out.println("Anzahl der Produkte: " + alleProdukte.size());
                String marke, modell, eingabe, sockel;
                double preis;
                int groesse, tasten, eingabeProdukt;
                int position = 1;
                boolean beleuchtet;
                // Wenn keine Produkte vorhanden sind, das Hauptmenü erneut aufrufen
                if (alleProdukte.size() == 0) {
                    System.out.println("Keine Produkte vorhanden!");
                    hauptMenue();
                }
                // Produkte auflisten
                for (Produkt produkt : alleProdukte) {
                    System.out.println(position + ". " + produkt.ausgabe());
                    position++;
                }
                System.out.println("Bitte wählen sie das Produkt aus welches sie bearbeiten möchten:");
                eingabeProdukt = scanner.nextInt();
                // Wenn die auswahl nicht vorhanden ist das Hauptmenü erneut aufrufen
                if(eingabeProdukt > alleProdukte.size() || eingabeProdukt <= 0){
                    System.out.println("Produkt nicht gefunden!");
                    produktBearbeiten();
                }
                scanner.nextLine();
                // Das ausgewählte Produkt basierend auf dem Typ bearbeiten
                if (alleProdukte.get(eingabeProdukt-1).getType().contains("Monitor")) {
                    String[] monitorEigenschaften = monitorErstellen();
                    marke = monitorEigenschaften[0];
                    modell = monitorEigenschaften[1];
                    String preisInput = monitorEigenschaften[2];
                    String groesseInput = monitorEigenschaften[3];
                    // Überprüfen, ob alle Eingabewerte vorhanden sind, wenn ein Eingabewert leer ist das Hauptmenü erneut aufrufen
                    if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || groesseInput.isEmpty()) {
                        System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                        hauptMenue();
                    }
                    try {
                        // Die String eingaben in die entsprechenden Datentypen umwandeln
                        preis = Double.parseDouble(preisInput);
                        groesse = Integer.parseInt(groesseInput);
                        alleProdukte.set(eingabeProdukt - 1, new Monitor(marke, modell, preis, groesse));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte eingabe!");
                        hauptMenue();
                    }
                }
                if (alleProdukte.get(eingabeProdukt-1).getType().contains("Motherboard")) {
                    String[] motherboardEigenschaften = motherboardErstellen();
                    marke = motherboardEigenschaften[0];
                    modell = motherboardEigenschaften[1];
                    String preisInput = motherboardEigenschaften[2];
                    sockel = motherboardEigenschaften[3];
                    if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || sockel.isEmpty()) {
                        System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                        hauptMenue();
                    }
                    try {
                        preis = Double.parseDouble(preisInput);
                        alleProdukte.set(eingabeProdukt - 1, new Motherboard(marke, modell, preis, sockel));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte eingabe!");
                        hauptMenue();
                    }
                }
                if (alleProdukte.get(eingabeProdukt-1).getType().contains("Tastatur")) {
                    String[] tastaturEigenschaften = tastaturErstellen();
                    marke = tastaturEigenschaften[0];
                    modell = tastaturEigenschaften[1];
                    String preisInput = tastaturEigenschaften[2];
                    String beleuchtetInput = tastaturEigenschaften[3];
                    if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || beleuchtetInput.isEmpty()) {
                        System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                        hauptMenue();
                    }
                    try {
                        preis = Double.parseDouble(preisInput);
                        beleuchtet = Boolean.parseBoolean(beleuchtetInput);
                        alleProdukte.set(eingabeProdukt - 1, new Tastatur(marke, modell, preis, beleuchtet));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte eingabe!");
                        hauptMenue();
                    }
                }
                if (alleProdukte.get(eingabeProdukt-1).getType().contains("Maus")) {
                    String[] mausEigenschaften = mausErstellen();
                    marke = mausEigenschaften[0];
                    modell = mausEigenschaften[1];
                    String preisInput = mausEigenschaften[2];
                    String tastenInput = mausEigenschaften[3];
                    if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || tastenInput.isEmpty()) {
                        System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                        hauptMenue();
                    }
                    try {
                        preis = Double.parseDouble(preisInput);
                        tasten = Integer.parseInt(tastenInput);
                        alleProdukte.set(eingabeProdukt - 1, new Maus(marke, modell, preis, tasten));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte Eingabe!");
                        hauptMenue();
                    }
                }
                System.out.println("Möchten Sie noch ein Produkt bearbeiten? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
        hauptMenue();
    }
    /**
     *
     * Das Menü für das Suchen eines Produkts wird angezeigt.
     * Der User wird aufgefordert ein Suchbegriff einzugeben. Ist der Suchbegriff in den Produkten vorhanden,
     * werden die Produkte durchnummeriert ausgegeben. Ist der Suchbegriff nicht vorhanden, wird angezeigt, dass kein Produkt
     * gefunden wurde.
     * Der User wird gefragt ob er noch ein Produkt suchen möchte.
     * Bei einer fehlerhaften Eingabe wird eine Fehlermeldung ausgegeben und das Hauptmenü erneut aufgerufen.
     *
     */
    public static void produktSuchen(){
        try {
            boolean checkAgain = true;
            while(checkAgain) {
                // Menü anzeigen für das Suchen eines Produkts
                System.out.println("""
                -------------------------------------------------------------------------------------
                PC-Shop                 Produkt suchen                       von:  Rocky Buttelmann
                -------------------------------------------------------------------------------------
                Suchbegriff eingeben:
                """);
                Scanner scanner = new Scanner(System.in);
                String eingabe = scanner.nextLine().toLowerCase();
                int position = 1;
                boolean vorhanden = false;
                // Produkte mit vom User eingegebenen Wert vergleichen und ausgeben
                for (Produkt produkt : alleProdukte) {
                    if (produkt.ausgabe().toLowerCase().contains(eingabe)) {
                        System.out.println(position + ". " + produkt.ausgabe());
                        vorhanden = true;
                        position++;
                    }
                }
                if (!vorhanden) {
                    System.out.println("Keine Produkte gefunden!");
                }
                System.out.println("Möchten Sie noch ein Produkt suchen? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
        hauptMenue();
    }
    /**
     * Das Menü für das Löschen eines Produkts wird angezeigt.
     * Es werden alle Produkte durchnummeriert ausgegeben. Wenn keine Vorhanden sind, gibt es eine Ausgabe und es wird das Hauptmenü angezeigt.
     * Der User wird aufgefordert ein Produkt auszuwählen, welches gelöscht werden soll.
     * Hat der user eine Falsche Eingabe bei der Auswahl des Produktes gemacht, kommt eine Meldung, dass das Produkt nicht gefunden wurde und er kommt wieder zum Anfang der Produkt löschen Methode.
     * Der User wird gefragt ob er wirklich löschen will.
     * Der User wird gefragt ob er noch ein Produkt suchen möchte.
     * Bei einer fehlerhaften Eingabe wird eine Fehlermeldung ausgegeben und das Hauptmenü erneut aufgerufen.
     */
    public static void produktLoeschen() {
        try {
            boolean checkAgain = true;
            while (checkAgain) {
                String eingabe, eingabeJaNein;
                int auswahl;
                int position = 1;
                System.out.println("""
                        -------------------------------------------------------------------------------------
                        PC-Shop                 Produkt löschen                      von:  Rocky Buttelmann
                        -------------------------------------------------------------------------------------
                                   
                        """);
                if (alleProdukte.size() == 0) {
                    System.out.println("Keine Produkte vorhanden!");
                    hauptMenue();
                }
                for (Produkt produkt : alleProdukte) {
                    System.out.println(position + ". " + produkt.ausgabe());
                    position++;
                }
                System.out.println("Welches Produkt soll gelöscht werden? Bitte wählen:");
                auswahl = scanner.nextInt();
                scanner.nextLine();
                if(auswahl >= position || auswahl < 0){
                    System.out.println("Produkt nicht gefunden!");
                    produktLoeschen();
                }
                System.out.println("Wollen Sie das Produkt wirklich löschen? (y/n)");
                eingabeJaNein = scanner.nextLine();

                if(eingabeJaNein.equals("y")){
                    alleProdukte.remove(auswahl-1);
                } else {
                    break;
                }
                System.out.println("Möchten Sie noch ein Produkt löschen? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
        } catch (InputMismatchException e) {
                System.out.println("Fehlerhafte Eingabe!");
                hauptMenue();
            }
            hauptMenue();
        }
    /**
     * Das Menü für das Beenden des Programms wird angezeigt.
     * Der User wird gefragt ob er das Programm wirklich beenden möchte.
     * Wenn der User bestätigt wird das Programm beendet.
     * Bei einer fehlerhaften Eingabe wird eine Fehlermeldung ausgegeben und das Hauptmenü erneut aufgerufen.
     *
     */
    public static void shopBeenden(){
        String eingabe;
        System.out.println("""
                        -------------------------------------------------------------------------------------
                        PC-Shop                 Programm beenden                     von:  Rocky Buttelmann
                        -------------------------------------------------------------------------------------
                        """);
        System.out.println("Wollen Sie das Programm wirklich beenden? (y/n)");
        eingabe = scanner.nextLine();
        if (!eingabe.equals("y") && !eingabe.equals("n")) {
            System.out.println("Fehlerhafte eingabe");
            hauptMenue();
        }
        if (eingabe.equals("y")) {
            System.out.println("PC Shop wurde beendet");
            System.exit(1);
        } else {
            hauptMenue();
        }
    }
    /**
     *
     * Methode um einen Monitor anzulegen.
     * Produkteigenschaften werden in ein String Array gespeichert und es wird geschaut ob die Eingaben leer sind.
     * Bei leeren Eingaben wird das Hauptmenü wieder aufgerufen.
     * gibt es keine leeren Eingaben werden die Strings in die jeweiligen Datentypen umgewandelt und das Produkt wird in die
     * Produktarrayliste hinzugefügt.
     * Falsche oder Fehlerhafte Eingaben werden mit einem Trycatch Konstrukt abgefangen.
     * Am Ende wird abgefragt ob der User noch ein Produkt erstellen möchte
     *
     */
    public static void monitor() {
        try {
            String marke, modell, eingabe;
            double preis;
            int groesse;
            boolean checkAgain = true;
            while (checkAgain) {
                String[] monitorEigenschaften = monitorErstellen();
                marke = monitorEigenschaften[0];
                modell = monitorEigenschaften[1];
                String preisInput = monitorEigenschaften[2];
                String groesseInput = monitorEigenschaften[3];
                if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || groesseInput.isEmpty()) {
                    System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                    hauptMenue();
                } else {
                    try {
                        preis = Double.parseDouble(preisInput);
                        groesse = Integer.parseInt(groesseInput);
                        alleProdukte.add(new Monitor(marke, modell, preis, groesse));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte Eingabe!");
                        hauptMenue();
                    }
                }
                System.out.println("Anzahl der Monitore: " + alleProdukte.size());
                System.out.println("Möchten Sie noch einen Monitor anlegen? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
            hauptMenue();
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
    }
    /**
     *
     * Methode um ein Motherboard anzulegen.
     * Produkteigenschaften werden in ein String Array gespeichert und es wird geschaut ob die Eingaben leer sind.
     * Bei leeren Eingaben wird das Hauptmenü wieder aufgerufen.
     * gibt es keine leeren Eingaben werden die Strings in die jeweiligen Datentypen umgewandelt und das Produkt wird in die
     * Produktarrayliste hinzugefügt.
     * Falsche oder Fehlerhafte Eingaben werden mit einem Trycatch Konstrukt abgefangen.
     * Am Ende wird abgefragt ob der User noch ein Produkt erstellen möchte
     *
     */
    public static void motherboard() {
        try {
            String marke, modell, sockel, eingabe;
            double preis;
            boolean checkAgain = true;
            while (checkAgain) {
                String[] motherboardEigenschaften = motherboardErstellen();
                marke = motherboardEigenschaften[0];
                modell = motherboardEigenschaften[1];
                String preisInput = motherboardEigenschaften[2];
                sockel = motherboardEigenschaften[3];
                if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || sockel.isEmpty()) {
                    System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                    hauptMenue();
                } else {
                    try {
                        preis = Double.parseDouble(preisInput);
                        alleProdukte.add(new Motherboard(marke, modell, preis, sockel));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte eingabe!");
                        hauptMenue();
                    }
                }
                System.out.println("Anzahl der Motherboards: " + alleProdukte.size());
                System.out.println("Möchten Sie noch ein Motherboard anlegen? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
            hauptMenue();
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
    }
    /**
     *
     * Methode um eine Maus anzulegen.
     * Produkteigenschaften werden in ein String Array gespeichert und es wird geschaut ob die Eingaben leer sind.
     * Bei leeren Eingaben wird das Hauptmenü wieder aufgerufen.
     * gibt es keine leeren Eingaben werden die Strings in die jeweiligen Datentypen umgewandelt und das Produkt wird in die
     * Produktarrayliste hinzugefügt.
     * Falsche oder Fehlerhafte Eingaben werden mit einem Trycatch Konstrukt abgefangen.
     * Am Ende wird abgefragt ob der User noch ein Produkt erstellen möchte
     *
     */
    public static void maus() {
        try {
            String marke, modell, eingabe;
            double preis;
            int tasten;
            boolean checkAgain = true;
            while (checkAgain) {
                String[] mausEigenschaften = mausErstellen();
                marke = mausEigenschaften[0];
                modell = mausEigenschaften[1];
                String preisInput = mausEigenschaften[2];
                String tastenInput = mausEigenschaften[3];
                if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || tastenInput.isEmpty()) {
                    System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                    hauptMenue();
                } else {
                    try {
                        preis = Double.parseDouble(preisInput);
                        tasten = Integer.parseInt(tastenInput);
                        alleProdukte.add(new Maus(marke, modell, preis, tasten));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte eingabe!");
                        hauptMenue();
                    }
                }
                System.out.println("Anzahl der Mäuse: " + alleProdukte.size());
                System.out.println("Möchten Sie noch eine Maus anlegen? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
            hauptMenue();
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
    }
    /**
     *
     * Prüft ob "y" oder "n" vom Benutzer eingebgeben wurde und gibt true oder false zurück, bei fehlerhafter Eingabe wird das Hauptmenü aufgerufen
     * @param eingabe
     * der Methode wird eine Eingabe vom Benutzer übergeben
     * @return
     * gibt true oder false zurück
     */
    public static boolean checkAgain(String eingabe){
        if (eingabe.equals("y")){
            return true;
        } else if (eingabe.equals("n")) {
            return false;
        } else{
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
        return true;
    }
    /**
     *
     * Methode um eine Tastatur anzulegen.
     * Produkteigenschaften werden in ein String Array gespeichert und es wird geschaut ob die Eingaben leer sind.
     * Bei leeren Eingaben wird das Hauptmenü wieder aufgerufen.
     * gibt es keine leeren Eingaben werden die Strings in die jeweiligen Datentypen umgewandelt und das Produkt wird in die
     * Produktarrayliste hinzugefügt.
     * Falsche oder Fehlerhafte Eingaben werden mit einem Trycatch Konstrukt abgefangen.
     * Am Ende wird abgefragt ob der User noch ein Produkt erstellen möchte
     *
     */
    public static void tastatur() {
        try {
            String marke, modell, eingabe;
            double preis;
            boolean beleuchtet = false;
            boolean checkAgain = true;
            while (checkAgain) {
                String[] tastaturEigenschaften = tastaturErstellen();
                marke = tastaturEigenschaften[0];
                modell = tastaturEigenschaften[1];
                String preisInput = tastaturEigenschaften[2];
                String beleuchtetInput = tastaturEigenschaften[3];
                if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || beleuchtetInput.isEmpty()) {
                    System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                    hauptMenue();
                } else {
                    try {
                        preis = Double.parseDouble(preisInput);
                        if (beleuchtetInput.equals("y")) {
                            beleuchtet = true;
                        } else if (beleuchtetInput.equals("n")) {
                            beleuchtet = false;
                        } else {
                            System.out.println("Fehlerhafte eingabe!");
                            hauptMenue();
                        }
                        alleProdukte.add(new Tastatur(marke, modell, preis, beleuchtet));
                    } catch (NumberFormatException e) {
                        System.out.println("Fehlerhafte eingabe!");
                        hauptMenue();
                    }
                }
                System.out.println("Anzahl der Tastaturen: " + alleProdukte.size());
                System.out.println("Möchten Sie noch eine Tastatur anlegen? (y/n)");
                eingabe = scanner.nextLine();
                checkAgain = checkAgain(eingabe);
            }
            hauptMenue();
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
    }
    /**
     *
     * Gibt ein String Array zurück mit Marke, Modell und Preis
     * @return
     * gibt das String array "values" zurück
     */
    private static String[] markeModellPreisEingabe() {
        String[] values = new String[4];
        scanner = new Scanner(System.in);
        System.out.println("Marke eingeben:");
        values[0] = scanner.nextLine();
        System.out.println("Modell eingeben:");
        values[1] = scanner.nextLine();
        System.out.println("Preis eingeben:");
        values[2] = scanner.nextLine();
        return values;
    }
    /**
     *
     * Gibt ein String Array zurück welches die Größe des Monitors angibt
     * @return
     * gibt das String array "values" zurück
     */
    public static String[] monitorErstellen(){
        String[] values = markeModellPreisEingabe();
        System.out.println("Größe eingeben:");
        values[3] = scanner.nextLine();
        return values;
    }
    /**
     *
     * Gibt ein String Array zurück welches den Sockeltyp des Motherboards angibt
     * @return
     * gibt das String array "values" zurück
     */
    public static String[] motherboardErstellen(){
        String[] values = markeModellPreisEingabe();
        System.out.println("Sockel eingeben:");
        values[3] = scanner.nextLine();
        return values;
    }
    /**
     *
     * Gibt ein String Array zurück welches die Tastenzahl der Maus angibt
     * @return
     * gibt das String array "values" zurück
     */
    public static String[] mausErstellen(){
        String[] values = markeModellPreisEingabe();
        System.out.println("Tastenzahl eingeben:");
        values[3] = scanner.nextLine();
        return values;
    }
    /**
     *
     * Gibt ein String Array zurück welches angibt ob die Tastatur beleuchtet ist
     * @return
     * gibt das String array values zurück
     */
    public static String[] tastaturErstellen() {
        String[] values = markeModellPreisEingabe();
        System.out.println("Beleuchtet? (y/n)");
        String beleuchtet = scanner.nextLine();
        if (beleuchtet.equals("y")) {
            values[3] = "Ja";
        } else if (beleuchtet.equals("n")) {
            values[3] = "Nein";
        } else {
            System.out.println("Fehlerhafte eingabe!");
            hauptMenue();
        }
        return values;
    }
    /**
     *
     * Methode um Dummydaten zu erstellen
     */
    public static void produkteFuellen(){
        alleProdukte.add(new Monitor("MSI Optix", "MAG321QRDE", 449, 32));
        alleProdukte.add(new Monitor("LC-Power", "LC-M27-FHD-165-V2", 189, 27));
        alleProdukte.add(new Monitor("Samsung", "C24F396FHR", 123.87, 24));
        alleProdukte.add(new Monitor("LG Electronics", "27UP650-W", 260.60, 27));
        alleProdukte.add(new Motherboard("MSI", "B650 TOMAHAWK WiFi", 230.90, "AM5"));
        alleProdukte.add(new Motherboard("Gigabyte", "Z790 Gaming X AX", 249.34, "1700"));
        alleProdukte.add(new Motherboard("ASRock", "B550M-ITX/ac", 125.41, "AM4"));
        alleProdukte.add(new Motherboard("Biostar", "B760M-Silver", 176.88, "1700"));
        alleProdukte.add(new Tastatur("CHERRY", "KC 1068", 52.45, false));
        alleProdukte.add(new Tastatur("NZXT", "Function MiniTKL Gateron", 89.56, true));
        alleProdukte.add(new Tastatur("Sharkoon", "Skiller Mech SGK30", 47.89, true));
        alleProdukte.add(new Tastatur("Logitech", "MX Mechanical Wireless Illuminated Performance", 138.98, true));
        alleProdukte.add(new Maus("Logitech", "G502 Hero", 48.09, 11));
        alleProdukte.add(new Maus("SteelSeries", "Rival 3 RGB", 29.92, 6));
        alleProdukte.add(new Maus("Roccat Kone", "Aimo Remastered", 56.99, 8));
        alleProdukte.add(new Maus("CHERRY", "MC2000", 7.98, 3));
        System.out.println("Anzahl der Produkte: " + alleProdukte.size());
        hauptMenue();
    }
}