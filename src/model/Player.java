package model;

import java.util.Random;

public class Player extends Character{
    
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
    
}
