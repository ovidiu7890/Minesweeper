public class Matrix {
    Square[][]matrix;
    private int nrOfRows;
    private int nrOfCols;
    public Matrix(){
        this.nrOfRows = 10;
        this.nrOfCols = 10;
        this.matrix = new Square[nrOfRows][nrOfCols];
    }

    public int getNrOfRows() {
        return nrOfRows;
    }

    public int getNrOfCols() {
        return nrOfCols;
    }

    public void setNrOfRows(int nrOfRows) {
        this.nrOfRows = nrOfRows;
    }

    public void setNrOfCols(int nrOfCols) {
        this.nrOfCols = nrOfCols;
    }

    public void generateRandomMatrix(){
        for(int i=0;i<nrOfRows;i++){
            for(int j=0;j<nrOfCols;j++){
                this.matrix[i][j]=new Square(false);
            }
        }
        for(int i=0;i<=10;i++){
            int x=(int)(Math.random()*9);
            int y=(int)(Math.random()*9);
            if(!this.matrix[x][y].isBomb()){
                this.matrix[x][y].setBomb(true);
            }
        }
    }
    public void calculateNrOfBombs(){
        int []x={1, 1, 1, 0, 0, -1, -1, -1};
        int []y={1, 0, -1, 1, -1, 1, 0, -1};
        int numberCalc=0;
        for(int i=0;i<nrOfRows;i++){
            for(int j=0;j<nrOfCols;j++){
                numberCalc=0;
                for(int k=0;k<x.length;k++){
                    if(i+x[k]>=0 && i+x[k]<this.nrOfCols){
                        if(j+y[k]>=0 && j+y[k]<this.nrOfRows){
                            if(this.matrix[i+x[k]][j+y[k]].isBomb()){
                                numberCalc++;
                            }
                        }
                    }
                }
                this.matrix[i][j].setNumberOfBombs(numberCalc);
            }
        }
    }
}
