package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Bab_Converter extends AppCompatActivity {

    ArrayList<ImageView> nodeList;
    ArrayList<Integer> image_Resources_Ones;
    ArrayList<Integer> image_Resources_Tens;

    Bab_Converter(ArrayList<ImageView> n) {
        nodeList = n;
        int one, two, three, four, five, six, seven, eight, nine, ten, twenty, thirty, forty, fifty;
        one = R.drawable.bab_1;
        two = R.drawable.bab_2;
        three = R.drawable.bab_3;
        four = R.drawable.bab_4;
        five = R.drawable.bab_5;
        six = R.drawable.bab_6;
        seven = R.drawable.bab_7;
        eight = R.drawable.bab_8;
        nine = R.drawable.bab_9;
        ten = R.drawable.bab_10;
        twenty = R.drawable.bab_20;
        thirty = R.drawable.bab_30;
        forty = R.drawable.bab_40;
        fifty = R.drawable.bab_50;

        image_Resources_Ones = new ArrayList<>();
        image_Resources_Tens = new ArrayList<>();

        image_Resources_Ones.add(one);
        image_Resources_Ones.add(two);
        image_Resources_Ones.add(three);
        image_Resources_Ones.add(four);
        image_Resources_Ones.add(five);
        image_Resources_Ones.add(six);
        image_Resources_Ones.add(seven);
        image_Resources_Ones.add(eight);
        image_Resources_Ones.add(nine);
        image_Resources_Tens.add(ten);
        image_Resources_Tens.add(twenty);
        image_Resources_Tens.add(thirty);
        image_Resources_Tens.add(forty);
        image_Resources_Tens.add(fifty);
    }

    //Only working for 1-59
    private int tier(int num, int tier) {
        int level = 1;
        int one_counter = 0;
        int tens_counter = 0;
        for (int i = 0; i < tier; i++) {
            level = level * 60;
        }
        //Seems Wrong For higher tiers
        if (num >= level * 10) {
            while (num >= level * 10) {
                tens_counter++;
                num = num - level * 10;
            }
            nodeList.get(1).setVisibility(View.VISIBLE);
            nodeList.get(1).setImageResource(image_Resources_Tens.get(tens_counter - 1));
        }
        while (num >= level) {
            one_counter++;
            num = num - level;
        }
        nodeList.get(0).setVisibility(View.VISIBLE);
        nodeList.get(0).setImageResource(image_Resources_Ones.get(one_counter - 1));
        return num;
    }

    public void setNum(int n) {
        int num = n;

        if (num >= 216000) {
            num = tier(num, 3);
        }
        if (num >= 3600) {
            num = tier(num, 2);
        }
        if (num >= 60) {
            num = tier(num, 1);
        }
        if (num > 0) {
            num = tier(num, 0);
        }
    }
}





