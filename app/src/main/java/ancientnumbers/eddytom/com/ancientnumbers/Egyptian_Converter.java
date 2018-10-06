package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
/*
Egyptian_Converter
Class responsible for converting numbers into Egyptian numerals.
Constructor: ArrayList<ImageView> n is the collection of textviews that make up all possible slots for an egyptian numeral to be displayed.
Methods: setNum method which converts the desired number.
         tier supplementary method which decrements number according to category allowing the remainder to be processed after.
*/
public class Egyptian_Converter extends AppCompatActivity {

    private final ArrayList<ImageView> nodeList;

    public Egyptian_Converter(){
        nodeList = null;
    }
    Egyptian_Converter(ArrayList<ImageView> n){
        nodeList = n;
    }
    private int tier(int num, int tier) {
        int level = 1;
        int counter;
        for (int i = 0; i < tier; i++) {
            level = level * 10;
        }
        counter = 9 * tier;
        for (int i = 0; i < 9; i++) {
            if (num >= level) {
                if (nodeList != null) {
                    nodeList.get(counter).setVisibility(View.VISIBLE);
                }
                counter = counter + 1;
                num = num - level;
            } else {
                if (nodeList != null) {
                    nodeList.get(counter).setVisibility(View.INVISIBLE);
                }
                counter = counter + 1;
            }
        }
        return num;
    }
    public void setNum(int n){
        int num = n;
        if (num >= 1000) {
            num = tier(num,3);
        }
        if (num >= 100) {
            num = tier(num,2);
        }
        if (num >= 10) {
            num = tier(num,1);
        }
        if (num > 0) {
            tier(num,0);
        }
    }
}