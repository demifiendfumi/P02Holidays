package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvType = (ListView) this.findViewById(R.id.lvTypes);

        final String[] type = new String[] { "Secular","Ethnic & Religion"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.tvType, type);


        // Assign adapter to ListView
        lvType.setAdapter(adapter);

        lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = String.valueOf(lvType.getItemIdAtPosition(position));
                String selectedTypeArray = type[Integer.valueOf(selectedType)];

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("type",selectedTypeArray);
                startActivity(i);
            }
        });
    }
}
