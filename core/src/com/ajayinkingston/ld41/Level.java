package com.ajayinkingston.ld41;

public class Level {
	
	Main main;
	
	ParticleBox particleBox;
	
	Clouds clouds;
	
	public Level(Main main) {
		this.main = main;
		
		particleBox = new ParticleBox(main, 400, 500);
		
		clouds = new Clouds(main);
	}
	
	public void render() {
		
		particleBox.prerender();
		
		clouds.render();
		
		particleBox.render();
		
	}
	
	public void update() {
		particleBox.update();
		
		clouds.update();
	}
	
	public void resize(int width, int height) {
		particleBox.resize(width, height);
	}
}
