
package model;

public class Enemy extends Character {
    int expToGive;

    public Enemy(String characterName, int characterHealth, int characterMaxHealth, int characterAttack, int expToGive) {
        super(characterName, characterHealth, characterMaxHealth, characterAttack);
        this.expToGive = expToGive;
    }
    
    // can attack auto

    public int getExpToGive() {
        return expToGive;
    }
    
}
