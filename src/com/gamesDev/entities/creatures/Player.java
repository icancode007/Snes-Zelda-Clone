package com.gamesDev.entities.creatures;

import com.gamesDev.Handler;
import com.gamesDev.inventory.Inventory;
import javafx.animation.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

        //Animations
        private Animation animDown, animUp, animLeft, animRight;
        // Attack timer
        private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
        // Inventory
        private Inventory inventory;

        public Player(Handler handler, float x, float y) {
            super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);


            inventory = new Inventory(handler);
        }

        @Override
        public void tick() {

        }

        private void checkAttacks(){


        }

        @Override
        public void die(){
            System.out.println("You lose");
        }

        private void getInput(){
            xMove = 0;
            yMove = 0;

            if(inventory.isActive())
                return;

            if(handler.getKeyManager().up)
                yMove = -speed;
            if(handler.getKeyManager().down)
                yMove = speed;
            if(handler.getKeyManager().left)
                xMove = -speed;
            if(handler.getKeyManager().right)
                xMove = speed;
        }

        @Override
        public void render(Graphics g) {
            g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        }

        public void postRender(Graphics g){

        }

        private BufferedImage getCurrentAnimationFrame(){
                BufferedImage placeHolder = new BufferedImage(10,10,10);
                return placeHolder;
        }

//        public Inventory getInventory() {
//
//        }

        public void setInventory(Inventory inventory) {
            this.inventory = inventory;
        }
}
