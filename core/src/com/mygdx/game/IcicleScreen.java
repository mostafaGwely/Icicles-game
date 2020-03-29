package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class IcicleScreen extends ScreenAdapter {

    ShapeRenderer shapeRenderer;
    Viewport viewport;

    Icicles icicles;
    Player player;

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.setAutoShapeType(true);
        icicles = new Icicles();

        player = new Player(new Vector2(Gdx.graphics.getWidth() / 2, 0));
        Gdx.input.setInputProcessor(player);
    }


    @Override
    public void render(float delta) {
        viewport.apply();
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);

        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        icicles.render(shapeRenderer, delta);
        icicles.create(delta);
        player.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {
        shapeRenderer.dispose();
    }
}
