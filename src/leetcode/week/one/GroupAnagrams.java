package leetcode.week.one;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] list = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String s1 = new String(c).intern();
            if (map.containsKey(s1)){
                List<String> e = result.get(map.get(s1));
                e.add(s);
            } else {
                List<String> e = new ArrayList<>();
                e.add(s);
                map.put(s1, result.size());
                result.add(e);
            }
        }
        return result;
    }
}
