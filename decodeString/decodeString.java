package L20230128.Solution;

import java.math.BigDecimal;
import java.util.*;

public class decodeString {
    public static String decodeString(String s) {
        ArrayList<Character> chList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) chList.add(s.charAt(i));
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < chList.size(); i++) {
            int count = 0,F = 0,N = 0;
            if (chList.get(i) >= '0' && chList.get(i) <= '9') {
                while (N == 0) {
                    if (chList.get(i) >= '0' && chList.get(i) <= '9') {
                        sb1.append(chList.get(i));
                        if (count == 0) F = i;
                        i++;count++;
                    } else {
                        if (count == 1) {
                            F = 0;
                        } else {
                            int A = i - F;
                            for (int k = 0; k < A; k++) chList.remove(F);
                            String string = sb1.toString();
                            int a = Integer.parseInt(string)+'0';
                            if (a==91)a=397;
                            if (a==93)a=398;
                            chList.add(F, (char) a);
                        }
                        N = 1;
                        sb1 = new StringBuilder();
                    }
                }
            }
         }
            int N = 1;
            while (N == 1) {
                int D = 0;
                for (int i = 0; i < chList.size(); i++) {
                    if (chList.get(i) == '[') D = i;
                    if (chList.get(i) == ']') {
                        int X = chList.get(D - 1) - '0';
                        if ((X+'0')==397)X=91-'0';
                        if ((X+'0')==398)X=93-'0';
                        ArrayList<Character> CHa = new ArrayList<>();
                        ArrayList<Character> List = new ArrayList<>();
                        for (int p = 0; p <= D - 2; p++) CHa.add(chList.get(p));
                        for (int p = D + 1; p < i; p++) List.add(chList.get(p));
                        for (int p = 0; p < X; p++) CHa.addAll(List);
                        for (int p = i + 1; p < chList.size(); p++) CHa.add(chList.get(p));
                        chList = CHa;
                        break;
                    }
                    if (i == chList.size() - 1) N = 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chList.size(); i++) sb.append(chList.get(i));
            return String.valueOf(sb);
    }
}
