package sg.edu.ep.c346.id20029318.ndpsongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ModifyActivity extends AppCompatActivity {

    EditText edID, edSong, edSinger, edYear;
    RadioGroup rg;
    RadioButton r1, r2, r3, r4, r5;
    Button butUpdate, butDelete, butCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        edID = findViewById(R.id.edID);
        edSinger = findViewById(R.id.edSinger);
        edSong = findViewById(R.id.edSong);
        edYear = findViewById(R.id.edYear);
        rg = findViewById(R.id.rg);
        butCancel = findViewById(R.id.butCancel);
        butDelete = findViewById(R.id.butDelete);
        butUpdate = findViewById(R.id.butUpdate);

        Intent i = getIntent();
        final Song currentSong = (Song) i.getSerializableExtra("song");
        edID.setText(currentSong.getId()+"");
        edSong.setText(currentSong.getTitle());
        edSinger.setText(currentSong.getSingers());
        edYear.setText(currentSong.getYear()+"");

        switch (currentSong.getStars()) {
            case 1:
                 r1.setChecked(true);
                break;
            case 2:
                r2.setChecked(true);
                break;
            case 3:
                r3.setChecked(true);
                break;
            case 4:
                r4.setChecked(true);
                break;
            case 5:
                r5.setChecked(true);
                break;
        }

        butCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        butUpdate.setOnClickListener(( v )-> {
            DBHelper dbh = new DBHelper(ModifyActivity.this);
            currentSong.setTitle(edSong.getText().toString().trim());
            currentSong.setSingers(edSinger.getText().toString().trim());
            int year = Integer.valueOf(edYear.getText().toString().trim());
            currentSong.setYear(year);

            int selectRB = rg.getCheckedRadioButtonId();
            RadioButton radbut = (RadioButton) findViewById(selectRB);
            currentSong.setStars(Integer.parseInt(radbut.getText().toString()));

            int result = dbh.updateSong(currentSong);
            finish();


        });

        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper((ModifyActivity.this));
                int result = dbh.deleteSong(currentSong.getId());
                finish();
            }
        });


    }
}