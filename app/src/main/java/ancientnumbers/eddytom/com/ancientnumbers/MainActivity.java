package ancientnumbers.eddytom.com.ancientnumbers;

import android.os.Bundle;
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
    private ImageView r11, r12, r13, r14, r16, r17, r18, r19, r111, r112, r113, r114, r116, r117, r118, r119, r21, r22, r23, r24, r26, r27, r28, r29, r211, r212, r213, r214, r216, r217, r218, r219;
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


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(input.getText().toString());
                boolean done = false;
                while (!done) {
                    if (num >= 20) {
                        num = tier2(num);
                    }
                    if (num >= 5) {
                        nodeList.get(0 + counter).setVisibility(View.VISIBLE);
                        for (int i = 3; i > 0; i--) {
                            nodeList.get(i + counter).setVisibility(View.GONE);
                        }
                        counter = counter + 4;
                        num = num - 5;
                    } else if (num < 5) {
                        for (int i = 0; i < num; i++) {
                            nodeList.get(i + counter).setVisibility(View.VISIBLE);
                        }
                        done = true;
                        counter = 0;
                    }
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

    private int tier2(int num) {
        boolean done = false;
        counter = 16;
        while (!done) {
            if (num >= 100) {
                nodeList.get(0 + counter).setVisibility(View.VISIBLE);
                for (int i = 3; i > 0; i--) {
                    nodeList.get(i + counter).setVisibility(View.GONE);
                }
                counter = counter + 4;
                num = num - 100;
            } else if (num < 100) {
                for (int i = 0; i < Math.floor(num / 20); i++) {
                    nodeList.get(i + counter).setVisibility(View.VISIBLE);
                    num = num - 20;
                }
                done = true;
                counter = 0;
            }
        }
        return num;
    }

}
