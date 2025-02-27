public class Main {
    public static void main(String[] args) {
        Matrix M = new Matrix();
        M.generateRandomMatrix();
        M.calculateNrOfBombs();
        for(int i=0;i<M.getNrOfCols();i++){
            for(int j=0;j<M.getNrOfRows();j++){
                if(M.matrix[i][j].isBomb()){
                    System.out.print("X ");
                }
                else{
                    System.out.print(M.matrix[i][j].getNumberOfBombs()+" ");
                }
            }
            System.out.println();
        }
    }
}
