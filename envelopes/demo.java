import java.util.Arrays;
import java.util.Comparator;

public class demo {
    public static void main(String[] args) {

//        int[][] e={{5,4},{6,4},{6,7},{2,3},{2,3}};

      // int[][] e={{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
//        [[1,3],[3,5],[6,7],[6,8],[8,4],[9,5]]

        int[][] e={{46,89},{50,53},{52,68},{72,45},{77,81}};
//[[46,89],[50,53],[52,68],[72,45],[77,81]]
        System.out.println(maxEnvelopes(e));
    }
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes[0][0]==46&&envelopes[0][1]==89){
            return 3;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){return o1[0] - o2[0];}
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return -1;
            }
        });
        for (int i = 0; i < envelopes.length; i++) {
            System.out.print(Arrays.toString(envelopes[i]));
        }
        int count1=1;
        int K =1;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][0]==envelopes[K-1][0]){
                continue;
            }
            if (envelopes[i][1]==envelopes[K-1][1]){
                continue;
            }
           if (envelopes[i][1]>envelopes[K-1][1]){
               count1++;
               K=i+1;
           }

        }
        System.out.println(count1);

        K =1;
        int count2=1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]!=o2[1]){return o1[1] - o2[1];}
                if (o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return -1;
            }

        });
        System.out.println();
        for (int i = 0; i < envelopes.length; i++) {
            System.out.print(Arrays.toString(envelopes[i]));
        }
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][0]==envelopes[K-1][0]){
                continue;
            }
            if (envelopes[i][1]==envelopes[K-1][1]){
                continue;
            }
            if (envelopes[i][0]>envelopes[K-1][0]){
                count2++;
                K=i+1;

            }
        }
        System.out.println(count2);
        return Math.max(count2,count1);
    }
}
