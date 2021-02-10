package golry;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 郑祥
 * @date 2021-02-10
 */
public class GloryOfKings {

    /**
     * 点券数值
     */
    public static int[] stamps = {10, 60, 180, 300, 680, 1180, 1980, 3480, 6480};

    public static void main(String[] args) {
        // 通过减去余额计算出实际需要购买的点券数量
        int requiredMoney = countRequiredMoney();
        // 根据贪心算法得到如何购买的点券集合
        List<Integer> neededStamps = getNeededStamps(requiredMoney);
        // 打印所需点券到控制台
        print(neededStamps, requiredMoney);
    }

    private static void print(List<Integer> neededStamps, int money) {
        System.out.println("大明白，您最少需花 " + neededStamps.size() + " 次可刚好凑到" + money + "点券");
        System.out.println("您只需要这样购买点券：");
        Map result = new HashMap<>(5);
        neededStamps.forEach(item -> {
            long count = neededStamps.stream().filter(item::equals).count();
            result.put(item, count);
        });
        result.forEach((k, v) -> {
            System.out.println(k + " 点券购买数量: " + v + "个");
        });
    }

    /**
     * 依据贪心算法计算需要购买的点券集合
     *
     * @param requiredMoney 所需点券数量
     * @return 需要购买的点券集合
     */
    private static List<Integer> getNeededStamps(int requiredMoney) {
        ArrayList<Integer> neededStamps = new ArrayList<>();
        while (requiredMoney > 0) {
            // 找到可以购买的点券数组中数额最大的但是不超过money点券数
            int maxCoupon = maxCoupon(requiredMoney);
            requiredMoney -= maxCoupon;
            neededStamps.add(maxCoupon);
        }
        return neededStamps;
    }

    private static int maxCoupon(int requiredMoney) {
        // 默认为10 - 最小点券数额
        int maxCoupon = 10;
        for (int m : stamps) {
            if (requiredMoney >= m) {
                maxCoupon = m;
            }
        }
        return maxCoupon;
    }

    /**
     * 计算需要购买的点券数量
     *
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
