import java.util.Arrays;
import java.util.Comparator;

public class demo2 {
        public static void main(String[] args) {
            int[][] e={{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
            System.out.println(maxEnvelopes(e));
        }
        public static int maxEnvelopes(int[][] envelopes) {

            Arrays.sort(envelopes, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {

                    return (o1[0]+o1[1])-(o2[0]+o2[1]);
                }
            });
            int max =0;
            for (int I = 1; I < envelopes.length; I++) {
                int count1=1;
                int K =I;
                for (int i=I; i < envelopes.length; i++) {
                    if (envelopes[i][1]>envelopes[K-1][1]&&envelopes[i][0]>envelopes[K-1][0]){
                        count1++;
                        K=i+1;
                    }
                }
                max =Math.max(max,count1);
            }

            return max;
        }
    }

