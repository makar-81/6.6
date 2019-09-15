package main;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by emakarov on 28.01.2016.
 */

public class  Main {
    public static void main(String[] args) {
        // put your code here
        try {
            String temp;

            FileReader fr = new FileReader("./test1.txt");
            FileWriter wr = new FileWriter("./test2.txt");

            BufferedWriter  bw = new BufferedWriter(wr);

            BufferedReader br = new BufferedReader(fr);

            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //Map<String, Integer> store = new HashMap<String, Integer>();
            //Map<Integer,String> keys = new HashMap<Integer,String>();
            ArrayList<String> myArrayList = new ArrayList<String>();
            //ArrayList<String> myArrayList_correlations = new ArrayList<String>();

            // Map<String, Integer> count = new HashMap<String, Integer>();
            //final String user = "user";

            try {
                while ((temp = br.readLine()) != null) {

                            int pos = temp.indexOf("\t");
                            String value = temp.substring(0,pos);
                            String countless = temp.substring(pos+1,pos+2);

                            if (!myArrayList.contains(value)) {
                                myArrayList.add(value);
                                myArrayList.add(countless);
                            } else {
                                int pos1 = myArrayList.indexOf(value);
                                String stored_countless = myArrayList.get(pos1+1);
                                if (!stored_countless.contains(countless))
                                {
                                    stored_countless= countless + stored_countless;
                                    myArrayList.set(pos1+1,stored_countless);
                                }
                            }
                }
                        for (int i=0;i<myArrayList.size();) {
                            if ((myArrayList.get(i+1)).length()==1){
                               System.out.println(myArrayList.get(i));
                               bw.write(myArrayList.get(i) + "\n");
                               bw.flush();
                            }
                            i = i+2;
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

