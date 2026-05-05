package model;

public class Character {
    
    // has: name, health and attack
    private String name;
    private int health;
    private int attack;
    
    // Constructor
    public Character(String characterName, int characterHealth, int characterAttack) {
        this.name = characterName;
        this.health = characterHealth;
        this.attack = characterAttack;
    }
    
    // Main methods
    public void attack(Character target) {
        int damage = this.getAttack();
        target.takeDamage(damage);
    }
    
    public void takeDamage(int damage) {
        health = this.health - damage;
        
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " took " + damage + " damage!");
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
