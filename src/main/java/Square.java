import javax.swing.*;

public class Square {
    JButton button;
    private int numberOfBombs;
    private boolean bomb;
    private boolean clicked;
    public Square(boolean bomb) {
        button = new JButton();
        this.numberOfBombs=0;
        this.bomb=bomb;
        this.clicked=false;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
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
