package main;

import java.util.Scanner;
import model.Enemy;
import model.Player;
import static utils.Validator.requestValidIndex;

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
            System.out.println("2. Heavy Attack");
            System.out.println("3. Do nothing");
            
            combatOption = requestValidIndex(sc, 1, 2, "Choose action: ");
            System.out.println("");
            
            if(combatOption == 1) {
                player.attack(enemy);
            }
            
            if(combatOption == 2) {
                player.heavyAttack(enemy);
            }
            
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
    }
}
