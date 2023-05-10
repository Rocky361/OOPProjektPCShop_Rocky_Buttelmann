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
                        3) Produkt suchen 
                        4) Produkt löschen
                        5) mit Produkten Füllen
                        0) Shop beenden
                    -------------------------------------------------------------------------------------
                    Bitte wählen:
                    """);
            scanner = new Scanner(System.in);
            String eingabe = scanner.nextLine();
            if (eingabe.equals("1")) {
                produktAnlegen();
            } else if (eingabe.equals("2")) {
                produktBearbeiten();
            } else if (eingabe.equals("3")) {
                produktSuchen();
            } else if (eingabe.equals("4")) {
                produktLoeschen();
            } else if (eingabe.equals("0")) {
                shopBeenden();
            } else if (eingabe.equals("5")) {
                produkteFuellen();
            }else {
                System.out.println("Falsche eingabe!");
                hauptMenue();
            }
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte eingabe!");
            hauptMenue();
        }
    }

    public static void produktAnlegen(){
        /*
        Die Logik für das Anlegen eines neuen Produkts soll in der Methode produktAnlegen() abgearbeitet werden.
        Beim Anlegen eines neuen Produkts sollen folgende Produktkategorien angeboten werden: Monitor, Motherboard, Tastatur und Maus.
        Zu jedem Produkt MUSS Marke, Modell, Preis angegeben werden und jeweils mindestens 1 Eigenschaft, die nur für den Typ zutrifft.
        Verhindern Sie doppelte Eigenschaften in den Klassen durch Vererbung. Sollte eine Eigenschaft fehlen/leer sein,
        darf das Produkt nicht abgespeichert werden und die Info „Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden“
        soll angezeigt werden. Anschließend soll das Hauptmenü wieder aufgerufen werden. Nach dem wir alle benötigten Daten eingeben haben,
        soll eine Abfrage kommen, ob wir noch ein Produkt hinzufügen möchten oder nicht. Wenn ja, nochmal neue Daten eingeben, wenn nein,
        soll das Hauptmenü angezeigt werden. Bei falscher Eingabe soll eine Info „Fehlerhafte Eingabe“ erfolgen und das Hauptmenü wieder
        angezeigt werden.
        */
        System.out.println("""
                -------------------------------------------------------------------------------------
                PC-Shop                 Produkt anlegen                      von:  Rocky Buttelmann
                -------------------------------------------------------------------------------------
                    Produktkategorie
                    1) Monitor
                    2) Motherboard 
                    3) Tastatur
                    4) Maus
                    0) zurück
                -------------------------------------------------------------------------------------
                Bitte wählen:
                """);
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();
        if(eingabe.equals("1")){
            monitor();
        } else if (eingabe.equals("2")) {

        } else if (eingabe.equals("3")) {

        } else if (eingabe.equals("4")) {

        } else if (eingabe.equals("0")) {
            hauptMenue();
        } else {

        }

    }
    public static void produktBearbeiten(){
        System.out.println("""
            -------------------------------------------------------------------------------------
            PC-Shop                 Produkt bearbeiten                   von:  Rocky Buttelmann
            -------------------------------------------------------------------------------------
            Bitte wählen:
            """);
        /*
        Das Bearbeiten soll mit der Methode produktBearbeiten() durchgeführt werden.
        Im Menüpunkt „Produkt bearbeiten“ sollen alle gespeicherten Produkte durchnummeriert angezeigt werden.
        Ist kein Produkt vorhanden, soll die Info „Keine Produkte vorhanden“ angezeigt werden und das Hauptmenü wieder aufgerufen werden.
        Nach der Auswahl des zu bearbeitenden Produkts sollen die Eigenschaften neu eingegeben werden und das ausgewählte Produkt aktualisiert werden.
        Sollte eine Eigenschaft fehlen/leer sein, darf das Produkt nicht abgespeichert werden und die Info „Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden“
        soll angezeigt werden. Anschließend soll das Hauptmenü wieder aufgerufen werden. Wurde das Produkt korrekt aktualisiert und gespeichert, soll abgefragt werden,
        ob man nochmal ein Produkt bearbeiten möchte oder nicht. Wenn ja, Bearbeiten erneut aufrufen und bei nein geht es zurück zum Hauptmenü.
         */
        try {
            boolean checkAgain = true;
            while(checkAgain) {
                System.out.println("Anzahl der Produkte: " + alleProdukte.size());
                String marke, modell;
                double preis;
                int groesse;
                int position = 1;
                int eingabeProdukt;

                String eingabe;


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
                if(eingabeProdukt > position || eingabeProdukt < 0){
                    System.out.println("Produkt nicht gefunden!");
                    produktBearbeiten();
                }

                scanner.nextLine();

                System.out.println("Marke eingeben:");
                marke = scanner.nextLine();
                System.out.println("Modell eingeben:");
                modell = scanner.nextLine();
                System.out.println("Preis eingeben:");
                preis = scanner.nextDouble();
                System.out.println("Größe eingeben:");
                groesse = scanner.nextInt();
                scanner.nextLine(); // consume the newline character after the int input


                if (marke.isEmpty() || modell.isEmpty() || preis <= 0 || groesse <= 0) {
                    System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                    hauptMenue();
                } else {
                    alleProdukte.set((eingabeProdukt) - 1, new Monitor(marke, modell, preis, groesse));
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
        /*
        Das Löschen soll mit der Methode produktLoeschen() durchgeführt werden.
        Im Menüpunkt „Produkt löschen“ sollen alle gespeicherten Produkt durchnummeriert angezeigt werden.
        Bei falscher Eingabe soll eine Info „Fehlerhafte Eingabe“ angezeigt werden und das Hauptmenü wieder angezeigt werden.
        Nach richtiger Auswahl soll eine Abfrage angezeigt werden, ob wirklich gelöscht werden soll. Wenn ja,
        lösche das Produkt, wenn nein, soll das Hauptmenü wieder angezeigt werden.
        */
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

    }



    public static void monitor() {
        try {
            String marke, modell;
            double preis;
            int groesse;
            boolean checkNewMonitor = true;
            String eingabe;

            // Loop until the user decides to stop adding monitors
            while (checkNewMonitor) {
                System.out.println("Marke eingeben:");
                marke = scanner.nextLine();
                System.out.println("Modell eingeben:");
                modell = scanner.nextLine();
                System.out.println("Preis eingeben:");
                preis = scanner.nextDouble();
                System.out.println("Größe eingeben:");
                groesse = scanner.nextInt();
                scanner.nextLine(); // consume the newline character after the int input

                // Check if any input values are missing or invalid
                if (marke.isEmpty() || modell.isEmpty() || preis <= 0 || groesse <= 0) {
                    System.out.println("Produkt konnte aufgrund leerer Eingabewerte nicht gespeichert werden!");
                } else {
                    alleProdukte.add(new Monitor(marke, modell, preis, groesse));
                }

                System.out.println("Anzahl der Monitore: " + alleProdukte.size());
                System.out.println("Möchten Sie noch einen Monitor anlegen? (y/n)");
                do {
                    eingabe = scanner.nextLine();
                } while (!eingabe.equals("y") && !eingabe.equals("n"));

                if (eingabe.equals("n")) {
                    checkNewMonitor = false;
                }

                // Print out all added products so far
                for (Produkt produkt : alleProdukte) {
                    System.out.println(produkt.ausgabe());
                }
            }
            hauptMenue();
        } catch (InputMismatchException e) {
            System.out.println("Fehlerhafte Eingabe!");
            hauptMenue();
        }
    }

    public static void produkteFuellen(){
        for(int i = 0; i < 10; i++){
            alleProdukte.add(new Monitor("marke"+i, "modell"+i, 100+i, 12+i));
        }
        System.out.println("Anzahl der Produkte: " + alleProdukte.size());
        hauptMenue();


    }



}