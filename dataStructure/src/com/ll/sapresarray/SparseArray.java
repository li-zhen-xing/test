package com.ll.sapresarray;

/**
 * @ClassName SparseArray
 * @Description
 * @Author 李振兴
 * @Date 2020/9/10 23:43
 **/
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0表示没有棋子1表示黑子
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][5]=2;

        System.out.println("原始二维数组如下");
        for (int[] row:chessArr1) {
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组的思路
        //1.先便利二维数组得到非0数据的个数
        int sum=0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }

        //2.船舰对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        int count=0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组如下");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();


        //将稀疏数组恢复成原始的二维数组
        //1.先读取稀疏数组的第一行
        int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.再读取稀疏数组后几行的数据，从第二行开始，并赋值给原始的二维数组
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        System.out.println("恢复后的二维数组");
        for (int[] row:chessArr2) {
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
