import java.util.Scanner;
import java.util.ArrayList;
/*import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;*/
//import java.util.Arrays;


class ForMyFavoriteNerd {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        String word = ""; 
        //int length = 0; 
        String guess = "";
        //String base = ""; 
        int numGuesses = 0; 
        ArrayList<String> pastAttempts = new ArrayList<>();
        ArrayList<String> wrongLetters = new ArrayList<>();
        //int guesses = 1;  

        //creates alphabet array list
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        char[] aAlpha = alpha.toCharArray(); 
        ArrayList<String> alphabet = new ArrayList<>();

        for (int i = 0; i < aAlpha.length; i++){

            alphabet.add(String.valueOf(aAlpha[i])); 

        }

        ArrayList<String> bBase = new ArrayList<>();
        //ArrayList<String> guessedLetters = new ArrayList<>();
   

        System.out.println("\nHi u fat nerd!!! I made a hangman game for u.");
        System.out.println("I got this idea while making my cs project. ");
        System.out.println("You get 5 lives <3"); 

        //creating the sentance
        int choice = 0;
        choice = Utils.inputIntRange("\nChoose a number between 1 and 6: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        switch(choice){ 
            case 1:
                word = ("i miss you");
                break;
            case 2:
                word = ("you're my favorite person to talk to");
                break;
            case 3:
                word = ("u better have eaten something");
                break;
            case 4: 
                word = ("i'm so lucky that ur mine!!!");
                break;
            case 5: 
                word = ("u make me rlly happy :)");
                break;
            case 6:
                word = ("i love your smile and your laugh");
                break; 
            default:
                word = ("i don't know if you'll see this one. but ur a nerd.");
        }
    


        numGuesses = 5;

        char[] aWord = word.toCharArray();

        // creates the base 
        for (int i = 0; i < aWord.length; i++) {

            if (aWord[i] == ' ' || aWord[i] == '!' || aWord[i] == '.' || aWord[i] == '\'' || aWord[i] == ':' || aWord[i] == ')'){
                bBase.add(String.valueOf(aWord[i])); 
            }
            else
                {
                    bBase.add("__ "); 
                }

        }
        //prints the base
        for (int i = 0; i < bBase.size(); i++) {

            System.out.print(bBase.get(i)); 


        }

        System.out.println("\n");
        //length = word.length(); 
        boolean run = true; 
        
        while (numGuesses > 0 && run) {

        System.out.print("Lives left: ");

        for (int i = numGuesses; i > 0; i--)
        {
            System.out.print("<3 "); 
        }
        System.out.print("\n");

            System.out.println("Guessed letters: " + pastAttempts);
            System.out.println("Wrong letters: " + wrongLetters + "\n");

            System.out.print("Enter your letter guess: ");
            guess = scan.nextLine();
            if (guess.length()!= 1){
                System.out.println("Your guess was not the correct length. Your guess must be one letter. \n");
                continue; 
            }
            if (pastAttempts.contains(guess)){
                System.out.println("You already guessed that letter");
                continue; 
            }
            if (wrongLetters.contains(guess)){
                System.out.println("You already guessed that letter");
                continue; 
            }

            ArrayList<String> cBase = new ArrayList<>();
            cBase = bBase; 

            //if the letter is in the word, the thing changes
            for (int i = 0; i < bBase.size(); i ++){
                if (String.valueOf(aWord[i]).equals(guess)){
                    bBase.set(i, guess + " "); 
                    cBase.set(i, guess + " ");
                    if (!pastAttempts.contains(guess)){
                    pastAttempts.add(guess); 
                    }
                }
            }
            
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < aWord.length; i++){
                temp.add(String.valueOf(aWord[i])); 

            }
            if (!temp.contains(guess)){
                numGuesses --; 
                wrongLetters.add(guess);
            }            
            

            for (int i = 0; i < bBase.size(); i++) {
                
                System.out.print(bBase.get(i)); 
    
            }
            System.out.println("\n"); 

            if (!bBase.contains("__ ")){
                System.out.println("\nGOOD JOB U GOT IT! ");
                break;
            }

        }

        if (numGuesses == 0){
            System.out.println("You ran out of lives. Try again :("); 
        }

    
    
        scan.close(); 
    }

}

