import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Minesweeper");

        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));
        Matrix M=new Matrix();
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
        for (int i = 0; i < M.getNrOfRows(); i++) {
            for (int j = 0; j < M.getNrOfCols(); j++) {
                int finalI = i;
                int finalJ = j;
                M.matrix[i][j].button.addActionListener(e-> {

                    M.matrix[finalI][finalJ].setClicked(true);
                    if(!M.matrix[finalI][finalJ].isBomb()){
                        M.matrix[finalI][finalJ].button.setText(M.matrix[finalI][finalJ].getNumberOfBombs()+"");
                        System.out.println(M.matrix[finalI][finalJ].getNumberOfBombs());
                        M.matrix[finalI][finalJ].button.setBackground(Color.WHITE);
                        M.matrix[finalI][finalJ].button.setForeground(Color.BLACK);
                        if(M.matrix[finalI][finalJ].getNumberOfBombs()==0){
                            Queue<int[]> q= new LinkedList<>();
                            q.add(new int[]{finalI,finalJ});
                            int []x={1, 1, 1, 0, 0, -1, -1, -1};
                            int []y={1, 0, -1, 1, -1, 1, 0, -1};
                            while(!q.isEmpty()){
                                int []pair=q.poll();
                                if(!M.matrix[pair[0]][pair[1]].isClicked()){
                                    M.matrix[pair[0]][pair[1]].setClicked(true);
                                    M.matrix[pair[0]][pair[1]].button.setText(M.matrix[finalI][finalJ].getNumberOfBombs()+"");
                                    M.matrix[pair[0]][pair[1]].button.setBackground(Color.WHITE);
                                    M.matrix[pair[0]][pair[1]].button.setForeground(Color.BLACK);

                                }
                                for(int k=0;k<x.length;k++){
                                    if(pair[0]+x[k]>=0 && pair[0]+x[k]<=9){
                                        if(pair[1]+y[k]>=0 && pair[1]+y[k]<=9){
                                            if(M.matrix[pair[0]+x[k]][pair[1]+y[k]].getNumberOfBombs()==0 && !M.matrix[pair[0]+x[k]][pair[1]+y[k]].isClicked()){
                                                q.add(new int[]{pair[0]+x[k],pair[1]+y[k]});
                                            }
                                            else if(M.matrix[pair[0]+x[k]][pair[1]+y[k]].getNumberOfBombs()!=0 && !M.matrix[pair[0]+x[k]][pair[1]+y[k]].isClicked()){
                                                M.matrix[pair[0]+x[k]][pair[1]+y[k]].setClicked(true);
                                                M.matrix[pair[0]+x[k]][pair[1]+y[k]].button.setText(M.matrix[pair[0]+x[k]][pair[1]+y[k]].getNumberOfBombs()+"");
                                                M.matrix[pair[0]+x[k]][pair[1]+y[k]].button.setBackground(Color.WHITE);
                                                M.matrix[pair[0]+x[k]][pair[1]+y[k]].button.setForeground(Color.BLACK);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        M.matrix[finalI][finalJ].button.setBackground(Color.RED);
                        JOptionPane.showMessageDialog(frame,M.matrix[finalI][finalJ]);
                    }
                });
                panel.add(M.matrix[i][j].button);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
