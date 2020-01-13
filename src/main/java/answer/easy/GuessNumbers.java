package answer.easy;

/* *
 * @Author Junhui Chen txcjhwing@gmail.com
 * @Description LCP 1. 猜数字
 * @Date 13:49 2020/1/13
 * @Param 
 * @return 
 **/
public class GuessNumbers {
    // 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。
    // 他们一共进行三次这个游戏，请返回 小A 猜对了几次？
    // 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
    public int game(int[] guess, int[] answer) {
        int result = 0;
        for(int i = 0;i < guess.length; i++){
            if(answer[i] == guess[i])
                result++;
        }
        return result;
    }
}
