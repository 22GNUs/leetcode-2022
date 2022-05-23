import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {

  /**
   * 贪心实现，部分case不能满足，比如 [1,7,10], 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到
   *
   * @param coins 总硬币
   * @param amount 面值
   * @return 需要的硬币数量
   */
  public int coinChange(int[] coins, int amount) {
    // 先从大到小排序，方便贪心
    coins =
        IntStream.of(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    return coinChangeHelper(coins, amount);
  }

  private static int coinChangeHelper(int[] coins, int amount) {
    if (coins.length == 0) {
      return -1;
    }

    // 当前使用的硬币
    int currentCoin = coins[0];

    // 当前硬币的使用数量
    int currentCoinUsingNumber = amount / currentCoin;

    // 当前剩余的零钱
    int restAmount = amount - currentCoin * currentCoinUsingNumber;
    if (restAmount == 0) {
      return currentCoinUsingNumber;
    }

    // 剩余其他硬币的使用数量
    int restCoinUsingNumber = -1;
    // 剩余的硬币
    int[] restCoins = Arrays.copyOfRange(coins, 1, coins.length);

    while (currentCoinUsingNumber >= 0) {
      // 循环尝试用剩余硬币来凑零钱
      restCoinUsingNumber = coinChangeHelper(restCoins, restAmount);
      if (restCoinUsingNumber != -1) {
        // 剩余零钱能凑出，返回当前数量 + 剩余零钱的数量
        return currentCoinUsingNumber + restCoinUsingNumber;
      }
      // 剩余零钱凑不出，则尝试回朔
      currentCoinUsingNumber--;
      // 重新计算剩余待凑零钱数量，并循环回朔
      restAmount = amount - currentCoin * currentCoinUsingNumber;
    }

    return -1;
  }
}
// @lc code=end
