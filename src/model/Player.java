package model;

import java.util.Random;

public class Player extends Character{
    int playerExperience = 0;
    int playerLevel = 1;
    
    Random random = new Random();

    public Player(String characterName, int characterHealth, int characterMaxHealh, int characterAttack) {
        super(characterName, characterHealth, characterMaxHealh, characterAttack);
    }
    
    // can do attack and use hability (soon)
    public void heavyAttack(Character target) {
        int damage = this.getAttack();
        int probHeavyAttack = random.nextInt(100);
        
        if(probHeavyAttack < 25) {
            damage = damage * 3;
            target.takeDamage(damage);
            System.out.println("You hit the heavy attack!\n");
        } else {
            System.out.println("You missed the heavy atack!");
        }
    }
    
    public void gainExperience(int expToGain) {
        playerExperience += expToGain;
    }
    
    public void levelUp(Character player) {        
        if(playerExperience >= 100) {
            playerLevel = 2;
            player.setMaxHealth(75);
            player.setAttack(7);
            player.gainHeal(15);
        } else if (playerExperience >= 250){
            playerLevel = 3;
            player.setMaxHealth(95);
            player.setAttack(10);
            player.gainHeal(30);
        }
        System.out.println("Player level: " + playerLevel);
    }

    public int getPlayerExperience() {
        return playerExperience;
    }

    public void setPlayerExperience(int playerExperience) {
        this.playerExperience = playerExperience;
    }
}
