import java.util.Scanner;

public class Encryption {
    /**
     * 字符串加密方法
     * 
     * @param number
     * @return 加密后的整数
     */
    public static int encryption(int number) {
        if (number >= 60000 || number <= 9) {
            return number;
        }
        int length = String.valueOf(number).length(); // 正整数长度
        int result = 0; // 加密后的整数结果
        /**
         * 执行互换操作的两个位数，其10的幂次之和为(正整数长度 - 2) 
         * 如58313 ，其个位与"次"高位，分别对应10的0次方和10的3次方
         *             其十位与"次次"高位，分别对应10的1次方和10的2次方
         */
        int j = length - 2; 
        while (number > 9) {// 当正整数整除10后的结果不是个位数
            int temp = (number % 10 + 6) % 10;
            result = result + temp * (int) Math.pow(10, j);
            number = number / 10;
            --j;
        }
        result = result + number * (int) Math.pow(10, length - 1);
        return result;
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            Integer src = cin.nextInt();
            System.out.println(encryption(src));
        }
    }
}
