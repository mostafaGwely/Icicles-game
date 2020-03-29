package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class Icicle {
    Vector2 position;

    public Icicle(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Constants.ICICLE_COLOR);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.triangle(
                position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT
        );

    }
}
