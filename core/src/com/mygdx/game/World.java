package com.mygdx.game;

public class World {
	private Pacman pacman;
    private PacmanGame pacmanGame;
    
    private Maze maze;
    
    private int score;
 
    World(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        
        maze = new Maze();
 
        pacman = new Pacman(60, 60, this);
        
        registerDotEattenListener();
    }
    
  //Interface Register
    private void registerDotEattenListener() {
        pacman.registerDotEattenListener(new Pacman.DotEattenListener() {
            @Override
            public void notifyDotEatten() {
                score += 1;
            }
        });
    }
 
    Pacman getPacman() {
        return pacman;
    }
    
    Maze getMaze() {
    	return maze;
    }
    
    //Count Score
    
    public void increaseScore() {
    	score += 1;
    }
    public int getScore() {
    	return score;
    }
    
    public void update(float delta) {
    	pacman.update();
    }
}
