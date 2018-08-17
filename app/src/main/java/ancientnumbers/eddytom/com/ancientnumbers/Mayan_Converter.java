package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Mayan_Converter extends AppCompatActivity {

    ArrayList<ImageView> nodeList;
    int num;
    int counter = 0;

    Mayan_Converter(ArrayList<ImageView> n){
        nodeList = n;
    }

    private void tier1(int num) {
        boolean done = false;
        counter = 0;
        while (!done) {
            if (num >= 5) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                for (int i = 3; i > 0; i--) {
                    nodeList.get(i + counter).setVisibility(View.GONE);
                }
                counter = counter + 4;
                num = num - 5;
            } else{
                for (int i = 0; i < num; i++) {
                    nodeList.get(i + counter).setVisibility(View.VISIBLE);
                }
                done = true;
                counter = 0;
            }
        }
    }

    private int tier2(int num) {
        boolean done = false;
        counter = 16;
        while (!done) {
            if (num >= 100) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                for (int i = 3; i > 0; i--) {
                    nodeList.get(i + counter).setVisibility(View.GONE);
                }
                counter = counter + 4;
                num = num - 100;
            } else if (num < 100) {
                int repeat = (int)Math.floor(num / 20);
                for (int i = 0; i < repeat; i++) {
                    nodeList.get(i + counter).setVisibility(View.VISIBLE);
                    num = num - 20;
                }
                done = true;
                counter = 0;
            }
        }
        return num;
    }

    private int tier3(int num) {
        boolean done = false;
        counter = 32;
        while (!done) {
            if (num >= 2000) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                for (int i = 3; i > 0; i--) {
                    nodeList.get(i + counter).setVisibility(View.GONE);
                }
                counter = counter + 4;
                num = num - 2000;
            } else if (num < 2000) {
                int repeat = (int)Math.floor(num / 400);
                for (int i = 0; i < repeat; i++) {
                    nodeList.get(i + counter).setVisibility(View.VISIBLE);
                    num = num - 400;
                }
                done = true;
                counter = 0;
            }
        }
        return num;
    }

    private int tier4(int num) {
        boolean done = false;
        counter = 48;
        while (!done) {
            if (num >= 40000) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                for (int i = 3; i > 0; i--) {
                    nodeList.get(i + counter).setVisibility(View.GONE);
                }
                counter = counter + 4;
                num = num - 40000;
            } else if (num < 40000) {
                int repeat = (int)Math.floor(num / 8000);
                for (int i = 0; i < repeat; i++) {
                    nodeList.get(i + counter).setVisibility(View.VISIBLE);
                    num = num - 8000;
                }
                done = true;
                counter = 0;
            }
        }
        return num;
    }

    public void setNum(int n){
            num = n;
            if (num >= 8000) {
            num = tier4(num);
        }
        if (num >= 400) {
            num = tier3(num);
        }
        if (num >= 20) {
            num = tier2(num);
        }
        if (num >= 0) {
            tier1(num);
        }
    }
}





