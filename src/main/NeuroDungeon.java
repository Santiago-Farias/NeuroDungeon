package main;

import model.Enemy;
import model.Player;

public class NeuroDungeon {

    public static void main(String[] args) {
        
        Player player = new Player("Pipi", 55, 5);
        Enemy enemy = new Enemy("Goblin", 40, 7);
        
        System.out.println("health " + enemy.getName() + ": " + enemy.getHealth());
        player.attack(enemy);
        
        System.out.println("health " + enemy.getName() + ": " + enemy.getHealth());
    }
    
}
