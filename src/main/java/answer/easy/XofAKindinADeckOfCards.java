package answer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 */
public class XofAKindinADeckOfCards {
    // 此题采用hashmap不合适，浪费巨多时间，不如直接10000的数组存，若未知n可能需要hashmap
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : deck) {
            if (map.containsKey(i)) {
                int num = map.get(i);
                map.replace(i, ++num);
            } else
                map.put(i, 1);
        }


        // 所有数的最大公因数大于1, 所以可两两一个一个求
        int g = -1;
        for (int i : map.values()) {
            if (g == -1) {
                g = i;
                continue;
            }
            g = GCD(g, i);
        }

        return g > 1;
    }

    public int GCD(int m, int n) {
        while (m != n) {
            if (m > n)
                m -= n;
            else
                n -= m;
        }
        return m;
    }

    // 内存消耗较小的一种gcd算法
    public int gcd(int x, int y) {
        return x == 0 ? y : GCD(y % x, x);
    }
}
