package sg.edu.ep.c346.id20029318.ndpsongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText edTitle, edSingers, edYear;
RadioGroup rg;
Button butIn, butShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butIn = findViewById(R.id.butIn);
        butShow = findViewById(R.id.butShow);
        rg = findViewById(R.id.rg);
        edSingers = findViewById(R.id.edSinger);
        edYear = findViewById(R.id.edYear);
        edTitle = findViewById(R.id.edSong);

        butIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataTitle = edTitle.getText().toString().trim();
                String dataSinger = edSingers.getText().toString().trim();
                String dataYearStr = edYear.getText().toString().trim();
                int year = Integer.valueOf(dataYearStr);
                int star = getStars();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long insertSong = dbh.insertSong(dataTitle, dataSinger, year, star);

                if (insertSong != -1){
                    edTitle.setText("");
                    edSingers.setText("");
                    edYear.setText("");
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Insert failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        butShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,
                        ShowSongs.class);
                startActivity(i);
            }
        });

    }

    private int getStars(){
        int stars = 1;
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.radStar1:
                stars = 1;
                break;
            case R.id.radStar2:
                stars = 2;
                break;
            case R.id.radStar3:
                stars = 3;
                break;
            case R.id.radStar4:
                stars = 4;
                break;
            case R.id.radStar5:
                stars = 5;
                break;
        }
        return stars;
    }

    }
