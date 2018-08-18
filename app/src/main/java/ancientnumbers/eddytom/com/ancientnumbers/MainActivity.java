package ancientnumbers.eddytom.com.ancientnumbers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TableLayout output_mayan, output_egypt;
    TextView output_roman;
    Space m1space, m2space;
    Button convert, help;
    private ImageView r11, r12, r13, r14, r16, r17, r18, r19, r111, r112, r113, r114, r116, r117, r118, r119, r21, r22, r23, r24, r26, r27, r28, r29, r211, r212, r213, r214, r216, r217, r218, r219, r31, r32, r33, r34, r36, r37, r38, r39, r311, r312, r313, r314, r316, r317, r318, r319, r41, r42, r43, r44, r46, r47, r48, r49, r411, r412, r413, r414, r416, r417, r418, r419;
    ArrayList<ImageView> nodeList;
    EditText input;
    TextView civ_detail;
    Mayan_Converter m;
    Roman_Converter r;
    boolean mayan_on = true, roman_on = false, egypt_on = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating instances of all components.
        input = findViewById(R.id.input);
        civ_detail = findViewById(R.id.group_detail);

        convert = findViewById(R.id.convert);
        help = findViewById(R.id.help);

        //Outputs
        output_mayan = findViewById(R.id.output_mayan);
        m1space = findViewById(R.id.space_one_mayan);
        m2space = findViewById(R.id.space_two_mayan);
        output_roman = findViewById(R.id.output_roman);
        output_egypt = findViewById(R.id.output_egypt);
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

        m = new Mayan_Converter(nodeList);
        r = new Roman_Converter(output_roman);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = 999999999;
                if (!input.getText().toString().isEmpty()) {
                    double maxIntCheck = Double.parseDouble(input.getText().toString());
                    if (maxIntCheck < 2147483647) {
                        num = (int) maxIntCheck;
                    }
                }
                //Clear all outputs
                for (int i = 0; i < nodeList.size(); i++) {
                    nodeList.get(i).setVisibility(View.INVISIBLE);
                }
                output_roman.setText("");

                //Logic gates to chose the converter and set maximums for them.
                if (mayan_on) {
                    if (num < 160000) {
                        m.setNum(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-159999.", Toast.LENGTH_LONG).show();
                    }
                }

                if (roman_on) {
                    if (num <= 1000) {
                        r.conv_num(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-1000.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            //Probably should limit to one click or do a warning.
            public void onClick(View view) {
                Intent browInt;
                if (mayan_on) {
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://courses.lumenlearning.com/waymakermath4libarts/chapter/the-mayan-numeral-system/"));
                    startActivity(browInt);
                }

                if (roman_on) {
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.britannica.com/topic/Roman-numeral"));
                    startActivity(browInt);
                }

                if(egypt_on){
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://discoveringegypt.com/egyptian-hieroglyphic-writing/egyptian-mathematics-numbers-hieroglyphs/"));
                    startActivity(browInt);
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
        if (id == R.id.action_settings_mayan) {
            if (!mayan_on){
                Toast.makeText(MainActivity.this, "Switching to Mayan Converter", Toast.LENGTH_LONG).show();
            output_mayan.setVisibility(View.VISIBLE);
            m1space.setVisibility(View.VISIBLE);
            m2space.setVisibility(View.VISIBLE);
            output_roman.setVisibility(View.GONE);
            output_egypt.setVisibility(View.GONE);
            mayan_on = true;
            roman_on = false;
            egypt_on = false;
            //Fact check needed
            civ_detail.setText("Mayan Civilization: 1800 BC - 1697 AD");
         }
        }
        if (id == R.id.action_settings_roman) {
            if(!roman_on) {
                Toast.makeText(MainActivity.this, "Switching to Roman Converter", Toast.LENGTH_LONG).show();
                output_roman.setVisibility(View.VISIBLE);
                output_mayan.setVisibility(View.GONE);
                output_egypt.setVisibility(View.GONE);
                m1space.setVisibility(View.GONE);
                m2space.setVisibility(View.GONE);
                mayan_on = false;
                egypt_on = false;
                roman_on = true;
                //Fact check needed
                civ_detail.setText("Roman Empire: 753 BC - 1453 AD");
            }
        }

        if (id == R.id.action_settings_egypt){
            if(!egypt_on){
                Toast.makeText(MainActivity.this, "Switching to Egyptian Converter", Toast.LENGTH_LONG).show();
                output_roman.setVisibility(View.GONE);
                output_mayan.setVisibility(View.GONE);
                output_egypt.setVisibility(View.VISIBLE);
                m1space.setVisibility(View.GONE);
                m2space.setVisibility(View.GONE);
                mayan_on = false;
                egypt_on = true;
                roman_on = false;
                //Fact check needed
                civ_detail.setText("Ancient Egypt: 3100 BC - 30 BC");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
