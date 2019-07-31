package sparsearray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException {

        //创建一个11*11的棋盘
        //1代表黑子 2代表白子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2]=1;
        chessArray1[2][3]=2;
        chessArray1[4][5]=2;

        //输出该棋盘
        System.out.println("原始棋盘");
        for (int[] rows : chessArray1) {
            for (int row : rows) {
                System.out.printf("%d\t",row);
            }
            System.out.println();
        }

        System.out.println("=============正在向磁盘写入二维数组==================");
        //将该二维数组写入磁盘中
        File file = new File("chessArray1.txt");
        FileWriter out = new FileWriter(file);
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11; j++) {
                out.write(chessArray1[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();
        System.out.println("================写入结束=============================");


        System.out.println("=========将磁盘中的二维数组读出=======================");

        int[][] chessArray3 = new int[11][11];
        //将该二维数组从文件中读取出来
        BufferedReader in = new BufferedReader(new FileReader(file));
        int row = 0;
        String line;
        while((line=in.readLine())!=null){
            String[] temp = line.split("\t");
            for (int i = 0; i <11 ; i++) {
                chessArray3[row][i]= Integer.parseInt(temp[i]);
            }
            row++;
        }
        in.close();
        System.out.println("===============读出结束==============================");

        //将该二维数组存入稀疏数组中
        //1.遍历二维数组获得所有的有效数据(非零数据)
        int sum = 0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (chessArray3[i][j]!=0){
                  sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        //2.新建稀疏数组
        int sparsearray[][] = new int[sum+1][3];
        sparsearray[0][0]=11;
        sparsearray[0][1]=11;
        sparsearray[0][2]=sum;

        //3.遍历二维数组并把有效值存入稀疏数组
        int count=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (chessArray3[i][j]!=0){
                    count++;
                    sparsearray[count][0]=i;
                    sparsearray[count][1]=j;
                    sparsearray[count][2]=chessArray3[i][j];
                }
            }
        }

        //将该稀疏数组写入磁盘
        System.out.println("=====将该稀疏数组写入磁盘=====");
        File file1 = new File("sparseArray.txt");
        FileWriter out2 = new FileWriter(file1);
        for (int i = 0; i <sparsearray.length ; i++) {
            for (int j = 0; j <3 ; j++) {
                out2.write(sparsearray[i][j]+"\t");
            }
            out2.write("\r\n");
        }
        out2.close();
        System.out.println("===========写入结束==============");

        //4.输出该稀疏数组
        System.out.println("转换后的稀疏数组");
        System.out.printf("row\tcol\tval\n");
        for (int i = 0; i <sparsearray.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparsearray[i][0],sparsearray[i][1],sparsearray[i][2]);
        }



        //将稀疏数组转成一般的二维数组
        //1.读取第一行创建二位数组
        //2.遍历数组获取值
        int chessArray2[][]=new int[sparsearray[0][0]][sparsearray[0][1]];
        for (int i = 1; i <sparsearray.length ; i++) {
            chessArray2[sparsearray[i][0]][sparsearray[i][1]]=sparsearray[i][2];
        }

        //输出该棋盘
        System.out.println("恢复后的二维数组");


        for (int[] ints : chessArray2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    }
}
