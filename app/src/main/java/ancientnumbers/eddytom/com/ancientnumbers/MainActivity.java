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
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout output_egypt;
    private LinearLayout output_bab;
    private LinearLayout output_mayan_v2;
    private LinearLayout main_lay;
    private TableLayout help_lay;
    private TextView output_roman;
    private Space m1space;
    private Space m2space;
    private Button next;
    private ArrayList<ImageView> mayan_nodeList;
    private ArrayList<ImageView> mayan_zeroList;
    private ArrayList<ImageView> egypt_nodeList;
    private ArrayList<ImageView> bab_nodelist;
    private final String[] mayan_help = new String[6];
    private final String[] roman_help = new String[6];
    private final String[] bab_help = new String[3];
    private final String[] egypt_help = new String[3];
    private EditText input;
    private TextView civ_detail;
    private TextView help_view;
    private Roman_Converter r;
    private Egyptian_Converter e;
    private Mayan_Converter_v2 m;
    private Bab_Converter b;
    private int current_conv = 1;
    private int help_counter = 0;

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
        Button convert = findViewById(R.id.convert);
        Button help = findViewById(R.id.help);

        //Creating help Strings
        // Create webrowser button usable on final note slide taking user to further help online.
        Button back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        helpComments();

        //Outputs
        //Mayan Output
        mayanSetup();
        //Roman Output
        output_roman = findViewById(R.id.output_roman);
        //Egyptian Output
        egyptianSetup();
        //Babylonian Output
        babSetup();

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
                //Intent browInt;
                if (current_conv == 1) {
                    //browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://courses.lumenlearning.com/waymakermath4libarts/chapter/the-mayan-numeral-system/"));
                    //startActivity(browInt);
                    main_lay.setVisibility(View.GONE);
                    help_lay.setVisibility(View.VISIBLE);
                    help_view.setText(mayan_help[0]);
                }

                if (current_conv == 2) {
                    main_lay.setVisibility(View.GONE);
                    help_lay.setVisibility(View.VISIBLE);
                    help_view.setText(roman_help[0]);
                   // browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.britannica.com/topic/Roman-numeral"));
                   // startActivity(browInt);
                }

                if(current_conv == 3){
                    main_lay.setVisibility(View.GONE);
                    help_lay.setVisibility(View.VISIBLE);
                    help_view.setText(egypt_help[0]);
                   // browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://discoveringegypt.com/egyptian-hieroglyphic-writing/egyptian-mathematics-numbers-hieroglyphs/"));
                    //startActivity(browInt);
                }

                if(current_conv == 4){
                    main_lay.setVisibility(View.GONE);
                    help_lay.setVisibility(View.VISIBLE);
                    help_view.setText(bab_help[0]);
                   // browInt = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www-history.mcs.st-and.ac.uk/HistTopics/Babylonian_numerals.html"));
                    //startActivity(browInt);
                }
                }
            });

        //Back button press inside help layout.
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            //Probably should limit to one click or do a warning.
            public void onClick(View view) {
                if (help_counter > 0) {
                    help_counter--;
                    next.setText(R.string.next);
                    if (current_conv == 1) {
                        help_view.setText(mayan_help[help_counter]);
                    }
                    if (current_conv == 2) {
                        help_view.setText(roman_help[help_counter]);
                    }
                    if (current_conv == 3) {
                        help_view.setText(egypt_help[help_counter]);
                    }
                    if (current_conv == 4) {
                        help_view.setText(bab_help[help_counter]);
                    }
                }
            }
        });
        //Next button press inside help layout.
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            //Probably should limit to one click or do a warning.
            public void onClick(View view) {
                int length = 0;
                String[] current = null;
                if (current_conv == 1) {
                    length = mayan_help.length;
                    current = mayan_help;
                }

                if (current_conv == 2) {
                    length = roman_help.length;
                    current = roman_help;
                }

                if(current_conv == 3){
                    length = egypt_help.length;
                    current = egypt_help;
                }

                if(current_conv == 4){
                    length = bab_help.length;
                    current = bab_help;
                }

                if(help_counter == length-2){
                    next.setText(R.string.finish);
                }
                if(help_counter < length-1){
                    help_counter++;
                    if (current != null) {
                        help_view.setText(current[help_counter]);
                    }
                }else{
                    help_counter = 0;
                    next.setText(R.string.next);
                    main_lay.setVisibility(View.VISIBLE);
                    help_lay.setVisibility(View.GONE);
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
        next.setText(R.string.next);
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
    //Babylonian Output
    private void babSetup(){
        output_bab = findViewById(R.id.output_bab);
        ImageView bab1 = findViewById(R.id.bab_one);
        ImageView bab10 = findViewById(R.id.bab_tens);
        ImageView bab1_2 = findViewById(R.id.bab_ones2);
        ImageView bab10_2 = findViewById(R.id.bab_tens2);
        ImageView bab1_3 = findViewById(R.id.bab_ones3);
        ImageView bab10_3 = findViewById(R.id.bab_tens3);
        ImageView bab1_4 = findViewById(R.id.bab_ones4);
        ImageView bab10_4 = findViewById(R.id.bab_tens4);
        bab_nodelist =  new ArrayList<>();
        bab_nodelist.add(bab1);
        bab_nodelist.add(bab10);
        bab_nodelist.add(bab1_2);
        bab_nodelist.add(bab10_2);
        bab_nodelist.add(bab1_3);
        bab_nodelist.add(bab10_3);
        bab_nodelist.add(bab1_4);
        bab_nodelist.add(bab10_4);
    }
    //Mayan Output
    private void mayanSetup(){
        output_mayan_v2 = findViewById(R.id.output_mayan_v2);
        m1space = findViewById(R.id.space_one_mayan);
        m2space = findViewById(R.id.space_two_mayan);

        ImageView may11 = findViewById(R.id.may_1_1);
        ImageView may12 = findViewById(R.id.may_1_2);
        ImageView may13 = findViewById(R.id.may_1_3);
        ImageView may14 = findViewById(R.id.may_1_4);
        ImageView may21 = findViewById(R.id.may_2_1);
        ImageView may22 = findViewById(R.id.may_2_2);
        ImageView may23 = findViewById(R.id.may_2_3);
        ImageView may24 = findViewById(R.id.may_2_4);
        ImageView may31 = findViewById(R.id.may_3_1);
        ImageView may32 = findViewById(R.id.may_3_2);
        ImageView may33 = findViewById(R.id.may_3_3);
        ImageView may34 = findViewById(R.id.may_3_4);
        ImageView may41 = findViewById(R.id.may_4_1);
        ImageView may42 = findViewById(R.id.may_4_2);
        ImageView may43 = findViewById(R.id.may_4_3);
        ImageView may44 = findViewById(R.id.may_4_4);
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
    }
    //Egyptian Output
    private void egyptianSetup(){
        output_egypt = findViewById(R.id.output_egypt);
        ImageView er11 = findViewById(R.id.eg_r11);
        ImageView er12 = findViewById(R.id.eg_r12);
        ImageView er13 = findViewById(R.id.eg_r13);
        ImageView er21 = findViewById(R.id.eg_r21);
        ImageView er22 = findViewById(R.id.eg_r22);
        ImageView er23 = findViewById(R.id.eg_r23);
        ImageView er31 = findViewById(R.id.eg_r31);
        ImageView er32 = findViewById(R.id.eg_r32);
        ImageView er33 = findViewById(R.id.eg_r33);
        ImageView er211 = findViewById(R.id.eg2_r11);
        ImageView er212 = findViewById(R.id.eg2_r12);
        ImageView er213 = findViewById(R.id.eg2_r13);
        ImageView er221 = findViewById(R.id.eg2_r21);
        ImageView er222 = findViewById(R.id.eg2_r22);
        ImageView er223 = findViewById(R.id.eg2_r23);
        ImageView er231 = findViewById(R.id.eg2_r31);
        ImageView er232 = findViewById(R.id.eg2_r32);
        ImageView er233 = findViewById(R.id.eg2_r33);
        ImageView er311 = findViewById(R.id.eg3_r11);
        ImageView er312 = findViewById(R.id.eg3_r12);
        ImageView er313 = findViewById(R.id.eg3_r13);
        ImageView er321 = findViewById(R.id.eg3_r21);
        ImageView er322 = findViewById(R.id.eg3_r22);
        ImageView er323 = findViewById(R.id.eg3_r23);
        ImageView er331 = findViewById(R.id.eg3_r31);
        ImageView er332 = findViewById(R.id.eg3_r32);
        ImageView er333 = findViewById(R.id.eg3_r33);
        ImageView er411 = findViewById(R.id.eg4_r11);
        ImageView er412 = findViewById(R.id.eg4_r12);
        ImageView er413 = findViewById(R.id.eg4_r13);
        ImageView er421 = findViewById(R.id.eg4_r21);
        ImageView er422 = findViewById(R.id.eg4_r22);
        ImageView er423 = findViewById(R.id.eg4_r23);
        ImageView er431 = findViewById(R.id.eg4_r31);
        ImageView er432 = findViewById(R.id.eg4_r32);
        ImageView er433 = findViewById(R.id.eg4_r33);
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
    }
    private void helpComments(){
        help_view = findViewById(R.id.expl_view);
        mayan_help[0] = "Each dot represents one. Each bar represents five. Each empty shell represents zero.";
        mayan_help[1] = "Their system is base twenty. Meaning the place value is dictated by powers of twenty.";
        mayan_help[2] = "For numbers one through nineteen they are simply represented with the corresponding bars and dots.";
        mayan_help[3] = "Once a number exceeds twenty bars and dots are placed in higher categories representing the incrementing powers of twenty.";
        mayan_help[4] = "For example 124, one bar will be placed in the top category worth 100 (20^1*5). Atop that bar one dot will be placed worth 20 (20^1).";
        mayan_help[5] = "The remainder is 4, four dots will be placed in the lower category worth 1 each (20^0). ";

        bab_help[0] = "One through nine are represented with stacked triangles. Tens (ten,twenty, thirty up to fifty) are represented by sideways larger triangles.";
        bab_help[1] = "Their system is base sixty. Meaning the place value is dictated by powers of sixty.";
        bab_help[2] = "Once a number exceeds sixty triangles are placed in categories further to the left representing the incrementing powers of sixty.";

        egypt_help[0] = "The ancient egyptian numeral system is much closer to what we are used to today.";
        egypt_help[1] = "Their system is base ten identical to our own. Ones, tens, hundreds and so on each have a corresponding symbol.";
        egypt_help[2] = "A number is broken down into its powers of ten and constructed with the highest value symbols on the left.";

        roman_help[0] = "Ancient romans used roman numerals. I, II, III were one, two and three respectively.";
        roman_help[1] = "Larger numbers: V = 5, X = 10, L = 50, C = 100,D = 500, M = 1000.";
        roman_help[2] = "But what about all the numbers in between? This is where placement comes into play.";
        roman_help[3] = "Placing a numeral before another one subtracts its value. Example: placing an I before V represents four as IV.";
        roman_help[4] = "Placing a numeral after another one adds its value. Example: placing an II after V represents seven as VII.";
        roman_help[5] = "This method is used to construct their entire numeral system.";
    }
}