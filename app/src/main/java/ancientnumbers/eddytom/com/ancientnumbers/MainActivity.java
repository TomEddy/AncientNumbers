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

    LinearLayout output_egypt, output_bab, output_mayan_v2,main_lay;
    TableLayout help_lay;
    TextView output_roman;
    Space m1space, m2space;
    Button convert, help, back, next;
    ImageView may11,may12,may13,may14, may21,may22,may23,may24,may31,may32,may33,may34,may41,may42,may43,may44;
    ImageView er11, er12,er13,er21,er22,er23,er31,er32,er33;
    ImageView er211, er212,er213,er221,er222,er223,er231,er232,er233;
    ImageView er311, er312,er313,er321,er322,er323,er331,er332,er333;
    ImageView er411, er412,er413,er421,er422,er423,er431,er432,er433;
    ImageView bab1,bab10,bab1_2,bab10_2,bab1_3,bab10_3,bab1_4,bab10_4;
    ArrayList<ImageView> mayan_nodeList, mayan_zeroList, egypt_nodeList, bab_nodelist;
    String[] mayan_help = new String[3];
    EditText input;
    TextView civ_detail, help_view;
    Roman_Converter r;
    Egyptian_Converter e;
    Mayan_Converter_v2 m;
    Bab_Converter b;
    int current_conv = 1;
    int help_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creating instances of all components.
        //Main Page and Help Screen
        main_lay = findViewById(R.id.main);
        help_lay = findViewById(R.id.helpLay);
        //Misc Components
        input = findViewById(R.id.input);
        civ_detail = findViewById(R.id.group_detail);
        convert = findViewById(R.id.convert);
        help = findViewById(R.id.help);


        //Creating help Strings
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        help_view = findViewById(R.id.expl_view);
        mayan_help[0] = "Each dot represents one. Each bar represents five.";
        mayan_help[1] = "Their system is base twenty.";
        mayan_help[2] = "Something Relevant";

        //Outputs
        //Mayan Output
        output_mayan_v2 = findViewById(R.id.output_mayan_v2);
        m1space = findViewById(R.id.space_one_mayan);
        m2space = findViewById(R.id.space_two_mayan);

        may11 = findViewById(R.id.may_1_1);
        may12 = findViewById(R.id.may_1_2);
        may13 = findViewById(R.id.may_1_3);
        may14 = findViewById(R.id.may_1_4);
        may21 = findViewById(R.id.may_2_1);
        may22 = findViewById(R.id.may_2_2);
        may23 = findViewById(R.id.may_2_3);
        may24 = findViewById(R.id.may_2_4);
        may31 = findViewById(R.id.may_3_1);
        may32 = findViewById(R.id.may_3_2);
        may33 = findViewById(R.id.may_3_3);
        may34 = findViewById(R.id.may_3_4);
        may41 = findViewById(R.id.may_4_1);
        may42 = findViewById(R.id.may_4_2);
        may43 = findViewById(R.id.may_4_3);
        may44 = findViewById(R.id.may_4_4);
        mayan_nodeList = new ArrayList<>();
        mayan_nodeList.add(may11);
        mayan_nodeList.add(may12);
        mayan_nodeList.add(may13);
        mayan_nodeList.add(may14);
        mayan_nodeList.add(may21);
        mayan_nodeList.add(may22);
        mayan_nodeList.add(may23);
        mayan_nodeList.add(may24);
        mayan_nodeList.add(may31);
        mayan_nodeList.add(may32);
        mayan_nodeList.add(may33);
        mayan_nodeList.add(may34);
        mayan_nodeList.add(may41);
        mayan_nodeList.add(may42);
        mayan_nodeList.add(may43);
        mayan_nodeList.add(may44);
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
        bab1_2 = findViewById(R.id.bab_ones2);
        bab10_2 = findViewById(R.id.bab_tens2);
        bab1_3 = findViewById(R.id.bab_ones3);
        bab10_3 = findViewById(R.id.bab_tens3);
        bab1_4 = findViewById(R.id.bab_ones4);
        bab10_4 = findViewById(R.id.bab_tens4);
        bab_nodelist =  new ArrayList<>();
        bab_nodelist.add(bab1);
        bab_nodelist.add(bab10);
        bab_nodelist.add(bab1_2);
        bab_nodelist.add(bab10_2);
        bab_nodelist.add(bab1_3);
        bab_nodelist.add(bab10_3);
        bab_nodelist.add(bab1_4);
        bab_nodelist.add(bab10_4);

        //Converter Creation
        m = new Mayan_Converter_v2(mayan_nodeList, mayan_zeroList);
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
                    bab_nodelist.get(i).setVisibility(View.INVISIBLE);
                }

                //Logic gates to chose the converter and set maximums for them.
                if (current_conv == 1) {
                    if (num < 160000) {
                        m.setNum(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 0-159999.", Toast.LENGTH_LONG).show();
                    }
                }

                if (current_conv == 2) {
                    if (num <= 1000 && num != 0) {
                        r.conv_num(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-1000.", Toast.LENGTH_LONG).show();
                    }
                }

                if (current_conv == 3) {
                    if (num <= 9999 && num != 0) {
                        e.setNum(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-9999.", Toast.LENGTH_LONG).show();
                    }
                }

                if (current_conv == 4) {
                    if (num <= 12959999 && num != 0) {
                        b.setNum(num);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a number within 1-12959999.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        //Help button that initiates help overlay.
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            //Probably should limit to one click or do a warning.
            public void onClick(View view) {
                Intent browInt;
                if (current_conv == 1) {
                    //browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://courses.lumenlearning.com/waymakermath4libarts/chapter/the-mayan-numeral-system/"));
                    //startActivity(browInt);
                    main_lay.setVisibility(View.GONE);
                    help_lay.setVisibility(View.VISIBLE);
                    help_view.setText(mayan_help[0]);
                }

                if (current_conv == 2) {
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.britannica.com/topic/Roman-numeral"));
                    startActivity(browInt);
                }

                if(current_conv == 3){
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://discoveringegypt.com/egyptian-hieroglyphic-writing/egyptian-mathematics-numbers-hieroglyphs/"));
                    startActivity(browInt);
                }

                if(current_conv == 4){
                    browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www-history.mcs.st-and.ac.uk/HistTopics/Babylonian_numerals.html"));
                    startActivity(browInt);
                }
                }
            });

        //Back button press inside help layout.
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            //Probably should limit to one click or do a warning.
            public void onClick(View view) {
                if (current_conv == 1) {
                   if(help_counter > 0){
                       help_counter--;
                       help_view.setText(mayan_help[help_counter]);
                       next.setText("NEXT");
                   }
                }

                if (current_conv == 2) {

                }

                if(current_conv == 3){

                }

                if(current_conv == 4){

                }
            }
        });
        //Next button press inside help layout.
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            //Probably should limit to one click or do a warning.
            public void onClick(View view) {
                if (current_conv == 1) {
                    if(help_counter == mayan_help.length-2){
                        next.setText("FINISH");
                    }
                    if(help_counter < mayan_help.length-1){
                        help_counter++;
                        help_view.setText(mayan_help[help_counter]);
                    }else{
                        help_counter = 0;
                        next.setText("NEXT");
                        main_lay.setVisibility(View.VISIBLE);
                        help_lay.setVisibility(View.GONE);
                    }
                }

                if (current_conv == 2) {

                }

                if(current_conv == 3){

                }

                if(current_conv == 4){

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

        main_lay.setVisibility(View.VISIBLE);
        help_lay.setVisibility(View.GONE);
        help_counter = 0;
        next.setText("NEXT");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_mayan) {
            if (current_conv != 1){
                Toast.makeText(MainActivity.this, "Switching to Mayan Converter", Toast.LENGTH_LONG).show();
            output_mayan_v2.setVisibility(View.VISIBLE);
            m1space.setVisibility(View.VISIBLE);
            m2space.setVisibility(View.VISIBLE);
            output_roman.setVisibility(View.GONE);
            output_egypt.setVisibility(View.GONE);
            output_bab.setVisibility(View.GONE);
            current_conv = 1;
            //Fact check needed
            civ_detail.setText("Mayan Civilization: 1800 BC - 1697 AD");
         }
        }
        if (id == R.id.action_settings_roman) {
            if(current_conv != 2) {
                Toast.makeText(MainActivity.this, "Switching to Roman Converter", Toast.LENGTH_LONG).show();
                output_roman.setVisibility(View.VISIBLE);
                output_mayan_v2.setVisibility(View.GONE);
                output_egypt.setVisibility(View.GONE);
                m1space.setVisibility(View.GONE);
                m2space.setVisibility(View.GONE);
                output_bab.setVisibility(View.GONE);
                current_conv = 2;
                //Fact check needed
                civ_detail.setText("Roman Empire: 753 BC - 1453 AD");
            }
        }

        if (id == R.id.action_settings_egypt){
            if(current_conv != 3){
                Toast.makeText(MainActivity.this, "Switching to Egyptian Converter", Toast.LENGTH_LONG).show();
                output_roman.setVisibility(View.GONE);
                output_mayan_v2.setVisibility(View.GONE);
                output_egypt.setVisibility(View.VISIBLE);
                m1space.setVisibility(View.GONE);
                m2space.setVisibility(View.GONE);
                output_bab.setVisibility(View.GONE);
                current_conv = 3;
                //Fact check needed
                civ_detail.setText("Ancient Egypt: 3100 BC - 30 BC");
            }
        }

        if (id == R.id.action_settings_bab){
            if(current_conv != 4){
                Toast.makeText(MainActivity.this, "Switching to Babylonian Converter", Toast.LENGTH_LONG).show();
                output_bab.setVisibility(View.VISIBLE);
                output_roman.setVisibility(View.GONE);
                output_mayan_v2.setVisibility(View.GONE);
                output_egypt.setVisibility(View.GONE);
                m1space.setVisibility(View.GONE);
                m2space.setVisibility(View.GONE);
                current_conv = 4;
                //Fact check needed
                civ_detail.setText("Ancient Babylonia: 1895 BC - 539 BC");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}