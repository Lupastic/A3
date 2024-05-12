public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.put("baha", 1);
        hashTable.put("daulet", 2);
        hashTable.put("nurik", 3);
        System.out.println("remove:" + hashTable.remove("daulet"));
        System.out.println("after remove " + hashTable.get("daulet"));
        System.out.println("contains: " + hashTable.contains(1));
        hashTable.put("Sancho", 4);
        System.out.println("new people " + hashTable.getKey(4));
        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i), new Student("key"+i));
        }
        table.bucketShow();
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(50, "Baha");
        tree.put(25, "daulet");
        tree.put(15, "sanjar");
        tree.put(30, "nurik");
        tree.put(75, "spiderman");
        tree.put(85, "man");
        System.out.println(tree.get(75));
        System.out.println(tree.put(19,"MyBirthday"));
        tree.inOrderTraversal(tree.getRoot());
    }
}