package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button button;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view_id);
        editText = findViewById(R.id.edit_text_id);
        button = findViewById(R.id.button_id);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.light_item, R.id.item_id);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String item = editText.getText().toString(); // pobieranie tekstu z EditText
                        arrayAdapter.add(item); // dodanie punktu do listy z tekstem item
                        arrayAdapter.notifyDataSetChanged();
                        editText.setText(""); // zerowanie tekstu w EditText
                    }
                }
        );

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_item:
                Toast.makeText(getApplicationContext(),
                        getString(R.string.author_name),
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_clear_item:
                arrayAdapter.clear();
                arrayAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}