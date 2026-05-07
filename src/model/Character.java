package model;

import java.util.Random;

public class Character {
    
    // has: name, health and attack
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int heal;
    private int attack;
    
    Random random = new Random();
    
    // Constructor
    public Character(String characterName, int characterHealth, int characterMaxHealth, int characterHeal, int characterAttack) {
        this.name = characterName;
        this.currentHealth = characterHealth;
        this.maxHealth = characterMaxHealth;
        this.heal = characterHeal;
        this.attack = characterAttack;
    }
    
    // Main methods
    public void attack(Character target) {
        int damage = this.getAttack();
        int probCriticalDamage = random.nextInt(100);
        if(probCriticalDamage < 20) {
            damage = damage * 2;
            target.takeDamage(damage);
            System.out.println(name + " hits " + target.getName() + " for " + damage + " damage (CRITICAL)!\n");
        } else {
            target.takeDamage(damage);
            System.out.println(name + " hits " + target.getName() + " for " + damage + " damage!\n");
        }
    }
    
    public void takeDamage(int damage) {
        currentHealth = this.currentHealth - damage;
        
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }
    
    public void gainHeal(int heal) {
        currentHealth = this.currentHealth + this.heal;
        
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
        
        System.out.println(this.getName() + " use a heal (+" + heal + " HP)");
    }
    
    public boolean isAlive() {
        boolean characterAlive;
        return characterAlive = getCurrentHealth() > 0;
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public int getCurrentHealth() {
        return this.currentHealth;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public int getHeal() {
        return this.heal;
    }
    
    // Setters
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setMaxHealth(int newMaxHealth) {
        this.maxHealth = newMaxHealth;
    }
    
    public void setCurrentHealh(int newCurrentHealth) {
        this.currentHealth = newCurrentHealth;
    }
    
    public void setHeal(int newHeal) {
        this.heal = newHeal;
    }
    
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
}
