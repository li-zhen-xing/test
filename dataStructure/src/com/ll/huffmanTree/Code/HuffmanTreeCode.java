package com.ll.huffmanTree.Code;

import java.io.*;
import java.util.*;


/**功能：利用赫夫曼编码来解决传输数据的长度能压缩百分之六十
 * 实现：先把字符串进行解析，解析成为单个字符和出现的次数也就是每一颗二叉树的权值，再根据这个特性构建出一颗赫夫曼二叉树，
 * 每一个叶子节点都代表一个数据，然后利用根节点到每个叶子节点的路径不同（叶子节点再根节点的左边就是0右边就是1来形成一串0101的二进制编码）
 * 来分别进行编码和解析
 * 值得注意的是赫夫曼编码会出现不是每棵树的结构都是一样的但是最终的权值肯定是一样的，因为如果出现权值相同的二叉树那么它的排序方式可能不同这样就构成了
 * 可能出现结构不同的赫夫曼二叉树
 * @ClassName HuffmanTreeCode
 * @Description
 * @Author 李振兴
 * @Date 2020/9/29 15:22
 **/
public class HuffmanTreeCode {
    public static void main(String[] args) {
        //存在bug因为最后一位没处理好，bug原因再下面，但是现在暂时未解决
        //还有一个疑问就是为什么再解码的时候会把赫夫曼map传入解码的方法中，这个map是由于编码而产生的所以当你解码时你不能利用编码产生的数据来解码，而是直接根据编码返回的编码数组，
        //如果这样又需要构建赫夫曼树这是一个有趣的问题。
        String a="i like like like java do you like a java";

        //获取赫夫曼树的根节点
        Node root = creatTree(getNodeList(tobytes(a)));
       //编码
        byte[] zip = huffmanZip(tobytes(a));
        //解码
        byte[] decode = decode(getCodes(root),zip );

        System.out.println(new String(decode));
        //所有编码压缩步骤都在次方法中
        /*for (byte by:zip) {
            System.out.println(by);
        }*/

        //测试压缩文件
/*        String srcFile="g://zip/lala.txt";
        String dstFilt="g://zip/lala.zip";
        zipFile(srcFile,dstFilt);
        System.out.println("压缩文件成功");*/

        //测试解压文件
/*        String zipFile="g://zip/lala.zip";
        String dstFilt="g://zip/lala2.txt";
        unZipFile(zipFile,dstFilt);
        System.out.println("解压文件成功");*/
    }

    /**
     * 把传入的字符串转变为字节数组
     * @param str
     * @return
     */
    public static byte[] tobytes(String str){
        byte[] bytes = str.getBytes();
        return bytes;
    }

