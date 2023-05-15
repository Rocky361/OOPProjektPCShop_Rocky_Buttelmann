import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainShop {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Produkt> alleProdukte = new ArrayList<>();

    public static void main(String[] args) {
        hauptMenue();

    }
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
                    System.out.println("Falsche eingabe!");
                    hauptMenue();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte eingabe!");
            hauptMenue();
        }
    }

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
    public static void produktBearbeiten(){
        System.out.println("""
            -------------------------------------------------------------------------------------
            PC-Shop                 Produkt bearbeiten                   von:  Rocky Buttelmann
            -------------------------------------------------------------------------------------
            Bitte wählen:
            """);

        try {
            boolean checkAgain = true;
            while(checkAgain) {
                System.out.println("Anzahl der Produkte: " + alleProdukte.size());
                String marke, modell;
                double preis;
                int groesse, tasten;
                int position = 1;
                int eingabeProdukt;
                String eingabe;
                String sockel;
                boolean beleuchtet;

                if (alleProdukte.size() == 0) {
                    System.out.println("Keine Produkte vorhanden!");
                    hauptMenue();
                }


                for (Produkt produkt : alleProdukte) {
                    System.out.println(position + ". " + produkt.ausgabe());
                    position++;
                }
                System.out.println("Bitte wählen sie das Produkt aus welches sie bearbeiten möchten:");

                eingabeProdukt = scanner.nextInt();
                if(eingabeProdukt > alleProdukte.size() || eingabeProdukt < 0){
                    System.out.println("Produkt nicht gefunden!");
                    produktBearbeiten();
                }

                scanner.nextLine();
                if (alleProdukte.get(eingabeProdukt-1).getType().contains("Monitor")) {
                    String[] monitorEigenschaften = monitorErstellen();
                    marke = monitorEigenschaften[0];
                    modell = monitorEigenschaften[1];
                    String preisInput = monitorEigenschaften[2];
                    String groesseInput = monitorEigenschaften[3];
                    if (marke.isEmpty() || modell.isEmpty() || preisInput.isEmpty() || groesseInput.isEmpty()) {
                        System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                        hauptMenue();
                    }
                    try {
                        preis = Double.parseDouble(preisInput);
                        groesse = Integer.parseInt(groesseInput);
                        alleProdukte.set(eingabeProdukt - 1, new Monitor(marke, modell, preis, groesse));
                    } catch (NumberFormatException e) {
                        System.out.println("Ungültiges Zahlenformat für Preis oder Größe!");
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
                        System.out.println("Ungültiges Zahlenformat für Preis!");
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
                        System.out.println("Ungültiges Zahlenformat für Preis!");
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
                do {
                    eingabe = scanner.nextLine();
                } while (!eingabe.equals("y") && !eingabe.equals("n"));

                if (eingabe.equals("n")) {
                    checkAgain = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
        hauptMenue();
    }


    public static void produktSuchen(){
        try {
            boolean searchAgain = true;
            while(searchAgain) {
            System.out.println("""
                -------------------------------------------------------------------------------------
                PC-Shop                 Produkt suchen                       von:  Rocky Buttelmann
                -------------------------------------------------------------------------------------
                Suchbegriff eingeben:
                """);


                Scanner scanner = new Scanner(System.in);
                String eingabe = scanner.nextLine();
                int position = 1;
                boolean vorhanden = false;

                for (Produkt produkt : alleProdukte) {

                    if (produkt.ausgabe().contains(eingabe)) {

                        System.out.println(position + ". " + produkt.ausgabe());
                        vorhanden = true;
                        position++;
                    }
                }

                if (!vorhanden) {
                    System.out.println("Keine Produkte gefunden!");
                }

                System.out.println("Möchten Sie noch ein Produkt suchen? (y/n)");
                do {
                    eingabe = scanner.nextLine();
                } while (!eingabe.equals("y") && !eingabe.equals("n"));
                if (eingabe.equals("n")) {
                    searchAgain = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
        hauptMenue();
    }





    public static void produktLoeschen() {

        try {
            boolean deleteAgain = true;
            while (deleteAgain) {

                String eingabe;
                int auswahl;
                int position = 1;
                String eingabeJaNein;
                System.out.println("""
                        -------------------------------------------------------------------------------------
                        PC-Shop                 Produkt löschen                      von:  Rocky Buttelmann
                        -------------------------------------------------------------------------------------
                                   
                        """);
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
                do {
                    eingabe = scanner.nextLine();
                } while (!eingabe.equals("y") && !eingabe.equals("n"));
                if (eingabe.equals("n")) {
                    deleteAgain = false;
                }
            }
        } catch (InputMismatchException e) {
                System.out.println("Fehlerhafte Eingabe!");
                hauptMenue();
            }
            hauptMenue();
        }






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



    public static void monitor() {
        try {
            String marke, modell;
            double preis;
            int groesse;
            boolean checkAgain = true;
            String eingabe;

            // Loop until the user decides to stop adding monitors
            while (checkAgain) {
                String[] monitorEigenschaften = monitorErstellen();
                marke = monitorEigenschaften[0];
                modell = monitorEigenschaften[1];
                String preisInput = monitorEigenschaften[2];
                String groesseInput = monitorEigenschaften[3];


                // Check if any input values are missing or invalid
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


    public static void motherboard() {
        try {
            String marke, modell;
            double preis;
            String sockel;
            boolean checkAgain = true;
            String eingabe;

            // Loop until the user decides to stop adding monitors
            while (checkAgain) {

                String[] motherboardEigenschaften = motherboardErstellen();
                marke = motherboardEigenschaften[0];
                modell = motherboardEigenschaften[1];
                String preisInput = motherboardEigenschaften[2];
                sockel = motherboardEigenschaften[3];

                // Check if any input values are missing or invalid
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

    public static void maus() {
        try {
            String marke, modell;
            double preis;
            int tasten;
            boolean checkAgain = true;
            String eingabe;

            // Loop until the user decides to stop adding monitors
            while (checkAgain) {

                String[] mausEigenschaften = mausErstellen();
                marke = mausEigenschaften[0];
                modell = mausEigenschaften[1];
                String preisInput = mausEigenschaften[2];
                String tastenInput = mausEigenschaften[3];

                // Check if any input values are missing or invalid
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

    public static void tastatur() {
        try {
            String marke, modell;
            double preis;
            boolean beleuchtet = false;
            boolean checkAgain = true;
            String eingabe;

            // Loop until the user decides to stop adding monitors
            while (checkAgain) {

                String[] tastaturEigenschaften = tastaturErstellen();
                marke = tastaturEigenschaften[0];
                modell = tastaturEigenschaften[1];
                String preisInput = tastaturEigenschaften[2];
                String beleuchtetInput = tastaturEigenschaften[3];

                // Check if any input values are missing or invalid
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

    public static String[] monitorErstellen(){
        String[] values = markeModellPreisEingabe();
        System.out.println("Größe eingeben:");
        values[3] = scanner.nextLine();
        return values;
    }

    public static String[] motherboardErstellen(){
        String[] values = markeModellPreisEingabe();
        System.out.println("Sockel eingeben:");
        values[3] = scanner.nextLine();
        return values;
    }

    public static String[] mausErstellen(){
        String[] values = markeModellPreisEingabe();
        System.out.println("Tastenzahl eingeben:");
        values[3] = scanner.nextLine();
        return values;
    }

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


    public static void produkteFuellen(){
        for(int i = 0; i < 10; i++){
            alleProdukte.add(new Monitor("marke"+i, "modell"+i, 100+i, 12+i));
        }
        for(int i = 0; i < 10; i++){
            alleProdukte.add(new Motherboard("marke"+i, "modell"+i, 100+i, "am"+i));
        }

        System.out.println("Anzahl der Produkte: " + alleProdukte.size());
        hauptMenue();


    }



}