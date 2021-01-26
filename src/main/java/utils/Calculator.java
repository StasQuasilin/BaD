package utils;

import entity.DynamicArr;
import entity.Result;

import java.util.Random;

public class Calculator {
    Random rdm = new Random();

    public Result calc(DynamicArr arr){
        Result r = new Result();

        int sum = 0;
        final int size = arr.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                int num = arr.get(i);
                sum += num;
                if (num > r.max) {
                    r.max = num;
                }
                if (num < r.min) {
                    r.min = num;
                }
            }
            sum /= size;
            r.inc = calcInc(1 , arr);
            r.dec = calcInc(-1 , arr);
            r.med = med(arr);
        }
        r.avg = sum;;

        return r;
    }

    private DynamicArr calcInc(int sign, DynamicArr arr) {
        int max = 0;
        DynamicArr inc = new DynamicArr(0);
        for (int i = 0; i < arr.size(); i++){

            int n = arr.get(i);
            int j;
            DynamicArr tmp = new DynamicArr();
            tmp.add(n);
            for (j = i + 1; j < arr.size(); j++){
                int m = arr.get(j);
                if (sign(m - n) == sign){
                    tmp.add(m);
                    n = m;
                } else {
                    break;
                }
            }
            int diff = j - i - 1;
            if (diff > max){
                inc = tmp;
                max = diff + 1;
            }
            i = j - 1;
        }

        return inc;

    }

    private int sign(int val) {
        if(val > 0){
            return 1;
        } else if(val < 0){
            return -1;
        }
        return 0;
    }

    int rdm(int l){
        return rdm.nextInt(l);
    }

    public int med(DynamicArr arr){
        final int size = arr.size();
        if (size % 2 == 1){
            return med(arr, size / 2);
        } else {
            return (med(arr, size / 2) + med(arr, size / 2 - 1)) / 2;
        }
    }

    private int med(DynamicArr arr, int k) {
        final int size = arr.size();
        DynamicArr lows = new DynamicArr();
        DynamicArr highs = new DynamicArr();
        DynamicArr pivots = new DynamicArr();

        int rdm = rdm(arr.size());
        int pivot = arr.get(rdm);
        for (int i = 0; i < arr.size(); i++){
            int n = arr.get(i);
            if (n < pivot) {
                lows.add(n);
            } else if (n > pivot) {
                highs.add(n);
            } else {
                pivots.add(n);
            }
        }

//        System.out.print(lows);
//        System.out.print(pivots);
//        System.out.println(highs);

        if (k < lows.size()){
            return med(lows, k);
        } else if (k < lows.size() + pivots.size()){
            return pivots.get(0);
        } else {
            return med(highs, k - lows.size() - pivots.size());
        }
    }
}
