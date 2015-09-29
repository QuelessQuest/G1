package com.barrypress.wiz.map;

import com.BombingGames.WurfelEngine.Core.Gameobjects.CustomBlocks;
import com.BombingGames.WurfelEngine.Core.Gameobjects.RenderBlock;
import com.BombingGames.WurfelEngine.Core.Map.Coordinate;

public class Square implements CustomBlocks {

    public String getName(byte id, byte value) {

        String name = "";

        switch (id) {
            case 10:
                name = "Wall";
                break;
            case 11:
                name = "Floor";
                break;
        }

        return name;
    }


    public boolean isObstacle(byte id, byte value) {

        boolean obstacle;

        switch(id) {
            case 10:
                obstacle = true;
                break;
            default:
                obstacle = false;
                break;
        }

        return obstacle;
    }

    public boolean isLiquid(byte id, byte value) { return false; }

    public boolean isTransparent(byte id, byte value) { return false; }

    public void setHealth(Coordinate coord, byte health, byte id, byte value) { return ;}

    public RenderBlock toRenderBlock(byte id, byte value) {
        return new RenderBlock(id);
    }
}