package com.ajayinkingston.ld41;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	Texture img;
	
	Camera cam;
	
	Level level;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		img = new Texture("badlogic.jpg");
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		
		level = new Level(this);
	}
	
	@Override
	public void resize(int width, int height) {
		((OrthographicCamera) cam).setToOrtho(false, width, height);
		resizeBatch(cam.combined);
	}
	
	public void resizeBatch(Matrix4 matrix) {
     	batch.setProjectionMatrix(matrix);
		shapeRenderer.setProjectionMatrix(matrix);
		cam.update();
	}
	
	public void resizeBatch(int width, int height) {
		Matrix4 projectionMatrix = new Matrix4();
		projectionMatrix.setToOrtho2D(0, 0, width, height);
		resizeBatch(projectionMatrix);
	}

	@Override
	public void render () {
		
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		level.render();
		
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
