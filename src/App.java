// Gabriella Josson TE22A
// Bokningssystem för ett flygplan
import java.util.Scanner;

public class App {

    public static void meny(){
        System.out.println("Välkommen till Gabbi Airlines! Skriv 1, 2, 3 eller 4"); //Meny
        System.out.println("1:Boka en plats på flyget");
        System.out.println("2:Hjälp eller frågor");
        System.out.println("3:Våra priser");
        System.out.println("4:Vill du ta med ditt husdjur");
        System.out.println("5:Visa platser");
        System.out.println("6:Beräkna vinst");
        System.out.println("7:Avsluta programmet");
    }

    public static void visaPlatser(int[]platser){
        int räknare = 0;

        for(int i = 0; i < 20; i++){
            if(räknare == 4){
                System.out.println("");
                räknare = 0;
            }
            System.out.print(platser[i]);
            räknare++;
        }
        System.out.println("");

    }

    public static int[] bokaPlats(int[] platser){
        Scanner reader = new Scanner(System.in); // Scanner
        
        visaPlatser(platser);
        System.out.print("\nVilken plats på planet vill du ha? (1-20): ");
        
        while(true){
            int valdPlats = Integer.parseInt(reader.nextLine())-1;
            if(platser[valdPlats] == 0){
                platser[valdPlats] = 1;
                break;
            }else{
                System.out.println("Plats nummer " + valdPlats + " är upptagen, vänligen välj en annan plats: ");
            }
        }
    
        System.out.println("De uppdaterade platserna: ");
        visaPlatser(platser);

        return platser;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner reader = new Scanner(System.in); // Scanner
        int[] platser = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
        boolean loop = true;

        while(loop){
            meny();
            String menysvar = reader.nextLine();
            switch(menysvar){
                case "1":
                    System.out.println("huvudprogram");
                    platser = bokaPlats(platser);
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                break;
    
                case "2":
                    System.out.println("Besök våran hemsida på gabbiairlines.com eller ring våran kundservice på +123456789");
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
                    int vinst = 0;
                    for (int plats : platser) {
                        if(plats == 1){
                            vinst+=300;
                        }
                    }
                    System.out.println("Din vinst är: " + vinst + "kr");
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                break;
    
                case "7":
                    System.out.println("Programmet avslutas");
                    loop = false;
                break;
            }
        }

        

    }      
}  