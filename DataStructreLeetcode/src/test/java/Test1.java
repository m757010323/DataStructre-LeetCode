import org.junit.Test;

import java.io.*;

public class Test1 {

    public Test1() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        int test[][] = new int[4][4];
        test[1][1]=1;
        test[2][2]=2;
        test[3][3]=3;
        test[0][0]=4;

//        //输出该二维数组
//        for (int[] ints : test) {
//            for (int anInt : ints) {
//                System.out.printf("%d\t",anInt);
//            }
//            System.out.println();
//        }

        File file1 = new File("a.txt");
        FileWriter fr = new FileWriter(file1);

        for (int[] ints : test) {
            for (int anInt : ints) {
                Integer i = anInt;
                fr.write(i.toString());
            }
            fr.write("\r\n");
        }
        fr.close();
    }



    @Test
    public void test2() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("b.txt"));
        byte b=2;
        fos.write(b);
        fos.close();
    }
}
