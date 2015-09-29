package com.barrypress.wiz.map;

import com.BombingGames.WurfelEngine.Core.Map.Generator;
import com.barrypress.wiz.utility.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileGenerator implements Generator {

    public enum ROTATION {ROTATE_0, ROTATE_90, ROTATE_180, ROTATE_270};

    private List<TileData> basicTiles;
    private List<TileData> activeList;

    private ROTATION rotation;

    public TileGenerator() {
        Map<String, List<TileData>> tileMapping = getTileData();
        rotation = ROTATION.ROTATE_0;
        basicTiles = new ArrayList<>(tileMapping.get(Constants.TS_BASIC));
        activeList = basicTiles;
    }

    public void setRotation(ROTATION rotation) {
        this.rotation = rotation;
    }

    public void setActiveList(String setType) {

        if (setType.equals(Constants.TS_BASIC)) {
            activeList = basicTiles;
        }
    }

    @Override
    public byte generate(int x, int y, int z) {

        byte id = 0;

        switch (rotation) {
            case ROTATE_0:
                break;
            case ROTATE_90:
                int i = x;
                x = 3 - y;
                y = i;
                break;
        }

        for (TileData square : activeList) {
            if (square.getX() == x && square.getY() == y) {
                if (z == 1) {
                    if (square.getId() == 10) {
                        id = (byte) square.getId();
                    } else {
                        id = 0;
                    }
                } else {
                    id = (byte) square.getId();
                }
            }
        }

        return id;
    }

    // TODO
    private Map<String, List<TileData>> getTileData() {
        TileData tileData = new TileData();
        List<TileData> tiles = new ArrayList<>();
        tiles.add(tileData);

        Map<String, List<TileData>> sets = new HashMap<>();
        sets.put("basic", tiles);

        return sets;
    }
}
