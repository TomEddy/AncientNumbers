package ancientnumbers.eddytom.com.ancientnumbers;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TableLayout output;
    Button convert;
    private ImageView r11, r12, r13, r14, r16, r17, r18, r19, r111, r112, r113, r114, r116, r117, r118, r119, r21, r22, r23, r24, r26, r27, r28, r29, r211, r212, r213, r214, r216, r217, r218, r219,r31, r32, r33, r34, r36, r37, r38, r39, r311, r312, r313, r314, r316, r317, r318, r319,r41, r42, r43, r44, r46, r47, r48, r49, r411, r412, r413, r414, r416, r417, r418, r419;
    ArrayList<ImageView> nodeList;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating instances of all components.
        final EditText input = findViewById(R.id.input);
        convert = findViewById(R.id.convert);
        output = findViewById(R.id.output);
        r11 = findViewById(R.id.r11);
        r12 = findViewById(R.id.r12);
        r13 = findViewById(R.id.r13);
        r14 = findViewById(R.id.r14);
        r16 = findViewById(R.id.r16);
        r17 = findViewById(R.id.r17);
        r18 = findViewById(R.id.r18);
        r19 = findViewById(R.id.r19);
        r111 = findViewById(R.id.r111);
        r112 = findViewById(R.id.r112);
        r113 = findViewById(R.id.r113);
        r114 = findViewById(R.id.r114);
        r116 = findViewById(R.id.r116);
        r117 = findViewById(R.id.r117);
        r118 = findViewById(R.id.r118);
        r119 = findViewById(R.id.r119);
        r21 = findViewById(R.id.r21);
        r22 = findViewById(R.id.r22);
        r23 = findViewById(R.id.r23);
        r24 = findViewById(R.id.r24);
        r26 = findViewById(R.id.r26);
        r27 = findViewById(R.id.r27);
        r28 = findViewById(R.id.r28);
        r29 = findViewById(R.id.r29);
        r211 = findViewById(R.id.r211);
        r212 = findViewById(R.id.r212);
        r213 = findViewById(R.id.r213);
        r214 = findViewById(R.id.r214);
        r216 = findViewById(R.id.r216);
        r217 = findViewById(R.id.r217);
        r218 = findViewById(R.id.r218);
        r219 = findViewById(R.id.r219);
        r31 = findViewById(R.id.r31);
        r32 = findViewById(R.id.r32);
        r33 = findViewById(R.id.r33);
        r34 = findViewById(R.id.r34);
        r36 = findViewById(R.id.r36);
        r37 = findViewById(R.id.r37);
        r38 = findViewById(R.id.r38);
        r39 = findViewById(R.id.r39);
        r311 = findViewById(R.id.r311);
        r312 = findViewById(R.id.r312);
        r313 = findViewById(R.id.r313);
        r314 = findViewById(R.id.r314);
        r316 = findViewById(R.id.r316);
        r317 = findViewById(R.id.r317);
        r318 = findViewById(R.id.r318);
        r319 = findViewById(R.id.r319);
        r41 = findViewById(R.id.r41);
        r42 = findViewById(R.id.r42);
        r43 = findViewById(R.id.r43);
        r44 = findViewById(R.id.r44);
        r46 = findViewById(R.id.r46);
        r47 = findViewById(R.id.r47);
        r48 = findViewById(R.id.r48);
        r49 = findViewById(R.id.r49);
        r411 = findViewById(R.id.r411);
        r412 = findViewById(R.id.r412);
        r413 = findViewById(R.id.r413);
        r414 = findViewById(R.id.r414);
        r416 = findViewById(R.id.r416);
        r417 = findViewById(R.id.r417);
        r418 = findViewById(R.id.r418);
        r419 = findViewById(R.id.r419);
        nodeList = new ArrayList<>();
        nodeList.add(r11);
        nodeList.add(r12);
        nodeList.add(r13);
        nodeList.add(r14);
        nodeList.add(r16);
        nodeList.add(r17);
        nodeList.add(r18);
        nodeList.add(r19);
        nodeList.add(r111);
        nodeList.add(r112);
        nodeList.add(r113);
        nodeList.add(r114);
        nodeList.add(r116);
        nodeList.add(r117);
        nodeList.add(r118);
        nodeList.add(r119);
        nodeList.add(r21);
        nodeList.add(r22);
        nodeList.add(r23);
        nodeList.add(r24);
        nodeList.add(r26);
        nodeList.add(r27);
        nodeList.add(r28);
        nodeList.add(r29);
        nodeList.add(r211);
        nodeList.add(r212);
        nodeList.add(r213);
        nodeList.add(r214);
        nodeList.add(r216);
        nodeList.add(r217);
        nodeList.add(r218);
        nodeList.add(r219);
        nodeList.add(r31);
        nodeList.add(r32);
        nodeList.add(r33);
        nodeList.add(r34);
        nodeList.add(r36);
        nodeList.add(r37);
        nodeList.add(r38);
        nodeList.add(r39);
        nodeList.add(r311);
        nodeList.add(r312);
        nodeList.add(r313);
        nodeList.add(r314);
        nodeList.add(r316);
        nodeList.add(r317);
        nodeList.add(r318);
        nodeList.add(r319);
        nodeList.add(r41);
        nodeList.add(r42);
        nodeList.add(r43);
        nodeList.add(r44);
        nodeList.add(r46);
        nodeList.add(r47);
        nodeList.add(r48);
        nodeList.add(r49);
        nodeList.add(r411);
        nodeList.add(r412);
        nodeList.add(r413);
        nodeList.add(r414);
        nodeList.add(r416);
        nodeList.add(r417);
        nodeList.add(r418);
        nodeList.add(r419);


        convert.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(input.getText().toString());
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
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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
                    Drawable d = getResources().getDrawable(R.drawable.mayan_circle);
                    nodeList.get(i + counter).setBackground(d);
                    nodeList.get(i + counter).setImageDrawable(d);

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

}
