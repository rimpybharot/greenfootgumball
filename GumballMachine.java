
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{

    private Message message = new Message();
    private Actor haveCoin;
  
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }

    public void setMessage(String msg){
        int mouseX, mouseY;
        MouseInfo mouse = Greenfoot.getMouseInfo();  
        mouseX=mouse.getX();  
        mouseY=mouse.getY();  
        World world = getWorld();
        if(message.getWorld()!=null){
            world.removeObject(message);
        }

        world.addObject(message, mouseX, mouseY);
        message.setText(msg);

    }
    
    public Actor getHaveCoin(){
        return this.haveCoin;
    }

    
    public void setHaveCoin(Actor a){
        this.haveCoin = a;
    }

    /* (non-Javadoc)
     * @see greenfoot.Actor#act()
     */
    public void act() 
    //    {
    //      
    //      if(Greenfoot.mousePressed(this)){
    //        // Add your action code here.
    //      int mouseX, mouseY;
    //      MouseInfo mouseinfo = Greenfoot.getMouseInfo();
    //      mouseX = mouseinfo.getX();
    //      mouseY = mouseinfo.getY();
    //      
    //      GreenfootImage greenfootimage = new GreenfootImage(10, 10);
    //      greenfootimage.setColor(Color.BLACK);
    //      greenfootimage.fill();
    //      greenfootimage.setColor(Color.YELLOW);
    //      greenfootimage.drawString("Crank Turned", 0, 50);
    //      Message message = new Message();
    //      message.setImage(greenfootimage);
    //      World world = getWorld();
    //      world.addObject(message, mouseX, mouseY);
    //      }
    //      
    //      Actor  coin;
    //      coin = getOneIntersectingObject(Coin.class);
    //      if(coin!=null){
    //          System.out.println(coin.toString());
    //          World world = getWorld();
    //          world.removeObject(coin);
    //          
    //      }

    {
        //System.out.println("GB Machine Act:");
        if(Greenfoot.mousePressed(this)){
            World w = getWorld();
            List<Actor> actors = w.getObjects(Actor.class);
            
            for(Actor actor : actors){
            if ((actor.getClass() == GreenGumball.class) ||
            (actor.getClass() == RedGumball.class) ||
            (actor.getClass() == BlueGumball.class)){
                w.removeObject(actor);
                this.haveCoin = null;

            } 
        }
            
            if(haveCoin == null){
                setMessage("No Coin in Slot");
            }
            else
            {
                setMessage("Crank Turned");
                
                Actor inspector = getOneObjectAtOffset(+100, +100,  Inspector.class);
                //Actor inspector = getWorld().getObjects(Inspector.class);
                if(inspector != null){
                    Coin selectedCoin = (Coin)haveCoin;
                    //setMessage("Ins selected");
                    //setMessage(((Inspector) inspector).setup());
                    ((Inspector) inspector).setup();
                    ((Inspector) inspector).inspect(selectedCoin);
                    inspector.move(+300);
                }else{
                    setMessage("Move Inspector closer");
                    
                }
            }
            
            Actor coin = getOneObjectAtOffset(+20, +20,  Coin.class);
            if(coin != null){
                //setMessage("Coin Selected");
                if(haveCoin!=null){
                    coin.move(-300);
                }
                else{
                    haveCoin = coin;
                    setMessage("Coin-" + haveCoin.getClass().getName() );
                    //setMessage(coin.getClass().getName());
                    ((Coin) coin).inSlot();
                }
            }
        }
    }






}

