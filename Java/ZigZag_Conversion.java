public class ZigZag_Conversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    /**
     * 思路：想象一个箭头，箭头每次走的时候，检测之前的方向，检测前进方向是否可以走，顺着之前的方向走，往下如果不行往右上，右上的状态下
     * 上面不可走，方向往下……
     *
     * @param s
     * @param numRows
     * @return
     */
    private final static int DOWN = 1;
    private final static int RIGHTUP = 2;

    public static String convert(String s, int numRows) {

        //把字符串摆成之字形
//        String[] map = new String[numRows];
        char[][] map = new char[numRows][];
        //初始化地图
        for (int i = 0; i < numRows; i++) {
            map[i]= new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                map[i][j]='-';
            }
        }
        int currentChar = 0;
        //初始坐标
        int xAxis = 1;
        int yAxis = 0;
        //初始箭头往下走
        int arrorPosi = DOWN;

        while (currentChar < s.length()) {
            //当len==0的时候所有字符被放置完毕 箭头也走到这个时候
            //先顺着原理的方向看能不能走
            if (arrorPosi == DOWN) {
                //往下走的情况下判断是否越界  y轴++
                if (yAxis + 1 > numRows) {
                    //越界 需要将方向改为右上
                    arrorPosi = RIGHTUP;
                    //设置下一个值的位置
                    xAxis++;
                    yAxis--;
                    //设置下一个值
                    map[yAxis - 1][xAxis - 1]=s.charAt(currentChar);
                    currentChar++;
                    continue;
                }
                //没有越界 方向不变
                yAxis++;
                map[yAxis - 1][xAxis - 1]=s.charAt(currentChar);
                currentChar++;
            } else if (arrorPosi == RIGHTUP) {
                //往右上走的情况下判断是否越界  y轴--
                if (yAxis - 1 < 1) {
                    //越界 需要将方向改为下
                    arrorPosi = DOWN;
                    //设置下一个值的位置
                    yAxis++;
                    //设置下一个值
                    map[yAxis - 1][xAxis - 1]=s.charAt(currentChar);
                    currentChar++;
                    continue;
                }
                //没有越界
                xAxis++;
                yAxis--;
                map[yAxis - 1][xAxis - 1]=s.charAt(currentChar);
                currentChar++;
            }
        }

        //返回字符串
        String out = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if(map[i][j]!='-') out += map[i][j];
            }
        }

    return out;
    }
}

