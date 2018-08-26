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
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TableLayout output_mayan;
    LinearLayout output_egypt, output_bab;
    TextView output_roman;
    Space m1space, m2space;
    Button convert, help;
    ImageView r11, r12, r13, r14, r16, r17, r18, r19, r111, r112, r113, r114, r116, r117, r118, r119, r21, r22, r23, r24, r26, r27, r28, r29, r211, r212, r213, r214, r216, r217, r218, r219, r31, r32, r33, r34, r36, r37, r38, r39, r311, r312, r313, r314, r316, r317, r318, r319, r41, r42, r43, r44, r46, r47, r48, r49, r411, r412, r413, r414, r416, r417, r418, r419;
    ImageView er11, er12,er13,er21,er22,er23,er31,er32,er33;
    ImageView er211, er212,er213,er221,er222,er223,er231,er232,er233;
    ImageView er311, er312,er313,er321,er322,er323,er331,er332,er333;
    ImageView er411, er412,er413,er421,er422,er423,er431,er432,er433;
    ImageView bab1,bab10;
    ArrayList<ImageView> mayan_nodeList, mayan_zeroList, egypt_nodeList, bab_nodelist;
    EditText input;
    TextView civ_detail;
    Roman_Converter r;
    Egyptian_Converter e;
    Mayan_Converter m;
    Bab_Converter b;
    boolean mayan_on = true, roman_on = false, egypt_on = false, bab_on = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating instances of all components.
        //Misc Components
        input = findViewById(R.id.input);
        civ_detail = findViewById(R.id.group_detail);
        convert = findViewById(R.id.convert);
        help = findViewById(R.id.help);

        //Outputs
        //Mayan Output
        output_mayan = findViewById(R.id.output_mayan);
        m1space = findViewById(R.id.space_one_mayan);
        m2space = findViewById(R.id.space_two_mayan);
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
        mayan_nodeList = new ArrayList<>();
        mayan_nodeList.add(r11);
        mayan_nodeList.add(r12);
        mayan_nodeList.add(r13);
        mayan_nodeList.add(r14);
        mayan_nodeList.add(r16);
        mayan_nodeList.add(r17);
        mayan_nodeList.add(r18);
        mayan_nodeList.add(r19);
        mayan_nodeList.add(r111);
        mayan_nodeList.add(r112);
        mayan_nodeList.add(r113);
        mayan_nodeList.add(r114);
        mayan_nodeList.add(r116);
        mayan_nodeList.add(r117);
        mayan_nodeList.add(r118);
        mayan_nodeList.add(r119);
        mayan_nodeList.add(r21);
        mayan_nodeList.add(r22);
        mayan_nodeList.add(r23);
        mayan_nodeList.add(r24);
        mayan_nodeList.add(r26);
        mayan_nodeList.add(r27);
        mayan_nodeList.add(r28);
        mayan_nodeList.add(r29);
        mayan_nodeList.add(r211);
        mayan_nodeList.add(r212);
        mayan_nodeList.add(r213);
        mayan_nodeList.add(r214);
        mayan_nodeList.add(r216);
        mayan_nodeList.add(r217);
        mayan_nodeList.add(r218);
        mayan_nodeList.add(r219);
        mayan_nodeList.add(r31);
        mayan_nodeList.add(r32);
        mayan_nodeList.add(r33);
        mayan_nodeList.add(r34);
        mayan_nodeList.add(r36);
        mayan_nodeList.add(r37);
        mayan_nodeList.add(r38);
        mayan_nodeList.add(r39);
        mayan_nodeList.add(r311);
        mayan_nodeList.add(r312);
        mayan_nodeList.add(r313);
        mayan_nodeList.add(r314);
        mayan_nodeList.add(r316);
        mayan_nodeList.add(r317);
        mayan_nodeList.add(r318);
        mayan_nodeList.add(r319);
        mayan_nodeList.add(r41);
        mayan_nodeList.add(r42);
        mayan_nodeList.add(r43);
        mayan_nodeList.add(r44);
        mayan_nodeList.add(r46);
        mayan_nodeList.add(r47);
        mayan_nodeList.add(r48);
        mayan_nodeList.add(r49);
        mayan_nodeList.add(r411);
        mayan_nodeList.add(r412);
        mayan_nodeList.add(r413);
        mayan_nodeList.add(r414);
        mayan_nodeList.add(r416);
        mayan_nodeList.add(r417);
        mayan_nodeList.add(r418);
        mayan_nodeList.add(r419);
        ImageView r1 = findViewById(R.id.roneZero);
        ImageView r2 = findViewById(R.id.rtwoZero);
        ImageView r3 = findViewById(R.id.rthreeZero);
        ImageView r4 = findViewById(R.id.rfourZero);
        mayan_zeroList =  new ArrayList<>();
        mayan_zeroList.add(r1);
        mayan_zeroList.add(r2);
        mayan_zeroList.add(r3);
        mayan_zeroList.add(r4);

        //Roman Output
        output_roman = findViewById(R.id.output_roman);
        //Egyptian Output
        output_egypt = findViewById(R.id.output_egypt);
        er11 = findViewById(R.id.eg_r11);
        er12 = findViewById(R.id.eg_r12);
        er13 = findViewById(R.id.eg_r13);
        er21 = findViewById(R.id.eg_r21);
        er22 = findViewById(R.id.eg_r22);
        er23 = findViewById(R.id.eg_r23);
        er31 = findViewById(R.id.eg_r31);
        er32 = findViewById(R.id.eg_r32);
        er33 = findViewById(R.id.eg_r33);
        er211 = findViewById(R.id.eg2_r11);
        er212 = findViewById(R.id.eg2_r12);
        er213 = findViewById(R.id.eg2_r13);
        er221 = findViewById(R.id.eg2_r21);
        er222 = findViewById(R.id.eg2_r22);
        er223 = findViewById(R.id.eg2_r23);
        er231 = findViewById(R.id.eg2_r31);
        er232 = findViewById(R.id.eg2_r32);
        er233 = findViewById(R.id.eg2_r33);
        er311 = findViewById(R.id.eg3_r11);
        er312 = findViewById(R.id.eg3_r12);
        er313 = findViewById(R.id.eg3_r13);
        er321 = findViewById(R.id.eg3_r21);
        er322 = findViewById(R.id.eg3_r22);
        er323 = findViewById(R.id.eg3_r23);
        er331 = findViewById(R.id.eg3_r31);
        er332 = findViewById(R.id.eg3_r32);
        er333 = findViewById(R.id.eg3_r33);
        er411 = findViewById(R.id.eg4_r11);
        er412 = findViewById(R.id.eg4_r12);
        er413 = findViewById(R.id.eg4_r13);
        er421 = findViewById(R.id.eg4_r21);
        er422 = findViewById(R.id.eg4_r22);
        er423 = findViewById(R.id.eg4_r23);
        er431 = findViewById(R.id.eg4_r31);
        er432 = findViewById(R.id.eg4_r32);
        er433 = findViewById(R.id.eg4_r33);
        egypt_nodeList =  new ArrayList<>();
        egypt_nodeList.add(er11);
        egypt_nodeList.add(er12);
        egypt_nodeList.add(er13);
        egypt_nodeList.add(er21);
        egypt_nodeList.add(er22);
        egypt_nodeList.add(er23);
        egypt_nodeList.add(er31);
        egypt_nodeList.add(er32);
        egypt_nodeList.add(er33);
        egypt_nodeList.add(er211);
        egypt_nodeList.add(er212);
        egypt_nodeList.add(er213);
        egypt_nodeList.add(er221);
        egypt_nodeList.add(er222);
        egypt_nodeList.add(er223);
        egypt_nodeList.add(er231);
        egypt_nodeList.add(er232);
        egypt_nodeList.add(er233);
        egypt_nodeList.add(er311);
        egypt_nodeList.add(er312);
        egypt_nodeList.add(er313);
        egypt_nodeList.add(er321);
        egypt_nodeList.add(er322);
        egypt_nodeList.add(er323);
        egypt_nodeList.add(er331);
        egypt_nodeList.add(er332);
        egypt_nodeList.add(er333);
        egypt_nodeList.add(er411);
        egypt_nodeList.add(er412);
        egypt_nodeList.add(er413);
        egypt_nodeList.add(er421);
        egypt_nodeList.add(er422);
        egypt_nodeList.add(er423);
        egypt_nodeList.add(er431);
        egypt_nodeList.add(er432);
        egypt_nodeList.add(er433);

        //Babylonian Output
        output_bab = findViewById(R.id.output_bab);

        bab1 = findViewById(R.id.bab_one);
        bab10 = findViewById(R.id.bab_tens);
        bab_nodelist =  new ArrayList<>();
        bab_nodelist.add(bab1);
        bab_nodelist.add(bab10);

        //Converter Creation
        m = new Mayan_Converter(mayan_nodeList, mayan_zeroList);
        r = new Roman_Converter(output_roman);
        e = new Egyptian_Converter(egypt_nodeList);
        b = new Bab_Converter(bab_nodelist);

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
                for (int i = 0; i < mayan_nodeList.size(); i++) {
                    mayan_nodeList.get(i).setVisibility(View.INVISIBLE);
                }
                for (int i = 0; i < mayan_zeroList.size(); i++) {
                    mayan_zeroList.get(i).setVisibility(View.GONE);
                }
                output_roman.setText("");
                for (int i = 0; i < egypt_nodeList.size(); i++) {
                    egypt_nodeList.get(i).setVisibility(View.GONE);
                }
                for (int i = 0; i < bab_nodelist.size(); i++) {
                    bab_nodelist.get(i).setVisibility(View.GONE);
                }

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

                if (egypt_on) {
                    if (num <= 9999) {
                        e.setNum(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-9999.", Toast.LENGTH_LONG).show();
                    }
                }

                if (bab_on) {
                    if (num <= 59) {
                        b.setNum(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-59.", Toast.LENGTH_LONG).show();
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

                if(bab_on){
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www-history.mcs.st-and.ac.uk/HistTopics/Babylonian_numerals.html"));
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
            output_bab.setVisibility(View.GONE);
            mayan_on = true;
            roman_on = false;
            egypt_on = false;
            bab_on = false;
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
                output_bab.setVisibility(View.GONE);
                mayan_on = false;
                egypt_on = false;
                roman_on = true;
                bab_on = false;
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
                output_bab.setVisibility(View.GONE);
                mayan_on = false;
                bab_on = false;
                egypt_on = true;
                roman_on = false;
                //Fact check needed
                civ_detail.setText("Ancient Egypt: 3100 BC - 30 BC");
            }
        }

        if (id == R.id.action_settings_bab){
            if(!bab_on){
                Toast.makeText(MainActivity.this, "Switching to Babylonian Converter", Toast.LENGTH_LONG).show();
                output_bab.setVisibility(View.VISIBLE);
                output_roman.setVisibility(View.GONE);
                output_mayan.setVisibility(View.GONE);
                output_egypt.setVisibility(View.GONE);
                m1space.setVisibility(View.GONE);
                m2space.setVisibility(View.GONE);
                bab_on = true;
                mayan_on = false;
                egypt_on = false;
                roman_on = false;
                //Fact check needed
                civ_detail.setText("Ancient Babylonia: 1895 BC - 539 BC");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
