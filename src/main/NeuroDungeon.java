package main;

import java.util.Random;
import java.util.Scanner;
import model.Enemy;
import model.Player;
import static utils.Validator.requestValidIndex;

public class NeuroDungeon {

    public static void main(String[] args) {
        
        Random random = new Random();
        
        Player player = new Player("Gordo", 55, 55, 15, 5, 60, 60);
        
        Scanner scanner = new Scanner(System.in);
        while(player.isAlive()) {
            Enemy enemy = spawnEnemy(player, random);
            startBattle(player, scanner, random, enemy);
        }
    }
    public static void startBattle(Player player, Scanner sc, Random random, Enemy enemy) {
        int combatOption = 0;
        System.out.println("You encounter a " + enemy.getName() + "!\n");
        while(enemy.isAlive() && player.isAlive()) {
            System.out.println(player.getName() + " HP: " + player.getCurrentHealth() + " - Attack: " + player.getAttack() + " DMG - " + player.getEnergyValues().get("currentEnergy") + "/" + player.getEnergyValues().get("maxEnergy") +" ENERGY");
            System.out.println(enemy.getName() + " HP: " + enemy.getCurrentHealth() + " - Attack: " + enemy.getAttack() + " DMG");
            System.out.println("");
            System.out.println("1. Attack (" + player.getEnergyValues().get("attack") + " energy)");
            System.out.println("2. Heavy Attack (" + player.getEnergyValues().get("heavyAttack") + " energy)");
            System.out.println("3. Heal (" + player.getEnergyValues().get("heal") + " energy)");
            System.out.println("4. Do nothing");

            combatOption = requestValidIndex(sc, 1, 4, "Choose action: ");
            System.out.println("");

            if (combatOption == 1) {
                player.attack(enemy);
            }

            if (combatOption == 2) {
                if(player.loseEnergy((int) player.getEnergyValues().get("heavyAttack"))) {
                    player.heavyAttack(enemy);
                } else {
                    System.out.println("Not enough energy!");
                }
            }
            
            if(combatOption == 3) {
                if(player.loseEnergy((int) player.getEnergyValues().get("heal"))) {
                    player.gainHeal(15);
                } else {
                    System.out.println("Not enough energy!");
                }
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
            player.gainEnergy();
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
