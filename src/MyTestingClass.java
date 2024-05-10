public class MyTestingClass {
    private String key;
    public MyTestingClass(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 31 * hash + key.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return key != null ? key.equals(that.key) : that.key == null;
    }
}
