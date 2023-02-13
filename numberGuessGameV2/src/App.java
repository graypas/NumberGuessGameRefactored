import java.util.*;

public class App {
    public static Game game1; 
    static int min = 1;
    static int max;
    static int number;
    static int guess;
    static int guessCount = 0;

    public static boolean validInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } 
        catch (NumberFormatException e) {
            System.out.println("Not an integer, try again.");
            return false;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Would you like to start the number guess game?\n1 : yes\n2 : no");
            while(true){
                String begGame = input.nextLine();
                boolean roar2 = validInt(begGame);

                if (roar2 == false || !begGame.equals("1") && !begGame.equals("2")){
                    System.out.println("input an integer or a number between 1 and 2");
                    continue;
                }

                else if(begGame.equals("2")){
                    System.exit(0);
                }
                else{
                    game1 = new Game(0,0);
                    break;
                }
            }

            System.out.println("Input one of these numbers to select the difficulty of this game");
            System.out.println("1 : Minimum 1 Maximum 10\n2 : Minimum 1 Maximum 50\n3 : Minimum 1 Maximum 100");

            while(true){
                String diffInp = input.nextLine();
                boolean roar = validInt(diffInp);

                if (roar == false || !diffInp.equals("1") && !diffInp.equals("2") && !diffInp.equals("3")){
                    System.out.println("input an integer or a number between 1 and 3");
                    continue;
                }
                else{
                    game1.diffLvl = Integer.parseInt(diffInp);
                    break;
                }    
            }
            
            if (game1.diffLvl == 1){
                max = 10;
            }
            if (game1.diffLvl == 2){
                max = 50;
            }
            if (game1.diffLvl == 3){
                max = 100;
            }

            Random rand = new Random();
            number = rand.nextInt(max - min + 1) + min;

            ArrayList<Integer> bark1 = new ArrayList<Integer>();
            ArrayList<Integer> bark2 = new ArrayList<Integer>();
            ArrayList<Integer> bark3 = new ArrayList<Integer>();

            ArrayList<Integer> previousGuesses = new ArrayList<Integer>();
            System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess it?");

            while (guess != number) {
                System.out.print("Enter your guess: ");

                if (input.hasNextInt()) {
                    guess = input.nextInt();

                    if (previousGuesses.contains(guess)) {
                        System.out.println("You already tried this number. This guess isn't counted.");
                        continue;
                    }
                    previousGuesses.add(guess);
                    guessCount++;

                    if (guess < min || guess > max) {
                        System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                        continue;
                    }

                    if (guess < number) {
                        System.out.println("Your guess is too low.");
                    } else if (guess > number) {
                        System.out.println("Your guess is too high.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                    input.nextLine();
                }
            }

            System.out.println("You guessed the number in " + guessCount + " attempts.");
            Game.finalScore = Game.finalScore + guessCount;
            System.out.println("Would you like to play again\n1 : yes\n2 : no");
            while(true){
                String newGame = input.nextLine();
                boolean roar3 = validInt(newGame);

                if (roar3 == false || !newGame.equals("1") && !newGame.equals("2")){
                    System.out.println("input an integer or a number between 1 and 2");
                    continue;
                }

                else if(newGame.equals("2")){
                    System.exit(0);
                    input.close();  
                }

                else{
                    if(game1.diffLvl == 1){
                        bark1.add(Game.finalScore);
                        System.out.println("Your guesses for the difficulty level 1 are: ");
                        System.out.println(bark1);
                        
                    }
                    else if(game1.diffLvl == 2){
                        bark2.add(Game.finalScore);
                        System.out.println("Your guesses for the difficulty level 2 are: ");
                        System.out.println(bark2);
                        
                    }
                    else if(game1.diffLvl == 3){
                        bark3.add(Game.finalScore);
                        System.out.println("Your guesses for the diffuclty level 3 are: ");
                        System.out.println(bark3);
                    }

                    break;
                }       
            }
        }
    }
}