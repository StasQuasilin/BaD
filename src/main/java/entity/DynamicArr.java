package entity;

import java.util.Arrays;

public class DynamicArr {

    private int[] arr;
    private int itemsCount;
    private static final int arrStep = 10000;
    public DynamicArr(){
        arr = new int[arrStep];
    }
    public DynamicArr(int arrSize){
        arr = new int[arrSize];
    }

    public DynamicArr(int[] arr) {
        this.arr = arr;
        itemsCount = arr.length;
    }

    public void add(int i){
        if (itemsCount + 1 > arr.length){
            resize();
        }
        arr[itemsCount++] = i;
    }

    private void resize() {
        int[] tmp = arr;
        arr = new int[tmp.length + arrStep];
        int i = 0;
        for (int n : tmp){
            arr[i++] = n;
        }
//        for (int i = 0; i< tmp.length; i++){
//            arr[i] = tmp[i];
//        }
    }

    public int size(){
        return itemsCount;
    }

    public int get(int idx) {
        return arr[idx];
    }

    @Override
    public String toString() {
        return Arrays.toString(items());
    }

    public int[] items(){
        int[] items = new int[itemsCount];
        for (int i = 0 ;i < itemsCount; i++){
            items[i] = arr[i];
        }
        return items;
    }
}
