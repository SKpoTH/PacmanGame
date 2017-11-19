package com.mygdx.game;

import java.lang.reflect.GenericArrayType;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	 private PacmanGame pacmanGame;
	 
	 private Texture pacmanImg;
	 
	 private Pacman pacman;
	 
	 World world;
	 
	 WorldRenderer worldRenderer;
	 
	    public GameScreen(PacmanGame pacmanGame) {
	        this.pacmanGame = pacmanGame;
	        
	        pacmanImg = new Texture("pacman.png");
	        
	        world = new World(pacmanGame);
	        
	        worldRenderer = new WorldRenderer(this.pacmanGame, world);
	    }
	    
	    @Override
	    public void render(float delta) {
	    	Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        
	        update(delta);
	        
	        worldRenderer.render(delta);   	
	    }
	    
	    private void update(float delta) {
	    	if(Gdx.input.isKeyPressed(Keys.UP)) {
	    		world.getPacman().move(Pacman.DIRECTION_UP);
	        }
	    	if(Gdx.input.isKeyPressed(Keys.DOWN)) {
	            world.getPacman().move(Pacman.DIRECTION_DOWN);
	        }
	    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	    		world.getPacman().move(Pacman.DIRECTION_LEFT);
	        }
	    	if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	    		world.getPacman().move(Pacman.DIRECTION_RIGHT);
	        }
	    }
}
