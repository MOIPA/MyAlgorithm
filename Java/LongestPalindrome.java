public class LongestPalindrome {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abaca"));

    }

    /**
     * 找出最长子回文字符串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String temp = "";
        int len=0;
        String longestStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                temp=s.substring(i,j+1);
                if (judge(temp)){
                    if(temp.length()>len){
                        longestStr=temp;
                        len=temp.length();
                    }
                }
            }
        }
        return longestStr;
    }

    /**
     * 判断是否是回文字符串
     *
     * @param temp
     * @return
     */
    private static boolean judge(String temp) {
        int len = temp.length();
        for (int i = 0; i <= len / 2-1; i++) {
            if (temp.charAt(i) != temp.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}


