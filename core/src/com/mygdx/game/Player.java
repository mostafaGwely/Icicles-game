package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player extends InputAdapter {
    Vector2 position;
    Vector2 velocity;

    public Player(Vector2 position) {
        this.position = position;
        this.position.y = Constants.PLAYER_HEAD_HEIGHT - Constants.PLAYER_HEAD_RADIUS;

        velocity = new Vector2(Constants.PLAYER_SPEED, 0);
    }

    public void render(ShapeRenderer shapeRenderer) {
        float headRadius = Constants.PLAYER_HEAD_RADIUS;
        int segments = Constants.PLAYER_HEAD_SEGMENTS;
        float limbWidth = Constants.PLAYER_LIMB_WIDTH;
        float torsoHeight = Constants.PLAYER_TORSO_HEIGHT;
        float playerHeight = Constants.PLAYER_HEAD_HEIGHT;

        shapeRenderer.setColor(Constants.PLAYER_HEAD_COLOR);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);

        handleKeys();

        avoidCollision();

        //head
        shapeRenderer.circle(position.x,
                position.y,
                headRadius,
                segments);
        //torso
        Vector2 torsoUp = new Vector2(position.x, position.y - headRadius);
        Vector2 torsoBottom = new Vector2(torsoUp.x, torsoUp.y - torsoHeight);
        shapeRenderer.rectLine(torsoUp, torsoBottom, limbWidth);

        //hands right
        shapeRenderer.rectLine(torsoUp, new Vector2(
                torsoUp.x + headRadius,
                torsoUp.y - headRadius), limbWidth);
        //hands left
        shapeRenderer.rectLine(torsoUp, new Vector2(
                torsoUp.x - headRadius,
                torsoUp.y - headRadius), limbWidth);

        //legs right
        shapeRenderer.rectLine(torsoBottom, new Vector2(
                torsoBottom.x + 8 * headRadius,
                torsoBottom.y - playerHeight - torsoHeight - 2 * headRadius), limbWidth);
        //legs left
        shapeRenderer.rectLine(torsoBottom, new Vector2(
                torsoBottom.x - +8 * headRadius,
                torsoBottom.y - playerHeight - torsoHeight - 2 * headRadius), limbWidth);
    }

    private void handleKeys() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            position.x -= velocity.x;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            position.x += velocity.x;
    }

    public void avoidCollision() {
        if (position.x + Constants.PLAYER_HEAD_RADIUS > Gdx.graphics.getWidth()) {

            position.x = Gdx.graphics.getWidth() -   Constants.PLAYER_HEAD_RADIUS;
         }
        if (position.x - Constants.PLAYER_HEAD_RADIUS < 0) {
            position.x = Constants.PLAYER_HEAD_RADIUS;
         }

    }


}
