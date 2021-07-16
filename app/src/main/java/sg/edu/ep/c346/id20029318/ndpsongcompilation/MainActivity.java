package sg.edu.ep.c346.id20029318.ndpsongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView songTitle, singers, year, stars;
EditText edTitle, edSingers, edYear, edStars;
RadioButton rad1, rad2, rad3, rad4, rad5;
Button butIn, butShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
