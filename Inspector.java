import java.util.ArrayList;
import java.util.List;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
	public GumballMachine gumballmachine = new GumballMachine();
	private ArrayList<Picker> pickers = new ArrayList<Picker>();
	
	public void addPicker(Picker obj){
		System.out.println(obj.getClass().getName());
	    pickers.add(obj);
	}
	
	public void removePicker(Picker obj){
		pickers.remove(obj);
	}
	
	public void inspect(Coin coin){
		System.out.println("Size in pickers:"+ pickers.size());
		int whichPicker = Greenfoot.getRandomNumber(pickers.size());
		System.out.println("Which picker:" + whichPicker);
		Picker pickerChosen = pickers.get(whichPicker);
		System.out.println(pickerChosen.getClass().getName());
		if(coin.getClass() == Quarter.class){
			pickerChosen.pick();
		} else{
		    gumballmachine.setMessage("Wrong Coin - No Return");
		    gumballmachine.setHaveCoin(null);
		}
	}
    
    public void setup(){
        System.out.println("Inspector setup called");
        this.gumballmachine=null;
        this.pickers.clear();
        World world = getWorld();
        List<Actor> actors = world.getObjects(Actor.class);
        for(Actor actor : actors){
            if (actor.getClass() == GumballMachine.class) {
                this.gumballmachine = (GumballMachine) actor;
            } 
            if (actor.getClass() == RandomPicker.class) {
                addPicker((Picker) actor);
            } 
            if (actor.getClass() == GreenPicker.class) {
                addPicker((Picker) actor);
            } 
        }
    }
    
    public void act() 
    {
        int mouseX, mouseY ;
        
        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);  
        }
    }    
}
