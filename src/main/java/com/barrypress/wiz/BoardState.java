package com.barrypress.wiz;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.monster.Monster;
import com.barrypress.wiz.map.Tile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BoardState {

    private List<PC> pcs;
    private List<Monster> monsters;
    private List<Tile> tiles;

    public void loadTiles() {

        BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("tiles.jason")));
        tiles = new Gson().fromJson(in, new TypeToken<ArrayList<Tile>>() {}.getType());
    }
}
