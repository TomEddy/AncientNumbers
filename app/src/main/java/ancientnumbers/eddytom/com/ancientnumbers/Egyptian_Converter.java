package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Egyptian_Converter extends AppCompatActivity {

    ArrayList<ImageView> nodeList;

    Egyptian_Converter(ArrayList<ImageView> n){
        nodeList = n;
    }
    private int tier(int num, int tier){
        boolean done = false;
        int level = 1;
        int counter = 0;
        for(int i=0; i< tier; i++){
            level = level*10;
        }
        counter = 9*tier;
        while (!done) {
            if (num >= level) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                counter = counter + 1;
                num = num - level;
            } else{
                done = true;
            }
        }
        return num;
    }
    public void setNum(int n){
        int num = n;
        /*if (num >= 1000) {
            num = tier(num,3);
        }
        if (num >= 100) {
            num = tier(num,2);
        }
        if (num >= 10) {
            num = tier(num,1);
        }*/
        if (num > 0) {
            num = tier(num,0);
        }
    }
}





