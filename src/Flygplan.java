
// Flygplam.java Programmet Bokar plater för ett flygbolag med hjälp av en array 
// och räknar ut den slutliga vinsten.
// @author Gabriella Jonsson 
// @version 1.0
// @since 2024
import java.util.Scanner;

public class Flygplan {

    public static void meny() {
        System.out.println("Välkommen till Gabbi Airlines! Skriv 1, 2, 3, 4, 5, 6 eller 7"); // Meny
        System.out.println("1:Boka en plats på flyget");
        System.out.println("2:Hjälp eller frågor");
        System.out.println("3:Våra priser");
        System.out.println("4:Vill du ta med ditt husdjur");
        System.out.println("5:Visa platser");
        System.out.println("6:Beräkna vinst");
        System.out.println("7:Avsluta programmet");
    }

    public static void visaPlatser(int[] platser) {
        int räknare = 0;

        for (int i = 0; i < 20; i++) {
            if (räknare == 4) { // Gör så att varje kolumn består av 4 rader
                System.out.println("");
                räknare = 0;
            }
            System.out.print(platser[i]);
            räknare++;
        }
        System.out.println("");

    }

    public static int BeräknaVinst(int[] platser){
        int vinst = 0;
        for(int plats : platser){ // för varje sak i array
            if(plats == 1){
                vinst += 300;
            }else if(plats == 2){
                vinst += 150;
            }
        }
        return vinst;// för att kunna skriv ut senare, andra delar ska förstå
    }

    // metod för att boka platser
    public static int[] bokaPlats(int[] platser) {

        // scanner för denna metod eftersom den vi deklarerade i början inte fungerar i
        // metoden eftersom den är utanför
        Scanner reader = new Scanner(System.in); // Scanner
        visaPlatser(platser);

        // tar input från använmdaren
        System.out.print("\nVilken plats på planet vill du ha? (1-20): ");
        while (true) {
            // loop där man kollar om platsen är ledig, om den är ledig får användaren
            // platsen
            // annars måste användaren försöka igen

            int valdPlats = reader.nextInt() - 1; // den plats som användaren väljer
            if (platser[valdPlats] == 0) {

                System.out.print("Hur gammal är du?: ");

                int ålder = reader.nextInt();

                if (ålder >= 18) {
                    platser[valdPlats] = 1;

                } else {
                    platser[valdPlats] = 2;
                }
                break;
            }

            else {
                System.out.println("Plats nummer " + valdPlats + " är upptagen, vänligen välj en annan plats: ");
            }
            reader.close();
        }

        // skriver ut hur platserna ser ut i planet
        System.out.println("De uppdaterade platserna: ");
        visaPlatser(platser);

        return platser;

    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner reader = new Scanner(System.in); // Scanner

        int[] platser = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }; // array
        boolean loop = true;

        while (loop) {
            meny();
            String menysvar = reader.nextLine();
            switch (menysvar) {
                case "1":
                    platser = bokaPlats(platser);
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                    break;

                case "2":
                    System.out.println(
                            "Besök våran hemsida på gabbiairlines.com eller ring våran kundservice på +123456789");
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                    break;

                case "3":
                    System.out.println("Pris för vuxen (OBS! Året du fyller 18 betalar du vuxenpriset) = 300 kr");
                    System.out.println("Pris för barn under 18 = 150 kr");
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                    break;

                case "4":
                    System.out.println("Vi på Gabbi Airlines tillåter inte husdjuar att följa med under flygturen");
                    System.out.println("Vänligen kontakta oss via hjälp eller frågorom du har andra frågor");
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                    break;

                case "5":
                    visaPlatser(platser);
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                    break;

                case "6":
                    int vinst = BeräknaVinst(platser);
                    System.out.println("Din vinst är: " + vinst + "kr");
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                    break;

                case "7":
                    System.out.println("Programmet avslutas");
                    loop = false;
                    break;

                // menysvar.close();
            }
        }

        reader.close();
    }
}