package sg.edu.rp.c346.id22012433.cyberball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
EditText etUserName;
ToggleButton toggleMode;
Button btnLoad;
Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.etUserName);
        toggleMode = findViewById(R.id.toggleMode);
        btnLoad = findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                String msg;

                if (toggleMode.isChecked()) {
                    msg = prefs.getString("MultiName", "Player X");
                } else {
                    msg = prefs.getString("SoloName", "Solo Player X");
                }
                etUserName.setText(msg);
            }

        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefEdit = prefs.edit();

                String name = etUserName.getText().toString();
                if (toggleMode.isChecked()) {
                   prefEdit.putString("MultiName", name);
                } else {
                   prefEdit.putString("SoloName", name);
                }
                prefEdit.commit();
            }
        });
    }
}