package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Icicles {
    private Array<Icicle> icicles;
    private Random random;

    public Icicles() {
        random = new Random();
        init();
    }

    private void init() {
         icicles = new Array<>();
    }

    public void render(ShapeRenderer shapeRenderer, float delta){
        for(Icicle icicle: icicles){
            icicle.render(shapeRenderer, delta);
        }
    }

    public void create(float delta) {
        if (random.nextFloat() < delta * Constants.SPAWNS_PER_SECOND)
            icicles.add(new Icicle(new Vector2(random.nextFloat() * Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - Constants.ICICLES_HEIGHT)));
        System.out.println(delta);
    }
}
