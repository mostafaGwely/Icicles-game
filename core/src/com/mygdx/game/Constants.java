package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class Constants {
    public static Color BACKGROUND_COLOR = Color.BLUE;
    public static float ICICLES_WIDTH = 50.0F;
    public static float ICICLES_HEIGHT = 100.0F;
    public static Color ICICLE_COLOR = Color.WHITE;

    public static float PLAYER_HEAD_RADIUS = 20.F;
    public static float PLAYER_TORSO_HEIGHT = 3 * PLAYER_HEAD_RADIUS;
    public static float PLAYER_LEG_HEIGHT = 2 * PLAYER_HEAD_RADIUS;
    public static float PLAYER_HEAD_HEIGHT = PLAYER_LEG_HEIGHT + PLAYER_HEAD_RADIUS + PLAYER_TORSO_HEIGHT;
    public static float PLAYER_SPEED = 5.0f;

    public static float PLAYER_LIMB_WIDTH = PLAYER_HEAD_RADIUS /4;
    public static int PLAYER_HEAD_SEGMENTS = 50;
    public static Color PLAYER_HEAD_COLOR = Color.BLACK;

}
