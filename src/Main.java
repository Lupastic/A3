    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();
        myHashTable.put("baha", 1);
        myHashTable.put("daulet", 2);
        myHashTable.put("nurik", 3);
        System.out.println("get: " + myHashTable.get("baha"));
        System.out.println("contains: " + myHashTable.contains(2));
        System.out.println("remove:" + myHashTable.remove("daulet"));
        System.out.println("after remove " + myHashTable.get("daulet"));
        myHashTable.put("Sancho", 4);
        System.out.println("new people " + myHashTable.getKey(4));

    }
}