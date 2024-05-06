// Gabriella Josson TE22A
// Bokningssystem för ett flygplan
import java.util.Scanner;

public class test2 {

    public static void meny(){
        System.out.println("Välkommen till Gabbi Airlines! Skriv 1, 2, 3, 4, 5, 6 eller 7"); //Meny
        System.out.println("1:Boka en plats på flyget");
        System.out.println("2:Hjälp eller frågor");
        System.out.println("3:Våra priser");
        System.out.println("4:Vill du ta med ditt husdjur");
        System.out.println("5:Visa platser");
        System.out.println("6:Beräkna vinst");
        System.out.println("7:Avsluta programmet");
    }

    public static void Räknautvinst(int[]platser, int ålder){
        int vinst = 0;

        for (int plats : platser) {
            if(plats == 1){

                if(ålder >= 18){
                    vinst = 300;
                }
                else{
                    vinst = 150;
                }
            }
        }
        System.out.println("Din vinst är: " + vinst + "kr");
    }
    
    public static void visaPlatser(int[]platser){
        int räknare = 0; 

        for(int i = 0; i < 20; i++){
            if(räknare == 4){  // Gör så att varje kolumn består av 4 rader
                System.out.println("");
                räknare = 0;
            }
            System.out.print(platser[i]); 
            räknare++;
        }
        System.out.println("");

    }


    //metod för att boka platser
    public static int[] bokaPlats(int[] platser){

        //scanner för denna metod eftersom den vi deklarerade i början inte fungerar i metoden eftersom den är utanför
        Scanner reader = new Scanner(System.in); // Scanner
        visaPlatser(platser);

        //tar input från använmdaren
        System.out.print("\nVilken plats på planet vill du ha? (1-20): ");
        while(true){
            //loop där man kollar om platsen är ledig, om den är ledig får användaren platsen
            //annars måste användaren försöka igen 
            int valdPlats = Integer.parseInt(reader.nextLine())-1; //den plats som användaren väljer
            if(platser[valdPlats] == 0){
                platser[valdPlats] = 1;
                break;
            }
            
            else{
                System.out.println("Plats nummer " + valdPlats + " är upptagen, vänligen välj en annan plats: ");
            }
            reader.close();
        }
        
        //skriver ut hur platserna ser ut i planet
        System.out.println("De uppdaterade platserna: ");
        visaPlatser(platser);
        
        return platser;

        
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner reader = new Scanner(System.in); // Scanner

        int[] platser = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,}; //array
        boolean loop = true;

        while(loop){
            meny();
            String menysvar = reader.nextLine();
            switch(menysvar){
                case "1":

                System.out.println("Hur gammal är du?");
                reader.nextInt();
                int ålder = reader.nextInt();
        
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
                    Räknautvinst();
                    System.out.println("Din vinst är: " + vinst + "kr");
                    System.out.println("Tryck enter för att fortsätta");
                    reader.nextLine();
                break;
    
                // menysvar.close();
            }
            System.out.println("programet avslutas");
            loop = false;
        }

        reader.close();
    }      
}  
