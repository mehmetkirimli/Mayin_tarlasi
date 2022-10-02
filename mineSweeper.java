import java.util.Scanner;
import java.util.Arrays;

public class mineSweeper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Oyun ekrani kac satirdan olussun ?  ");
        int satir = input.nextInt();

        System.out.println("Oyun ekrani kac sutundan olussun ?  ");
        int sutun = input.nextInt();

        int[][] map = new int[satir][sutun];
        int[][] mayin = new int[satir+2][sutun+2];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
                mayin[i][j] = 0;

            }
        }
        System.out.println(" MAYIN TARLASI  :) ");


        // eleman sayisini hesaplamamiz lazim once

        int eleman = satir * sutun;
        int mayin_sayisi = eleman / 4;

        int row;
        int col;
        int count = 0;

        while (count < mayin_sayisi) {
            row = (int) (Math.random() * satir+1); // burada mayin tarlasınin map e göre 1 er buyuk tanımladım koselerdeki sorunlardan kurtulmak icin
            col = (int) (Math.random() * sutun+1);

            if (mayin[row][col] != 1) {
                mayin[row][col] = 1;
                count++;
            }


        }
        show2(mayin);
       //show(mayin);
        show(map);

        boolean choosen = false;
        int winn = 1 ;

        while (!choosen ) {
            System.out.print("Satir sec : ");
            int i = input.nextInt();


            //System.out.println();//if (1<=i && i<=satir)

            System.out.print("Sutun sec : ");
            int j = input.nextInt();

            if ((0 <= i && i < satir) && (0 <= j && j < sutun))
            {

                if (mayin[i + 1][j + 1] == 1)
                {
                    choosen = true;
                    show(mayin);
                    System.out.println("  :(  GAMEE OVERR  :(   ");
                }
                else
                {
                    map[i][j] = (
                            mayin[i][j] +
                                    mayin[i][j + 1] +
                                    mayin[i][j + 2] +
                                    mayin[i + 1][j] +
                                    mayin[i + 1][j + 2] +
                                    mayin[i + 2][j] +
                                    mayin[i + 2][j + 1] +
                                    mayin[i + 2][j + 2]

                    );
                    winn++;

                }
                if (winn == (eleman - mayin_sayisi + 1))
                {
                    System.out.println("TEBRIKLEERRR YOU ARE WINN !! ");
                    show2(mayin);
                    break;
                }

                show(map);
            }

            else
            {
                System.out.println("Yanlis tuslama yaptiniz , Tekrar Deneyiniz : ");

            }
        }

        }





    public static void show(int[][] map)
    {
        System.out.println();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "    ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(" \n  GAME \n ");
    }

    public static void show2(int[][] map)
    {
        System.out.println();

        for (int i = 1; i < map.length-1; i++) {
            for (int j = 1; j < map[i].length-1; j++) {
                System.out.print(map[i][j] + "    ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(" \n  GAME \n ");
    }

}