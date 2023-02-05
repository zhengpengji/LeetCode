package FindCheapestPrice;

import java.util.*;

public class FindCheapestPrice {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k + 1];
        Map<Integer, List<int[]>> fromToMap = new HashMap<>();
        for (int[] flight : flights) {
            List<int[]> list = fromToMap.getOrDefault(flight[0], new ArrayList<>());
            list.add(new int[]{flight[1], flight[2]});
            fromToMap.put(flight[0], list);
        }
        List<int[]> list = null;
        Queue<Integer> nextList = new LinkedList<>();
        Set<Integer> tempList = new HashSet<>();
        nextList.add(src);
        int count = 0;
        while (!nextList.isEmpty() && count <= k) {
            src = nextList.poll();
            list = fromToMap.getOrDefault(src, new ArrayList<>());
            for (int[] ints : list) {
                if (count == 0) {
                    dp[ints[0]][count] = ints[1];
                } else {
                    if (dp[ints[0]][count] == 0) {
                        dp[ints[0]][count] = ints[1] + dp[src][count - 1];
                    } else {
                        dp[ints[0]][count] = Math.min(dp[ints[0]][count], ints[1] + dp[src][count - 1]);
                    }
                }
                tempList.add(ints[0]);
            }
            if (nextList.isEmpty()) {
                nextList = new LinkedList<>(tempList);
                count++;
                tempList = new HashSet<>();
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (dp[dst][i] != 0) {
                min = Math.min(min, dp[dst][i]);
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
}

//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        Arrays.sort(flights, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        for (int i = 0; i < flights.length; i++) {
//            System.out.print(Arrays.toString(flights[i]));
//        }
//        System.out.println();
//        ArrayList<ArrayList<Integer[]>> arrayList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer[]> arrayList1 = new ArrayList<>();
//            arrayList.add(arrayList1);
//        }
//        int index = 0;
//        for (int i = 0; i < flights.length - 1; i++) {
//            if (flights[i][0] == flights[i + 1][0]) {
//                Integer[] arr = {flights[i][1], flights[i][2]};
//                arrayList.get(index).add(arr);
//                if (i == flights.length - 2) {
//                    Integer[] arr2 = {flights[i + 1][1], flights[i + 1][2]};
//                    arrayList.get(index).add(arr2);
//                }
//            } else {
//                Integer[] arr = {flights[i][1], flights[i][2]};
//                arrayList.get(index).add(arr);
//                index++;
//                if (i == flights.length - 2) {
//                    Integer[] arr2 = {flights[i + 1][1], flights[i + 1][2]};
//                    arrayList.get(index).add(arr2);
//                }
//            }
//        }
//
//        for (int i = src; i < arrayList.size(); i++) {
//            int Sr =src;
//            for (Integer[] integers : arrayList.get(Sr)) {
//               Sr= integers[0];
//
//
//
//            }
//
//
//            }
//
//
//
//
//
//
//        }
//
//
//
//
//        return 1;
//        }
//        public static int GetPrice( ArrayList<ArrayList<Integer[]>> arrayList ,int i,int k,int src,int dst){
//        int  index = 0;
//        int Sr =src;
//            int s=-1;
//            int price=0;
//            int count =0;
//        while (true) {
//            s = arrayList.get(Sr).get(index)[0];
//            if (s == dst) {
//
//            }
//
//
//
//            if (s < dst) {
//                price = price+arrayList.get(Sr).get(index)[1];
//                Sr=s;
//                count++;
//                if (count==k){
//                    return Integer.MAX_VALUE;
//                }
//            }
//
//        }
//
//
//
//    }






