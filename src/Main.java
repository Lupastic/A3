import java.util.Random;    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        Random random = new Random();
        hashTable.put("baha", 1);
        hashTable.put("daulet", 2);
        hashTable.put("nurik", 3);
        System.out.println("get: " + hashTable.get("baha"));
        System.out.println("contains: " + hashTable.contains(2));
        System.out.println("remove:" + hashTable.remove("daulet"));
        System.out.println("after remove " + hashTable.get("daulet"));
        System.out.println("new people " + hashTable.getKey(4));
        System.out.println("contains: " + hashTable.contains(8));
        hashTable.put("Sancho", 4);

        for (int i = 0; i < 10000; i++) {
            String key = "Key" + random.nextInt(10000);
            MyTestingClass testKey = new MyTestingClass(key);
            table.put(testKey, i);
        }
        table.printBucketCounts();
    }
}