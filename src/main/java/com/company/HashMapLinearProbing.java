package com.company;

import java.util.Scanner;

class HashMap {

    /**
     * Default capacity is the max size of the HashMap, now it is 10
     * Current size it is a size of HashMap at the moment
     */

    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.7;
    private int threshold;
    private double loadFactor;
    private int capacity;
    private int currentSize;
    private Integer[] keys;
    private Long[] values;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }


    public HashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity, double loadFactor) {
        if (capacity <= 0) throw new IllegalArgumentException("Wrong capacity: " + capacity);

        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
            throw new IllegalArgumentException("Wrong loadFactor: " + loadFactor);

        this.loadFactor = loadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        threshold = (int) (this.capacity * loadFactor);

        keys = new Integer[capacity];
        values = new Long[capacity];
    }

    /**
     * getSize method
     *
     * @return current size of the HashMap
     */

    public int getSize() {
        return currentSize;
    }

    /**
     * isEmpty method
     *
     * @return true or false depending whether the HashMap is empty
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * increaseCapacity method
     * If current capacity of HashMap is almost max, this method increases it
     */
    public void increaseCapacity() {
        capacity = (2 * capacity) + 1;

    }

    /**
     * resizeTable method performs key table and value table elements swap
     * to
     */

    private void resizeTable() {
        increaseCapacity();

        threshold = (int) (capacity * loadFactor);

        Integer[] oldKeysTable = new Integer[capacity];
        Long[] oldValuesTable = new Long[capacity];

        Integer[] keysTableTemp = keys;
        keys = oldKeysTable;
        oldKeysTable = keysTableTemp;

        Long[] valueTableTemp = values;
        values = oldValuesTable;
        oldValuesTable = valueTableTemp;

        currentSize = 0;

        for (int i = 0; i < oldKeysTable.length; i++) {
            if (oldKeysTable[i] != null) {
                put(oldKeysTable[i], oldValuesTable[i]);
            }
            oldValuesTable[i] = null;
            oldKeysTable[i] = null;
        }
    }

    private int getHash(Integer key) {
        return key.hashCode() % capacity;
    }


    public Long put(Integer key, Long value) {
        int hash = getHash(key);
        int i = hash;
        if (currentSize >= threshold) {
            resizeTable();
        }
        do {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                currentSize++;
                return value;
            }
            if (keys[i].equals(key)) {
                Long oldValue = values[i];
                values[i] = value;
                return oldValue;
            }
            i = (i + 1) % DEFAULT_CAPACITY;

        } while (i != hash);

        return value;
    }

    public Long get(Integer key) {
        int i = getHash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (i + 1) % DEFAULT_CAPACITY;
        }
        return null;

    }

    public void printHashMap() {
        System.out.println("\n Hash Map: ");
        for (int i = 0; i < DEFAULT_CAPACITY; i++)
            if (keys[i] != null) {
                System.out.println("Key = " + keys[i] + " Value = " + values[i]);
            }
        System.out.println();
    }
}

public class HashMapLinearProbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap map = new HashMap();
        char ch;
        do {

            printInfo();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    putAnElement(scanner, map);
                    break;

                case 2:
                    getAnElement(scanner, map);
                    break;

                case 3:
                    isEmptyCheck(map);
                    break;

                case 4:
                    System.out.println("Current size of Hash Map is: " + map.getSize());
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            map.printHashMap();
            System.out.println("\n If you want to continue input 'y' \n");
            ch = scanner.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

    private static void isEmptyCheck(HashMap map) {
        System.out.println("True if Hash Map is empty, False if Hash Map have elements: " + map.isEmpty());
        return;
    }

    private static void getAnElement(Scanner scanner, HashMap map) {
        System.out.println("Input Key to see the value: ");
        System.out.println("Value = " + map.get(scanner.nextInt()));
        return;
    }

    private static void putAnElement(Scanner scanner, HashMap map) {
        System.out.println("Input key and value: ");
        System.out.println("\n Old value: " + map.put(scanner.nextInt(), scanner.nextLong()));
        return;
    }

    private static void printInfo() {
        System.out.println("\n Hash Map Operations: ");
        System.out.println("1. Put element ");
        System.out.println("2. Get element ");
        System.out.println("3. Check is Hash Map empty ");
        System.out.println("4. Size of Hash Map ");
    }
}
