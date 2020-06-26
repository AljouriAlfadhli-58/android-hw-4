package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText q = findViewById(R.id.EditText1);
        final EditText h = findViewById(R.id.EditText2);
        final EditText m = findViewById(R.id.EditText3);
        final EditText f = findViewById(R.id.EditText4);
        final TextView l = findViewById(R.id.Result);
        Button cal = findViewById(R.id.button);
        Button res = findViewById(R.id.button2);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q.setText("0");
                h.setText("0");
                m.setText("0");
                f.setText("0");
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //عشان اخذ القيمة من ال ايدت تيكست واحولها من سترنغ الى دوبل
                double qEditText = Double.parseDouble(q.getText().toString());
                double hEditText = Double.parseDouble(h.getText().toString());
                double mEditText = Double.parseDouble(m.getText().toString());
                double fEditText = Double.parseDouble(f.getText().toString());
                // to calculate the grades
                double calculate;
                calculate = qEditText + hEditText + mEditText + fEditText;
                GetGrade(calculate);
                l.setText("Total Score: " + calculate + " Grade: " + GetGrade(calculate));
                //l.setTextColor(ChangeBackground(calculate));
                //l.setTextColor(getResources().getColor(ChangeBackground(calculate));
                //  m.setBackgroundColor(android.R.color.holo_blue_dark);
                // l.setBackgroundColor(android.R.color.holo_blue_dark);
                //  if (calculate>=90)
                //  l.setTextColor(android.R.color.holo_purple);
                //  l.refreshDrawableState();
                //l.append(GetGrade(calculate));

                if (calculate >= 90)
                    l.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                else if (calculate >= 80)
                    l.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
                else if (calculate >= 70)
                    l.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
                else if (calculate >= 60)
                    l.setTextColor(getResources().getColor(android.R.color.darker_gray));
                else
                    l.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

                l.setTextSize(25);
                //l.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }


            public String GetGrade(double grade) {
                if (grade >= 90)
                    return "A";
                else if (grade >= 80)
                    return "B";
                else if (grade >= 70)
                    return "C";
                else if (grade >= 60)
                    return "D";
                else
                    return "F";
            }

            public int ChangeBackground(double grade) {
                if (grade >= 90)
                    return android.R.color.holo_green_dark;
                else if (grade >= 80)
                    return android.R.color.holo_green_light;
                else if (grade >= 70)
                    return android.R.color.holo_orange_dark;
                else if (grade >= 60)
                    return android.R.color.holo_orange_dark;
                else
                    return android.R.color.holo_red_dark;
            }
        });

    }
}
