import java.util.HashMap;

public class MyHashTable<K, V> {
        private class HashNode<K, V> {
            K key;
            V value;
            HashNode<K, V> next;

            public HashNode(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "{" + key + " = " + value + "}";
            }
        }

        private HashNode<K, V>[] chainArray;
        private int M = 11;
        private int size;


        public MyHashTable() {
            chainArray = (HashNode<K, V>[]) new HashNode[M];
            size = 0;
        }

        public MyHashTable(int M) {
            this.M = M;
            chainArray = (HashNode<K, V>[]) new HashNode[M];
            size = 0;
        }

        private int hash(K key) {
            int hash = key.hashCode();
            hash = Math.abs(hash);
            int end = hash % M;
            return end;
        }
    public void put(K key, V value) {
        int id = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[id] == null){
            chainArray[id] = newNode;
            size++;
        } else {
            while (chainArray[id].next != null){
                if(chainArray[id].key.equals(key)) {
                    chainArray[id].value = value;
                    return;
                }
                chainArray[id] = chainArray[id].next;
            }
            if (chainArray[id].key.equals(key)) {
                chainArray[id].value = value;
            } else {
                chainArray[id].next = newNode;
                size++;
            }
        }
    }

    public V get(K key) {
        int id = hash(key);
        while (chainArray[id] != null) {
            if (chainArray[id].key.equals(key)) {
                return chainArray[id].value;
            }
            chainArray[id] = chainArray[id].next;
        }
        return null;
    }

    public V remove(K key) {
        int id = hash(key);
        HashNode<K, V> prev = null;
        while (chainArray[id] != null) {
            if (chainArray[id].key.equals(key)) {
                V value = chainArray[id].value;
                if (prev == null) {
                    chainArray[id] = chainArray[id].next;
                } else {
                    prev.next = chainArray[id].next;
                }
                size--;
                return value;
            }
            prev = chainArray[id];
            chainArray[id] = chainArray[id].next;
        }
        return null;
    }
        public boolean contains(V value) {
            for (int i = 0; i < M; i++) {
                while (chainArray[i] != null) {
                    if (chainArray[i].value.equals(value)) {
                        return true;
                    }
                    chainArray[i] = chainArray[i].next;
                }
            }
            return false;
        }
        public K getKey(V value) {
            for (int i = 0; i < M; i++) {
                while (chainArray[i] != null) {
                    if (chainArray[i].value.equals(value)) {
                        return chainArray[i].key;
                    }
                    chainArray[i] = chainArray[i].next;
                }
            }
            return null;
        }
        public void printBucketCounts() {
            for (int i = 0; i < chainArray.length; i++) {
                int count = 0;
                while (chainArray[i] != null) {
                    chainArray[i] = chainArray[i].next;
                    count++;
                }
            System.out.println("Bucket " + i + " has " + count);
        }
    }
}
