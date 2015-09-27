package com.barrypress.wiz.tile;

import java.util.List;

public class Tile {

    private Integer arrow;
    private List<Integer> squares;
    private Integer num;

    public Integer getArrow() {
        return arrow;
    }

    public void setArrow(Integer arrow) {
        this.arrow = arrow;
    }

    public List<Integer> getSquares() {
        return squares;
    }

    public void setSquares(List<Integer> squares) {
        this.squares = squares;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
