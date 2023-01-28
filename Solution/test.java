package L20230128.Solution;

public class test {
    public static void main(String[] args) {
        int [] ints = {1,2,3};
        Solution solution =new Solution(ints);

        for (int i : solution.shuffle()) {
            System.out.print(i);
        }
        for (int i : solution.reset) {
            System.out.print(i);
        }
    }
}
