package main;

import java.util.Random;
import java.util.Scanner;
import model.Enemy;
import model.Player;
import static utils.Validator.requestValidIndex;

public class NeuroDungeon {

    public static void main(String[] args) {
        
        Random random = new Random();
        
        Player player = new Player("Gordo", 55, 55, 15, 5); // add then the energy
        
        Scanner scanner = new Scanner(System.in);
        while(player.isAlive()) {
            Enemy enemy = spawnEnemy(player, random);
            startBattle(player, scanner, random, enemy);
        }
    }
    // para generar enemigos de acuerdo al nivel de player, tal vez hacer metodo que revise nivel y genere segun
    public static void startBattle(Player player, Scanner sc, Random random, Enemy enemy) {
        int combatOption = 0;
        System.out.println("You encounter a " + enemy.getName() + "!\n");
        while(enemy.isAlive() && player.isAlive()) {
            System.out.println(player.getName() + " HP: " + player.getCurrentHealth() + " - Attack: " + player.getAttack() + " DMG");
            System.out.println(enemy.getName() + " HP: " + enemy.getCurrentHealth() + " - Attack: " + enemy.getAttack() + " DMG");
            System.out.println("");
            System.out.println("1. Attack");
            System.out.println("2. Heavy Attack");
            System.out.println("3. Heal");
            System.out.println("4. Do nothing");

            combatOption = requestValidIndex(sc, 1, 4, "Choose action: ");
            System.out.println("");

            if (combatOption == 1) {
                player.attack(enemy);
            }

            if (combatOption == 2) {
                player.heavyAttack(enemy);
            }
            
            if(combatOption == 3) {
                player.gainHeal(15);
            }

            if (enemy.isAlive()) {
                enemy.attack(player);
            }
            
            if (player.isAlive() == false) {
                System.out.println("Game over!");
            }
        }
        
        if(enemy.isAlive() == false) {
            System.out.println(player.getName() + " killed a " + enemy.getName() + "!\n");
            player.gainExperience(enemy.getExpToGive());
            player.levelUp();
        }
    }
    
    public static Enemy spawnEnemy(Player player, Random random) {
        switch (player.getLevel()) {
            case 1 -> {
                Enemy goblinEnemy = new Enemy("Goblin", 40, 40, 0, 6, 25);
                return goblinEnemy;
            }
            case 2 -> {
                int probEnemySpawn = random.nextInt(100);
                if(probEnemySpawn < 60) {
                    Enemy goblinEnemy = new Enemy("Goblin", 40, 40, 0, 6, 25);
                    return goblinEnemy;
                } else {
                    Enemy orcEnemy = new Enemy("Orc", 60, 60, 0, 8, 50);
                    return orcEnemy;
                }
            }
            case 3 -> {
                int probEnemySpawn = random.nextInt(100);
                if(probEnemySpawn < 60) {
                    Enemy demonEnemy = new Enemy("Demon", 85, 80, 0, 11, 100);
                    return demonEnemy;
                } else if (probEnemySpawn < 90) {
                    Enemy orcEnemy = new Enemy("Orc", 60, 60, 0, 8, 50);
                    return orcEnemy;
                } else {
                    Enemy goblinEnemy = new Enemy("Goblin", 40, 40, 0, 6, 25);
                    return goblinEnemy;
                }
            }
            default -> {
                Enemy goblinEnemy = new Enemy("Goblin", 40, 40, 0, 6, 30);
                return goblinEnemy;
            }
        }
    }
}
