package ancientnumbers.eddytom.com.ancientnumbers;

import android.widget.TextView;

public class Roman_Converter {
    TextView output_roman;
    int hund_count;
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

        hund_count = 0;
        num = recordingHundreds(num);
        if (num >= 90) {
            output_roman.setText(String.format("%sC", output_roman.getText().toString()));
            num = num - 90;
            if (num < 10) {
                output_roman.setText(String.format("X%s", output_roman.getText().toString()));
            } else {
                num = num - 10;
            }
        }

        if (num >= 40) {
            output_roman.setText(String.format("%sL", output_roman.getText().toString()));
            num = num - 40;
            if (num < 10) {
                output_roman.setText(String.format("X%s", output_roman.getText().toString()));
            } else {
                num = num - 10;
            }
        }
        num = recordingTens(num);
        if (num > 0) {
            output_roman.setText(String.format("%s%s", output_roman.getText().toString(), romanNums[num - 1]));
        }

        for(int i= 0; i < hund_count; i++){
            output_roman.setText(String.format("C%s", output_roman.getText().toString()));
        }
    }
    private int recordingTens(int num){
        while(num >= 10){
            output_roman.setText(String.format("%sX", output_roman.getText().toString()));
            num = num - 10;
        }
        return num;
    }

    private int recordingHundreds(int num){
        while(num > 100){
            hund_count++;
            num = num - 100;
        }
        return num;
    }
}
