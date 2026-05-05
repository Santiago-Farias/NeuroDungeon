package model;

import java.util.Random;

public class Player extends Character{
    int playerExperience = 0;
    int playerLevel = 1;
    
    Random random = new Random();

    public Player(String characterName, int characterHealth, int characterAttack) {
        super(characterName, characterHealth, characterAttack);
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
    
    public void gainExperience(int expToGain, Character expSource) {
        playerExperience += expToGain;
    }
    
    public void levelUp() {        
        if(playerExperience >= 100 && playerLevel == 1) {
            playerLevel = 2;
        } else if (playerExperience >= 250 && playerLevel == 2){
            playerLevel = 3;
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
