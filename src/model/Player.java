package model;

import java.util.Random;

public class Player extends Character{
    
    Random random = new Random();

    public Player(String characterName, int characterHealth, int characterAttack) {
        super(characterName, characterHealth, characterAttack);
    }
    
    // can do attack and use hability (soon)
    public void heavyAttack() {
        int damage = this.getAttack();
        int probHeavyAttack = random.nextInt(100);
    }
    
}
