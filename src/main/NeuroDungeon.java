package main;

import java.util.Scanner;
import model.Enemy;
import model.Player;

public class NeuroDungeon {

    public static void main(String[] args) {
        
        int combatOption = 0;
        
        Player player = new Player("Pipi", 55, 5);
        Enemy enemy = new Enemy("Goblin", 40, 7);
        
        Scanner scanner = new Scanner(System.in);
        
        startBattle(player, enemy, scanner, combatOption);
    }
    
    public static void startBattle(Player player, Enemy enemy, Scanner sc, int combatOption) {
        System.out.println("You encounter a " + enemy.getName() + "!\n");
        while(player.isAlive() && enemy.isAlive()) {
            System.out.println(player.getName() + " HP: " + player.getHealth() + " - Attack: " + player.getAttack() + " DMG");
            System.out.println(enemy.getName() + " HP: " + enemy.getHealth() + " - Attack: " + enemy.getAttack() + " DMG");
            System.out.println("");
            System.out.println("1. Attack");
            System.out.println("2. Do nothing");
            
            combatOption = requestValidIndex(sc, 1, 2, "Choose action: ");
            System.out.println("");
            
            if(combatOption == 1) {
                player.attack(enemy);
            }
            
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
    }
    
    public static int requestValidIndex(Scanner scanner, int inputMin, int inputMax, String inputText) { // if the inputMin is 0, and user enter text, this thing will show a error with 0 too
        String inputStringTemp;
        int stringConveted = 0;
        boolean stringConvertedFlag;
        
        do {
            stringConvertedFlag = true;
            System.out.print(inputText);
            inputStringTemp = scanner.nextLine();
        try {
            stringConveted = Integer.parseInt(inputStringTemp);
        } catch (NumberFormatException e) {
            System.out.println("Error converting '" + inputStringTemp + "' to an integer: " + e);
            stringConvertedFlag = false;
        } 
        
        if ((stringConveted < inputMin || stringConveted > inputMax)) {
            System.out.println("The '" + stringConveted + "' value is out of valid range! (Valid range: " + inputMin + " -> " + inputMax + ")");
            stringConvertedFlag = false;
        }
        } while (stringConvertedFlag == false);
       
        return stringConveted;
    }
}
