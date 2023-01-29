package a11;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public  List<String> letterCombinations (String digits){
        String[] Digits={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if (len==0){
            return list;
        }

        for (int i = 0; i < len; i++) {
            char c = digits.charAt(i);
            String o=Digits[c-'0'];
            if (i==0){
                for (int j = 0; j < o.length(); j++) {
                    list.add(o.substring(j,j+1));
                }
            }
            if (i!=0){
                List<String>  list2=new ArrayList<>();
                list2.addAll(list);
                int D=list2.size();
                int Re;
                if (c=='7'||c=='9'){Re=3;}else {Re=2;}
                for (int i1 = 0; i1 < Re; i1++) {
                    list.addAll(list2);
                }

                for (int X = 0; X < list.size(); X++) {
                    int d=X/D;
                    list.set(X,list.get(X)+o.charAt(d));
                }
            }
        }
        return list;
    }
}
