package leetcode.easy;

import java.util.HashMap;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberBoomerangs {

    public static void main(String[] args) {

    }

    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        int n = points.length;

        for (int i = 0; i < n; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++){
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (!map.containsKey(dis)){
                    map.put(dis, 0);
                }

                count += map.get(dis) * 2;
                map.put(dis, map.get(dis) + 1);
            }
        }
        return count;
    }
}
