package dev.codenmore.tilegame;

import dev.codenmore.tilegame.Game;


public class Launcher {

	public static void main(String[] args){
		Game game = new Game("Tile Game!", 500, 650);
		game.start();
                Game game2 = new Game("Test", 200, 300);
                game2.start();
	}
	
}