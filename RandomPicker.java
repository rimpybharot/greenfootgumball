import java.util.ArrayList;
import java.util.List;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //this.pick();
    }    
    
    public void pick(){
        Gumball gb;// = new Gumball();
        int lottery = Greenfoot.getRandomNumber(3);
        System.out.println("Lottery No:"+lottery);
        switch(lottery){
        case 0 : gb = new BlueGumball();break;
        case 1 : gb = new RedGumball();break;
        case 2 : gb = new GreenGumball();break;
        default : gb = new RedGumball();break;
        }
        
        World world = getWorld();

        world.addObject(gb, 500, 500);
        GumballMachine gbm = new GumballMachine();
        List<Actor> actors = world.getObjects(Actor.class);
        for(Actor actor : actors){
            if (actor.getClass() == GumballMachine.class) {
                gbm = (GumballMachine) actor;
                break;
            }
        }
        
        gbm.setMessage(gb.getClass().getName());
    }

}
