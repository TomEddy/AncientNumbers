package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Mayan_Converter extends AppCompatActivity {

    ArrayList<ImageView> nodeList;


    Mayan_Converter(ArrayList<ImageView> n){
        nodeList = n;
    }
    private int tier(int num, int tier){
        boolean done = false;
        int level = 5;
        int counter = 0;
        for(int i=0; i< tier; i++){
            level = level*20;
        }
        counter = 16*tier;
        while (!done) {
            if (num >= level) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                for (int i = 3; i > 0; i--) {
                    nodeList.get(i + counter).setVisibility(View.GONE);
                }
                counter = counter + 4;
                num = num - level;
            } else{
                int repeat = (int)Math.floor(num / (level/5));
                for (int i = 0; i < repeat; i++) {
                    nodeList.get(i + counter).setVisibility(View.VISIBLE);
                    num = num - (level/5);
                }
                done = true;
            }
        }
        return num;
    }
    public void setNum(int n){
            int num = n;
            if (num >= 8000) {
            num = tier(num,3);
        }
        if (num >= 400) {
            num = tier(num,2);
        }
        if (num >= 20) {
            num = tier(num,1);
        }
        if (num >= 0) {
            num = tier(num,0);
        }
    }
}





