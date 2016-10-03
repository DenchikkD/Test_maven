package hashMap;

import java.util.Arrays;

/**
 * Created by Iliren on 29.09.2016.
 * * Created by Iliren on 29.09.2016.
 * Задача 2. Написать собственную реализацию MyHashMap<K, V>
 * Реализовать методы MyHashMap:
 * 1. boolean put(K, V)
 * 2. User get( K )
 * 3. int size()
 * 4. boolean remove(K key)
 * 5. MyEntry<K, V> entrySet()
 * <p>
 * Обеспечить возможность создания MyHashMap с указанием дженериком типов для "ключа" и "значения".
 * <p>
 * Наименование класса может звучать так: MyHashMap, при этом нельзя использовать HashMap или HashSet.
 * Примечание: напоминаю, что карта состоит из массива, элементами которого являются односвязанные списки.
 * <p>
 * Для хранения пары значений рекомендую создать класс MyEntry c двумя полями соответсвенно для ключа key и значения value.
 */
public class MyHashMap<K, V> extends MyAbstractHashMap<K, V> implements MyMap<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private MyEntry<K, V>[] arr;
    private int size = 0;


    public MyHashMap() {
        arr = (MyEntry<K, V>[]) new MyEntry[DEFAULT_INITIAL_CAPACITY];

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;

        if (size != myHashMap.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(arr, myHashMap.arr);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arr);
        result = 31 * result + size;
        return result;
    }

    @Override
    public boolean put(K key, V element) {
        System.out.println(arr.length);
        if (size() >= arr.length * DEFAULT_LOAD_FACTOR) {
            arr = newArray(arr);
        } else {
            int idx = hash(key) % (arr.length - 1);
            if (arr[idx] == null) {
                arr[idx] = new MyEntry<K, V>(hash(key), key, element, null);
                size++;
            } else {
                MyEntry<K, V> entry = new MyEntry<K, V>(hash(key), key, element, null);
                MyEntry<K, V> position = arr[idx];
                if (position.hash == entry.hash && checkEquality(position, entry.key)) {
                    position.value = entry.value;
                } else {
                    while (position.next != null) {
                        System.out.println(position.hash + " " + entry.hash);
                        if (position.hash == entry.hash && checkEquality(position, entry.key)) {
                            position.value = entry.value;
                        }
                        position = position.next;
                    }
                    position.next = entry;
                    size++;
                }
            }
        }
        return true;
    }

    private MyEntry<K, V>[] newArray(MyEntry<K, V>[] oldAarray) {
        MyEntry<K, V>[] newArr = (MyEntry<K, V>[]) new MyEntry[(int) (oldAarray.length * 2)];

        for (int i = 0; i < oldAarray.length; i++) {
            if (oldAarray[i] != null) {
                MyEntry<K, V> position = oldAarray[i];
                oldAarray[i] = null;
                while (position != null) {
                    int idx = hash(position.key)%(newArr.length-1);
                    if (newArr[idx] == null) {
                        newArr[idx] = position;
                    } else {
                        MyEntry<K, V> newArrPosition = newArr[idx];
                        while (newArrPosition.next != null) {
                            newArrPosition = newArrPosition.next;
                        }
                        newArrPosition.next = position;
                    }
                    MyEntry<K, V> oldPosition = position;
                    position = position.next;
                    oldPosition.next = null;
                }
            }
        }

        return newArr;
    }

    private int hash(K key) {
        int hash;
        if (key == null) {
            hash = 0;
        } else {
            hash = key.hashCode();
        }
        return hash;
    }

    private MyEntry<K, V> findPosition(K key) {
        MyEntry<K, V> position = null;
        int idx = hash(key) % (arr.length - 1);
        if (arr[idx] != null) {
            position = arr[idx];
            while (position != null) {
                if (position.hash == hash(key) && checkEquality(position, key))
                    return position;
                position = position.next;
            }
        }
        return position;
    }

    private boolean checkEquality(MyEntry<K, V> position, K key) {
        if (position.key == null || key == null) {
            if (position.key == key) {
                return true;
            }
        } else {
            if (position.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        MyEntry<K, V> element = findPosition(key);
        if (element != null) {
            return element.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(K key) {
        int idx = hash(key) % (arr.length - 1);
        if (arr[idx] == null) {
            return false;
        } else {
            MyEntry<K, V> position = arr[idx];
            if (position.hash == hash(key) && checkEquality(position, key)) {
                arr[idx] = position.next;
                position.next = null;
                return true;
            } else {
                while (position.next != null) {
                    if (position.next.hash == hash(key) &&
                            checkEquality(position.next, key)) {
                        if (position.next.next != null) {
                            position.next = position.next.next;
                        } else {
                            position.next = null;
                        }
                        return true;
                    } else {
                        position = position.next;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        return findPosition(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (size() != 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    MyEntry<K, V> position = arr[i];
                    while (position != null) {
                        if (builder.length() == 1) {
                            builder.append(position.key + " = " + position.value);
                        } else {
                            builder.append(", " + position.key + " = " + position.value);
                        }
                        position = position.next;
                    }
                }
                builder.append(System.lineSeparator());
            }
        }
        builder.append("]");
        return builder.toString();
    }

    static class MyEntry<K, V> implements MyMap.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        MyEntry<K, V> next;

        public MyEntry(int hash, K key, V value, MyEntry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldvalue = value;
            value = newValue;
            return oldvalue;
        }
    }

    public static void main(String[] args) {

    }


}


