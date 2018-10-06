package ancientnumbers.eddytom.com.ancientnumbers;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/*
Roman_Converter
Class responsible for converting numbers into roman numerals.
Constructor: Textview out is a textview which displays the answer.
Methods: conv_num method which converts the desired number.
         recordingPlaceValue supplementary method which determines place value.
*/
public class Roman_Converter extends AppCompatActivity {
    private final TextView output_roman;
    public Roman_Converter(){
        output_roman = null;
    }
    Roman_Converter(TextView out){
        output_roman = out;
    }

    public void conv_num(int num){
        String[] romanNums = new String[9];
        romanNums[0] = "I";
        romanNums[1] = "II";
        romanNums[2] = "III";
        romanNums[3] = "IV";
        romanNums[4] = "V";
        romanNums[5] = "VI";
        romanNums[6] = "VII";
        romanNums[7] = "VIII";
        romanNums[8] = "IX";

        String[] romanBigNums = new String[5];
        romanBigNums[0] = "X";
        romanBigNums[1] = "L";
        romanBigNums[2] = "C";
        romanBigNums[3] = "D";
        romanBigNums[4] = "M";
        int counter = 0;

        while(counter <= 1) {
         if(output_roman != null){
            int divisor = 1;
            for (int i = 0; i < counter; i++) {
                divisor = divisor * 10;
            }
            if (num >= 900 / divisor) {
                num = num - 900 / divisor;
                if (num < 100 / divisor) {
                    output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanBigNums[romanBigNums.length - 3 - 2 * counter]));
                    output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanBigNums[romanBigNums.length - 1 - 2 * counter]));
                } else {
                    num = num - 100 / divisor;
                    output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanBigNums[romanBigNums.length - 1 - 2 * counter]));
                }
            }

            if (num >= 400 / divisor) {
                num = num - 400 / divisor;
                if (num < 100 / divisor) {
                    output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanBigNums[romanBigNums.length - 3 - 2 * counter]));
                    output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanBigNums[romanBigNums.length - 2 - 2 * counter]));
                } else {
                    num = num - 100 / divisor;
                    output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanBigNums[romanBigNums.length - 2 - 2 * counter]));
                }
            }

            num = recordingPlaceValues(num, divisor, romanBigNums[romanBigNums.length - 3 - 2 * counter]);
            counter++;
        }
        }

        if (num > 0) {
            output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanNums[num - 1]));
        }
    }

    private int recordingPlaceValues(int num, int divisor, String numeral){
        while(num >= 100/divisor && output_roman!=null){
            output_roman.setText(String.format("%s%s", output_roman.getText().toString(),numeral));
            num = num - 100/divisor;
        }
        return num;
    }
}