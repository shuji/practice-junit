package ch19.ex01;

import java.util.ArrayList;
import java.util.List;

/**
 * リスト19.2 FizzBuzzクラス
 * @author shuji.w6e
 */
public class FizzBuzz {
    
    public static List<String> createFizzBuzzList(int size) {
        ArrayList<String> list = new ArrayList<String>(size);
        for (int i = 1; i <= size; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
