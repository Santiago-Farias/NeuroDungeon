package model;

import java.util.Random;

public class Character {
    
    // has: name, health and attack
    private String name;
    private int health;
    private int attack;
    
    Random random = new Random();
    
    // Constructor
    public Character(String characterName, int characterHealth, int characterAttack) {
        this.name = characterName;
        this.health = characterHealth;
        this.attack = characterAttack;
    }
    
    // Main methods
    public void attack(Character target) {
        int damage = this.getAttack();
        damage += random.nextInt(-2, 2);
        target.takeDamage(damage);
        System.out.println(name + " hits " + target.getName() + " for " + damage + " damage!\n");
    }
    
    public void takeDamage(int damage) {
        health = this.health - damage;
        
        if (health < 0) {
            health = 0;
        }
    }
    
    public boolean isAlive() {
        boolean characterAlive;
        return characterAlive = getHealth() > 0;
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    // Setters
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setHealh(int newHealth) {
        this.health = newHealth;
    }
    
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
}
