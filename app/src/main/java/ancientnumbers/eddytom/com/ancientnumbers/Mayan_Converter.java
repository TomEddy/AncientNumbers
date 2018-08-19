package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Mayan_Converter extends AppCompatActivity {

    ArrayList<ImageView> nodeList;
    ArrayList<ImageView> zeroList;

    Mayan_Converter(ArrayList<ImageView> n,ArrayList<ImageView> nn){
        nodeList = n;
        zeroList = nn;
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
            boolean includeZeros = false;
            if (num >= 8000) {
                includeZeros = true;
            num = tier(num,3);
        }else if(includeZeros){
                //Currently always false but needed for expansion
                zeroList.get(3).setVisibility(View.VISIBLE);
                for(int i = 0; i < 16; i++){
                    nodeList.get(48+i).setVisibility(View.GONE);
                }
            }
        if (num >= 400) {
                includeZeros = true;
            num = tier(num,2);
        }else if (includeZeros){
            zeroList.get(2).setVisibility(View.VISIBLE);
            for(int i = 0; i < 16; i++){
                nodeList.get(32+i).setVisibility(View.GONE);
            }
        }
        if (num >= 20) {
                includeZeros = true;
            num = tier(num,1);
        }else if(includeZeros){
            zeroList.get(1).setVisibility(View.VISIBLE);
            for(int i = 0; i < 16; i++){
                nodeList.get(16+i).setVisibility(View.GONE);
            }
        }
        if (num > 0) {
            num = tier(num,0);
        } else if (includeZeros){
            zeroList.get(0).setVisibility(View.VISIBLE);
            for(int i = 0; i < 16; i++){
                nodeList.get(i).setVisibility(View.GONE);
            }
        }
    }
}





