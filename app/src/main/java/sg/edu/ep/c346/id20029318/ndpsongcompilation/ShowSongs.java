package sg.edu.ep.c346.id20029318.ndpsongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSongs extends AppCompatActivity {

    Button butFilter;
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_songs);

        setTitle(getTitle().toString() + "" + "Show Song");

        butFilter = findViewById(R.id.butFilter);
        lv = findViewById(R.id.lv);

        DBHelper dbh =  new DBHelper(this);
        al = dbh.getAllSongs();
        dbh.close();

        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(ShowSongs.this,
                        ModifyActivity.class);
                i.putExtra("song", al.get(position));
                startActivity(i);
            }
        });

        butFilter.setOnClickListener((v) -> {
            DBHelper dbHelp = new DBHelper(ShowSongs.this);
            al.clear();
            al.addAll(dbHelp.getAllSongsByStars(5));
            aa.notifyDataSetChanged();
        });
    }
}