package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
        
        // temp code
        private BufferedImage test;
        private SpriteSheet sheet;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init(){
		display = new Display(title, width, height);
                test = ImageLoader.loadImage("/textures/people.png");
                sheet = new SpriteSheet(test);
	}
	
	private void tick(){
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
                // Clear Screen
                g.clearRect(0, 0, width, height);
		//Draw Here!
		
                g.drawImage(sheet.crop(0, 0, 198, 198), 5, 5, null);
                g.drawImage(sheet.crop(202, 0, 198, 198), 250, 5, null);
                
                // delete - g.drawImage(test, 20, 20, null);
                
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		while(running){
			tick();
			render();
		}
		
		stop();
		
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
	thread.start();
	}
	
	public synchronized void stop(){
            try {
                if(!running)
                    return;
                running = false;
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
}
