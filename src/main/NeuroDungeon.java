package main;

import java.util.Scanner;
import model.Enemy;
import model.Player;
import static utils.Validator.requestValidIndex;

public class NeuroDungeon {

    public static void main(String[] args) {
        
        int combatOption = 0;
        
        Player player = new Player("Pipi", 55, 5);
        Enemy goblinEnemy = new Enemy("Goblin", 40, 7, 25);
        Enemy orcEnemy = new Enemy("Orc", 60, 8, 50);
        Enemy demonEnemy = new Enemy("Demon", 80, 10, 100);
        
        Scanner scanner = new Scanner(System.in);
        
        startBattle(player, goblinEnemy, scanner, combatOption);
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
            
            combatOption = requestValidIndex(sc, 1, 3, "Choose action: ");
            System.out.println("");
            
            if(combatOption == 1) {
                player.attack(enemy);
            }
            
            if(combatOption == 2) {
                player.heavyAttack(enemy);
            }
            
            if (enemy.isAlive()) {
                enemy.attack(player);
            } else {
                System.out.println("Exp actual: " + player.getPlayerExperience() + ", pero mataste al bicho por lo que se te suma " + enemy.getExpToGive());
                player.gainExperience(enemy.getExpToGive(), enemy);
                player.levelUp();
                System.out.println("Quedas con " + player.getPlayerExperience() + " de exp gordo!");
            }
        }
    }
}