    /**
     * 功能：把传入的字符数组创建成node对象然后返回对象集合
     * map的值就是要加密的字符，value就是字符出现的次数
     * @param bytes
     * @return
     */
    public static List<Node> getNodeList(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        //定义一个map用来接受遍历的字节数组
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte by:bytes) {
            //先获取这个字节看map中又没有存储，没有存储那就value为1，存储了的话那就value在加一
            Integer count =map.get(by);
            //判断又没有存储过
            if (count==null){
                map.put(by,1);
            }else {
                //存储过就给他的value再加一即可
                map.put(by,count+1);
            }
        }
        //遍历map，获取map的key和value创建node对象
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        //返回集合对象
        return nodes;
    }

    /**
     * 功能：通过传入的对象集合创建一颗赫夫曼树
     * @param list
     * @return 返回赫夫曼树的根节点
     */
    public static Node creatTree(List<Node> list){
        while (list.size()>1){
            Collections.sort(list);
            Node leftNode = list.get(0);
            Node rightNode=list.get(1);
            //父节点为null是因为字符全是存储在叶子节点中的，创建父节点的原因也只是为了构建出一颗树。
            Node parent = new Node(null,leftNode.getWeight() + rightNode.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            list.remove(rightNode);
            list.remove(leftNode);
            list.add(parent);
        }
        return list.get(0);
    }


    //将赫夫曼编码存在map中
    static Map<Byte,String> hhuffmanCodes=new HashMap<Byte, String>();
    //用来接受叶子节点的路径
    static StringBuilder stringBuilder=new StringBuilder();
    /**
     *  功能：利用map存储每个节点和她的节点路径。
     *  实现：遍历每一个节点，如果是非叶子节点则继续遍历且它的路径同时加入到string build中
     *  当遍历到节点时把string builder作为value节点的date作为key存入map中
     * @param node 要处理的节点
     * @param code 节点的路径
     * @param stringBuilder 用来接受节点路径
     */
    public static void getCodes(Node node,String code,StringBuilder stringBuilder){
        //创建一个string builder用来接受还未完成的路径
        StringBuilder stringBuilder1=new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node!=null) {
            //如果时非叶子节点它的打他就为null那就继续遍历且存储地址
            if (node.getDate() == null) {
                //往左边遍历然后地址加0
                getCodes(node.getLeft(), "0", stringBuilder1);
                //往右边遍历然后地址加1
                getCodes(node.getRight(), "1", stringBuilder1);
            } else {
                //此时代表找到了叶子节点，那就把叶子节的date作为key路径作为value放入到map中
                hhuffmanCodes.put(node.getDate(), stringBuilder1.toString());
            }
        }
    }

    /**
     *  重写方法实现
     * @param node
     * @return
     */
    public static Map<Byte,String> getCodes(Node node){
        if (node!=null){
            getCodes(node.getLeft(),"0",stringBuilder);
            getCodes(node.getRight(),"1",stringBuilder);
            return hhuffmanCodes;
        }else {
            return null;
        }
    }

    //编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码表来返回一个赫夫曼编码压缩后的byte[]

    /**
     *功能：传入将赫夫曼编码和原始的字节数组，然后根据赫夫曼编码map依次取出路径然后拼接成一个路径字符串
     * 再对路径字符串进行8位8位的压缩，压缩成一个新的字节数组，数组里面存储的是路径字节
     * 因为8个01代表一个字节，所以每次存储8个数据 1byte=8bit
     * @param bytes 原始的字符串对应的byte[]
     * @param hhuffmanCodes 生成的赫夫曼编码map
     * @return  返回赫夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> hhuffmanCodes){
        //利用huffmancodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder=new StringBuilder();
        //遍历字节数组
        for (byte by:bytes) {
            stringBuilder.append(hhuffmanCodes.get(by));
        }

        //System.out.println(stringBuilder.toString());

        //将10101000101111111.....转成byte[]
        //定义byte长度
        int len;
        //如果刚好整除那就可以
        if ((stringBuilder.length()%8==0)){
            len=stringBuilder.length()/8;
        } else {//否则再加1
            len =stringBuilder.length()/8+1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeByte=new byte[len];
        //记录是第几个byte
        int index=0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {//因为每8位对应一个byte所以步长+8，相当于每次存8个数字
            String strByte;
            if (i+8>stringBuilder.length()){
                //如果长度大于lenght则从第i个位置取到最后即可
                //因为最后可能不是刚好是8个所以直接返回即可
                strByte=stringBuilder.substring(i);
            }else {
                strByte=stringBuilder.substring(i,i+8);
            }
            //将stryByte转成一个byte放入到字节数组中，Integer.parseInt(strByte,2)此方法是按照二进制的方式转换的
            huffmanCodeByte[index]= (byte) Integer.parseInt(strByte,2);
            //数组下标加一
            index++;
        }
        //返回压缩后的字符数组
        return huffmanCodeByte;
    }

    //定义一个新的方法用来整合所有的方法
    private static byte[]huffmanZip( byte[] bytes){
        //第二步：根据字符数组创建对应的Node对象，把数据出现的次数，数据值存储在对象中
        List<Node> nodeList = getNodeList(bytes);
        //第四步：将创建好的node对象构建成一颗赫夫曼树
        Node huffmanRoot = creatTree(nodeList);
        //第五步：将赫夫曼树遍历，将所有叶子节点的data和weight存入map中，data就是字节值（将每一个数都按照字节来存储），weight就是数据出现的次数
        Map<Byte,String> huffmancode=getCodes(huffmanRoot);
        //第六步：将原始字符的路径从map中取出构建成一个路径字符串，然后再将字符路径串压缩成为一个字节数组（因为路径是由01二进制组成的）
        byte[] zip = zip(bytes, huffmancode);
        //将压缩好的字节编码数组返回
        return zip;
    }

    //定义一个将byte转为二进制的方法
    /**
     * 有个bug如果最后那个数在map中对应的是0001那么他转成字节的话就是1但是如果字节转成二进制的话那就麻烦了例如它可以转成01、001、0001会造成数据的丢失
     * @param flag 如果是最后一位那就直接存入即可，因为最后一位可能没有八个数字
     * @param by 要转换的字节
     * @return 返回转换好的二进制补码字符串
     */
    private static String byteToBitString(Boolean flag, byte by) {
        //定义一个临时变量来接受byte，因为integer有将数字转为补码的方法，但是他转的是int类型的，int类型对应是4个字节（32位），而bit类型是8位
        int tmp = by;
        if (flag) {
            //如果是正数的话那么他的补码直接就是（拿3来说）11所以他就是两个数字就需要取位或
            //这里取或的原因是256对应的二进制是100000000所以直接取或即可，因为by是bit他是8个位而256刚好后8位都是0所以取或即可
            tmp|= 256;
        }
        String str = Integer.toBinaryString(tmp);//转位二进制补码
        if (flag) {
            //所以如果直接转的话int会出现一个32位的二进制数，所以必须丢弃前面的28个数，因为0001对应的integer是00000000000000000000001，0太多没有写全所以只需要后几位就可以了
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //编写一个方法完成对压缩数据的解码
    private static byte[] decode(Map<Byte,String> hhuffmanCodes,byte[] huffmanBytes){
        //1.先得到huffmanBytes对应的字符串，形式1010011101
        StringBuilder stringBuilder=new StringBuilder();
        //2.将bytes转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            //判断是否是最后一个字节
            Boolean flag=(i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        //3.把赫夫曼编码表进行反转，key为二进制字符串value为对应存储的byte字节
        //因为可以根据传入的二进制进行匹配，匹配到就把byte拿出
        Map<String,Byte> map=new HashMap<String, Byte>();
        for (Map.Entry<Byte,String> entry:hhuffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        //创建集合存放byte(这个byte就是结果)
        List<Byte> byteList=new ArrayList<>();
        //遍历字符串，匹配map中的key
        for (int i = 0; i < stringBuilder.length();) {
            //如果没有匹配到就一直匹配，匹配到了就退出重新匹配
            Boolean flag=true;
            //匹配变量。先是从第i个开始匹配然后匹配i到第i+1个没匹配到就还继续
            int count =1;
            //定义接受匹配到后，真实的数据
            Byte b=null;
            while (flag){
                //先是从第i个开始匹配然后匹配i到第i+1个没匹配到就还继续
                String key=stringBuilder.substring(i,i+count);
                //查看是否匹配到，匹配到了他就有值，没匹配到就没有值
                b=map.get(key);
                if (b==null){
                    //说明没有匹配到就继续往下匹配
                    count++;
                }else {
                    //说明匹配到了就退出这个循环开始下一个匹配
                    flag=false;
                }
            }
            //把匹配到的值加入到list中
            byteList.add(b);
            //因为匹配到了一个值所以下次匹配开始的位置是从i+count这个下标开始的
            i+=count;
        }
        //再将list装为byte数组
        byte[] bytes = new byte[byteList.size()];
        int i=0;
        for (Byte bb:byteList) {
            bytes[i]=bb;
            i++;
        }
        //返回解码好的字节数组
        return bytes;
    }

    /**
     *
     * @param srcFile 传入压缩文件的全路进
     * @param dstFile 压缩胡放到哪个目录
     */
    public static void zipFile(String srcFile,String dstFile){
        //创建输出流
        OutputStream os=null;
        ObjectOutputStream oos =null;
        //创建文件的输入流
        FileInputStream is=null;
        try {
            //创建文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //之间对源文件压缩
            byte[] huffmanBytes=huffmanZip(b);
            //创建文件的输出流，存放压缩文件
            os=new FileOutputStream(dstFile);
            //拆功能键一个和文件输出流关联的objectOutputStream
            oos=new ObjectOutputStream(os);
            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们以对象流的方式写入赫夫曼编码，是为了以后我们恢复文件时使用
            oos.writeObject(huffmanBytes);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到那个目录
     */
    public static void unZipFile(String zipFile,String dstFile){
        //定义文件输入流
        InputStream is=null;
        //定义一个对象输入流
        ObjectInputStream ois=null;
        //定义文件的输出流
        OutputStream os=null;
        try {
            //创建文件输入流
            is=new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois=new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes=(byte[])ois.readObject();
            //读取赫夫曼树
            Map<Byte,String> hhuffmanCodes=(Map<Byte, String>)ois.readObject();
            //解码
            byte[] bytes=decode(hhuffmanCodes,huffmanBytes);
            //将bytes数组写入到目标文件
            os=new FileOutputStream(dstFile);
            //写入到dstFile文件
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


/*
此类用来存储编码的数据，一个节点就代表一个字符，权重代表字符的次数
 */
class Node implements Comparable<Node>{
    //权重出现的次数
    private int weight;
    //存储的数据
    private Byte date;
    private Node left;
    private Node right;

    public Node(Byte date, int weight) {
        this.weight = weight;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", date=" + date +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Byte getDate() {
        return date;
    }

    public void setDate(byte date) {
        this.date = date;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    //根据权值来排序，从小到达排序
    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }
}
