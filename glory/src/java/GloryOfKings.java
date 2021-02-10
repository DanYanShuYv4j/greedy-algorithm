package java;

import java.util.List;
import java.util.Scanner;

/**
 * @author 郑祥
 * @date 2021-02-10
 */
public class GloryOfKings {
    public static int[] stamps = {10,60,180,300,680,1180,1980,3480,6480};
    public static void main(String[] args) {
        //通过减去余额计算出实际需要购买的点券数量
        int requiredMoney = countRequiredMoney();
        // 根据贪心算法得到如何购买的点券集合
        List<Integer> neededStamps = getNeededStamps(requiredMoney);
    }

    /**
     * 依据贪心算法计算需要购买的点券集合
     * @param requiredMoney 所需点券数量
     * @return 需要购买的点券集合
     */
    private static List<Integer> getNeededStamps(int requiredMoney) {
        return null;
    }

    /**
     * 计算需要购买的点券数量
     * @return 所需点券数量
     */
    private static int countRequiredMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您要购买皮肤的点券价格：");
        int price = input.nextInt();
        System.out.print("请输入您的账户余额：");
        int balance = input.nextInt();
        // 实际需要购买的点券
        return price - balance;
    }

}
