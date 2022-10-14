import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();

        int userCard1 = drawRandomCard();
        int userCard2 = drawRandomCard();
        int userCardValue = Math.min(userCard1, 10) + Math.min(userCard2, 10);
        
        System.out.println("\nYou get a\n" + cardString(userCard1) + "\n and a \n" + cardString(userCard2));
        System.out.println("Your total is: " + userCardValue);
        
        scan.nextLine();
        
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        
        
        System.out.println("The dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

        /********************************************************************/

        while (true) { 

            String option = hitOrStay();

            if (option.equalsIgnoreCase("stay")) {
                break;
            } 

            int newCard = drawRandomCard();
            userCardValue += Math.min(newCard, 10);
            System.out.println("\n You get a\n" + cardString(newCard));
            System.out.println("Your total is: " + userCardValue);
            
            
            if (userCardValue > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }

        }
        /**************************************************** */
        System.out.println("\nDealer's turn");

        System.out.println("The dealer's cards are\n" + cardString(dealerCard1) + "\nand\n" + cardString(dealerCard2));
        
        int dealerCardValue = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);
        System.out.println("Dealer's total is: " + dealerCardValue);

        while (dealerCardValue < 17) {
            int newDealerCard = drawRandomCard();
            dealerCardValue += Math.min(newDealerCard, 10);
            
            System.out.println("\n Dealer gets a \n" + cardString(newDealerCard));
            System.out.println("Dealer's total is: " + dealerCardValue);
        }

        if (dealerCardValue > 21) {
            System.out.println("Bust! Dealer loses");
            System.exit(0);
        }

        if (dealerCardValue < userCardValue) {
            System.out.println("Player Wins");
        } else {
            System.out.println("Dealer Wins");
        }
        
        scan.close();

    }

    public static int drawRandomCard() {
        double cardNumber = Math.random() * 13;
        cardNumber += 1;
        return (int)cardNumber; 
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";
            
            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";

            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";

            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";

            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";

            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";

            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";

            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";

            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";

            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";

            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";

            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";

            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";

            default: return "This should not get called";
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
     public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");
        String response = scan.nextLine();

        while (true) {
            if (response.equalsIgnoreCase("hit") || response.equalsIgnoreCase("stay")) {
                break;

                // true: if one response is hit or stay. then loop will break and return its response
            }   // false: line 177 is 'aaa', condition is false. then will continue to loop line 185
                // ignorecase: both upper or lower cases can be accepted
            response = scan.nextLine();
        }
        return response;
     }
    }

