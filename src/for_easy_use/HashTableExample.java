package for_easy_use;

import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("one", 1);
        hashtable.put("two", 2);
        System.out.println(hashtable.get("one")); // 1
        hashtable.remove("two");
        System.out.println(hashtable); // {one=1}
    }
}
