import javax.swing.*;

public class Square {
    JButton button;
    private int numberOfBombs;
    private boolean bomb;
    public Square(boolean bomb) {
        button = new JButton();
        this.numberOfBombs=0;
        this.bomb=bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public void setNumberOfBombs(int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
    }

    public boolean isBomb() {
        return bomb;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }
}
