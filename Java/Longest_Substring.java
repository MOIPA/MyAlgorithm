import java.util.Stack;

public class Longest_Substring {
    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution2 {
    /**
     * i和j指向左右边界的字符，j往右走，每走一个，进来循环检查一遍重不重复，不重复最大值看看能不能设j-i+1
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int res;
        for (int i = 0; i < s.length(); i++) {
            for(int j=i+1;j<s.length();j++){
                res = checkRepeat(s, i, j);
                //-1 说明这次已经有重复的了 下个进来还是重复
                if(res==-1)break;
                maxLength = maxLength<res?res:maxLength;
            }
        }
        return maxLength;
    }

    private int checkRepeat(String s, int l, int r) {
        //检测 r指向的 因为r是最新进来的
        for (int i = l; i < r; i++) {
            if(s.charAt(i)==s.charAt(r)) return -1;
        }
        return r-l+1;
    }
}