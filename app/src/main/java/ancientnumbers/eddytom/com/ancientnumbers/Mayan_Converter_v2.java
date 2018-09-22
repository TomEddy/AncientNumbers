package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Mayan_Converter_v2 extends AppCompatActivity {

    private final ArrayList<ImageView> nodeList;
    private final ArrayList<ImageView> zeroList;
    private final ArrayList<Integer> image_Resources;

    public Mayan_Converter_v2(){
        nodeList= null;
        zeroList = null;
        image_Resources = null;
    }
    Mayan_Converter_v2(ArrayList<ImageView> n,ArrayList<ImageView> nn){
        nodeList = n;
        zeroList = nn;

        int one, two, three, four, bar, zero;
        one = R.drawable.mayanone;
        two = R.drawable.mayantwo;
        three = R.drawable.mayanthree;
        four = R.drawable.mayanfour;
        bar = R.drawable.mayan_bar2;
        zero = R.drawable.cero_maya_p;

        image_Resources = new ArrayList<>();

        image_Resources.add(one);
        image_Resources.add(two);
        image_Resources.add(three);
        image_Resources.add(four);
        image_Resources.add(bar);
        image_Resources.add(zero);
    }
    private int tier(int num, int tier){
        boolean done = false;
        int level = 5;
        int counter;
        for(int i=0; i< tier; i++){
            level = level*20;
        }
        counter = 4*tier;
        while (!done) {
            if (num >= level) {
                nodeList.get(counter).setVisibility(View.VISIBLE);
                nodeList.get(counter).setImageResource(image_Resources.get(4));
                counter++;
                num = num - level;
            } else{
                int repeat = (int)Math.floor(num / (level/5));
               if(repeat != 0) {
                   nodeList.get(counter).setVisibility(View.VISIBLE);
                   nodeList.get(counter).setImageResource(image_Resources.get(repeat - 1));
                   num = num - ((level / 5) * repeat);
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
            zeroList.get(3).setImageResource(image_Resources.get(5));
            for(int i = 0; i < 4; i++){
                nodeList.get(12+i).setVisibility(View.GONE);
            }
        }
        if (num >= 400) {
            includeZeros = true;
            num = tier(num,2);
        }else if (includeZeros){
            zeroList.get(2).setVisibility(View.VISIBLE);
            zeroList.get(2).setImageResource(image_Resources.get(5));
            for(int i = 0; i < 4; i++){
                nodeList.get(8+i).setVisibility(View.GONE);
            }
        }
        if (num >= 20) {
            includeZeros = true;
            num = tier(num,1);
        }else if(includeZeros){
            zeroList.get(1).setVisibility(View.VISIBLE);
            zeroList.get(1).setImageResource(image_Resources.get(5));
            for(int i = 0; i < 4; i++){
                nodeList.get(4+i).setVisibility(View.GONE);
            }
        }
        if (num > 0) {
            num = tier(num,0);
        } else {
            for(int i = 0; i < 4; i++){
              nodeList.get(i).setVisibility(View.GONE);
            }
            zeroList.get(0).setImageResource(image_Resources.get(5));
            zeroList.get(0).setVisibility(View.VISIBLE);
        }
    }
}





