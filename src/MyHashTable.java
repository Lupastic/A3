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
            int hash = key.hashCode() % M;
            if (hash < 0) {
                hash += M;
            }
            return hash;
        }


        public void put(K key, V value) {
            int id = hash(key);
            HashNode<K, V> new_id = new HashNode<>(key, value);
            HashNode<K, V> rnow = chainArray[id];
            if (rnow == null) {
                chainArray[id] = new_id;
                size++;
                return;
            }

            HashNode<K, V> last = null;
            while (rnow != null) {
                if (rnow.key.equals(key)) {
                    rnow.value = value;
                    return;
                }
                last = rnow;
                rnow = rnow.next;
            }

            last.next = new_id;
            size++;
        }


        public V get(K key) {
            int id = hash(key);
            HashNode<K, V> node = chainArray[id];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

        public V remove(K key) {
            int id = hash(key);
            HashNode<K, V> node = chainArray[id];
            HashNode<K, V> last = null;
            while (node != null) {
                if (node.key.equals(key)) {
                    if (last == null) {
                        chainArray[id] = node.next;
                    } else {
                        last.next = node.next;
                    }
                    size--;
                    return node.value;
                }
                last = node;
                node = node.next;
            }
            return null;
        }

        public boolean contains(V value) {
            for (int i = 0; i < M; i++) {
                HashNode<K, V> node = chainArray[i];
                while (node != null) {
                    if (node.value.equals(value)) {
                        return true;
                    }
                    node = node.next;
                }
            }
            return false;
        }

        public K getKey(V value) {
            for (int i = 0; i < M; i++) {
                HashNode<K, V> node = chainArray[i];
                while (node != null) {
                    if (node.value.equals(value)) {
                        return node.key;
                    }
                    node = node.next;
                }
            }
            return null;
        }
    }
