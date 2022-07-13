import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Result {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (List<Integer> query : queries) {
            int q = query.get(0), elements = query.get(1);
            boolean flag = map.containsKey(elements);
            switch (q) {
                case 1: {
                    if (!flag) {
                        map.put(elements, 1);
                    }
                    else {
                        map.put(elements, map.get(elements) + 1);

                    }
                    break;
                }
                case 2:
                    if (flag) {
                        if(map.get(elements)<=1)
                            map.remove(elements,1);
                        else
                            map.put(elements, map.get(elements) - 1);
                    }
                    break;
                case 3:
                    if (map.containsValue(elements))
                        res.add(1);
                    else
                        res.add(0);
                    break;
            }

        }
        return res;

    }
    public static void main(String[] args) {
//        String list = """
//                1 5
//                1 6
//                3 2
//                1 10
//                1 10
//                1 6
//                2 5
//                3 2""";

        String list = """
                1 3
                2 3
                3 2
                1 4
                1 5
                1 5
                1 4
                3 2
                2 4
                3 2""";
        List<List<Integer>> arr = new ArrayList<>();
        String[] split = list.split("\n");

        for(int i = 0; i<list.split("\n").length; i++){

            String[] space = split[i].split("\\s");
            List<Integer> hold = new ArrayList<>();
            for (String s : space) {
                hold.add(Integer.parseInt(s));
            }
            if(!hold.isEmpty())
                arr.add(hold);

        }
//        StringBuilder list = new StringBuilder();
//        int size = 0;
////        String[] split = list.toString().split("\n");
//        try {
//            File myObj = new File("/Users/fernandorosa/IdeaProjects/Frequency Queries/src/Array");
//            Scanner myReader = new Scanner(myObj);
//
//            while (myReader.hasNextLine()) {
//                list.append(myReader.nextInt()).append("\n");
//                size++;
//
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        for(int i = 0; i<size; i++) {
//
//
//            String[] space = list.toString().split("\n");
//
//            List<Integer> hold = new ArrayList<>();
//            for (String s : space) {
//                hold.add(Integer.parseInt(s));
//
//            }
//            if (!hold.isEmpty()) arr.add(hold);
//        }

        System.out.println(freqQuery(arr));
    }
}
