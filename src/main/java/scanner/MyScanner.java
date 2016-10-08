package scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Denni on 10/8/2016.
 */
public class MyScanner {

    private InputStreamReader inputStreamReader;
    BufferedReader bufferedReader;

    public MyScanner(InputStream in) {
        inputStreamReader = new InputStreamReader(in);
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    public String next() {
        String str = "";
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] ch = str.toCharArray();
        str="";
        for (int i = 0; i <ch.length ; i++) {
            if (ch[i] != ' ') {
                str+=ch[i];
            }else{
                return str;
            }
        }
        return str;
    }

}
