package com.barrypress.wiz.map;

import com.BombingGames.WurfelEngine.Core.Gameobjects.AbstractEntity;
import com.BombingGames.WurfelEngine.Core.Gameobjects.AbstractGameObject;
import com.BombingGames.WurfelEngine.Core.Gameobjects.CoreData;
import com.BombingGames.WurfelEngine.Core.Gameobjects.RenderBlock;
import com.BombingGames.WurfelEngine.Core.Map.Chunk;
import com.BombingGames.WurfelEngine.Core.Map.ChunkMap;
import com.BombingGames.WurfelEngine.Core.Map.Coordinate;
import com.BombingGames.WurfelEngine.Core.Map.Generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tile extends Chunk {

    public Tile(final ChunkMap map, final int coordX, final int coordY) {
        super(map, coordX, coordY);
    }

    public Tile(final ChunkMap map, final File path, final int coordX, final int coordY, final Generator generator) {
        super(map, path, coordX, coordY, generator);
    }

    public Tile(final ChunkMap map, final int coordX, final int coordY, final Generator generator) {
        super(map, coordX, coordY, generator);
    }

}
