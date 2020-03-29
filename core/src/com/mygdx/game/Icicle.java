package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class Icicle {
    Vector2 position;
    Vector2 velocity;

    public Icicle(Vector2 position) {

        this.position = position;
        velocity = new Vector2(0, 0);
    }

    public void render(ShapeRenderer shapeRenderer, float delta) {
        shapeRenderer.setColor(Constants.ICICLE_COLOR);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);

        update(delta);

        shapeRenderer.triangle(
                position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT
        );

    }

    void update(float delta) {
        velocity.y += delta * Constants.ICICLES_GRAVITY;
        position.y += delta * velocity.y;
    }

    public boolean isBelowScreen() {
        return position.y < 0;
    }

    public boolean isDead(Player player) {
        Vector2 playerPosition = player.position;
        return (position.x > playerPosition.x - Constants.PLAYER_HEAD_RADIUS)  &&
                (position.x < playerPosition.x + Constants.PLAYER_HEAD_RADIUS) &&
                (position.y > playerPosition.y - Constants.PLAYER_HEAD_RADIUS) &&
                (position.y < playerPosition.y + Constants.PLAYER_HEAD_RADIUS);

    }


}
