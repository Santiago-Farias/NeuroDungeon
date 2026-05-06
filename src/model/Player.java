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
            System.out.println("You hit the HEAVY ATTACK! " + damage + " DAMAGE!\n");
        } else {
            System.out.println("You missed the heavy atack!");
        }
    }
    
    public void gainExperience(int expToGain) {
        playerExperience += expToGain;
    }
    
    public void levelUp() {        
        if(playerExperience >= 100) {
            System.out.println("LEVEL UP!");
            playerLevel = 2;
            this.setMaxHealth(75);
            this.setAttack(7);
            this.gainHeal(15);
        } else if (playerExperience >= 250){
            System.out.println("LEVEL UP!");
            playerLevel = 3;
            this.setMaxHealth(95);
            this.setAttack(10);
            this.gainHeal(30);
        }
        System.out.println(this.getName() + " XP: " + playerExperience + " - (LVL " + playerLevel + ")");
    }

    public int getExperience() {
        return playerExperience;
    }

    public int getLevel() {
        return playerLevel;
    }
    
    public void setExperience(int playerExperience) {
        this.playerExperience = playerExperience;
    }
    
    public void setLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
}
