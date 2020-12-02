package com.ll.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Graph
 * @Description
 * @Author 李振兴
 * @Date 2020/12/2 6:27
 **/
public class Graph {

    public static void main(String[] args) {
        int n=5;
        String vertexValue[] ={"A","B","C","D","E"};
        //创建图对象
        Graph graph=new Graph(n);
        //循环添加顶点
        for (String str :vertexValue) {
            graph.insertVertex(str);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //graph.showGraph();

        graph.dfs(0);
    }


    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    //表示边的shumu
    private int numOfEdges;
    //记录某个节点是否被访问
    private boolean[] isVisited;
    //构造器
    public Graph (int n){
        //初始化矩阵和vertexList
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    /**
     * 添加边
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i(下标)对于的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getweight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] a:edges) {
            System.out.println(Arrays.toString(a));
        }
    }

    //得到index下标节点的第一个邻节点的下标w
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //得到下标v1节点的第v2个邻节点的下一个邻节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历算法   有点类似于前序遍历
    public void dfs(boolean[] isVisited,int i){
        //访问该节点，输出节点
        System.out.print(getValueByIndex(i)+"-->");
        //设置节点访问过
        isVisited[i]=true;
        //查找节点i的第一个邻节点
        int w = getFirstNeighbor(i);
        while (w!=-1){
            //如果节点没有被访问过则进行递归处理
            if(!isVisited[w]){
                //进行递归
                dfs(isVisited,w);
            }
            //节点被访问过寻找这个节点的下一个邻节点，找不到就跳出此次递归，返回上一层递归根据上一次递归的又下一个节点来继续执行。
            w=getNextNeighbor(i,w);
        }
    }
    public void dfs(int n){
        dfs(isVisited,n);
    }
}
