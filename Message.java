import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
   private GreenfootImage gi;
   public Message()
   {
       gi = new GreenfootImage(180,30);
       setImage(gi);
   }
    
   public void setText(String msg)
   {
       gi.clear();
       gi.setColor(greenfoot.Color.YELLOW);
       gi.fill();
       gi.setColor(greenfoot.Color.BLACK);
       gi.drawString(msg,10,15);
       
    }
       
    public void act() 
    {
       if(Greenfoot.mousePressed(this))
       {
           World world = getWorld();
           world.removeObject(this);
       }
    }    
}
