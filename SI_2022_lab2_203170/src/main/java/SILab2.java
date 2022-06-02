import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {
        if (list.size() <= 0) { // A
            throw new IllegalArgumentException("List length should be greater than 0"); //B
        }
        int n = list.size();
        int rootOfN = (int) Math.sqrt(n);
        if (rootOfN * rootOfN  != n) { //C
            throw new IllegalArgumentException("List length should be a perfect square"); //D
        }
        List<String> numMines = new ArrayList<>(); //E
        for (int i = 0; i < n; i++) { // F.1 , [ F.2 ] - USLOVOT i<n
            if (!list.get(i).equals("#")) { // G
                int num = 0;
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) { //H
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){ //I
                        num += 2; //J
                    }
                    else {
                        num  += 1; //K
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){ //L
                    num++; //M
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){ //N
                    num++; //O
                }
                numMines.add(String.valueOf(num)); //P
            }
            else {
                numMines.add(list.get(i)); //Q
            }
        } // F.3
        return numMines; //R
    }
    // S - exception

    public static void main(String[] args) {

        List<String> array = new ArrayList<String>();

        array.add("0");
        array.add("#");
        array.add("#");
        array.add("#");
        array.add("0");
        array.add("#");
        array.add("0");
        array.add("#");
        array.add("#");

        System.out.println(function(array));


    }



}