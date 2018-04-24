package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lvH;
    TextView tv_title;

    ArrayAdapter aa;
    ArrayList<Holidays> holidays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvH = (ListView) this.findViewById(R.id.lvList);
        tv_title = (TextView) findViewById(R.id.tvTitle);

        // Create a few objects in array
        holidays = new ArrayList<Holidays>();

        Intent i = getIntent();
        String types = i.getStringExtra("type");
        tv_title.setText(types);

        if(tv_title.getText().equals("Secular")) {
            holidays.add(new Holidays( "New Year's Day", "1 Jan 2017"));
            holidays.add(new Holidays( "Labour Day", "1 May 2017"));
        }else if(tv_title.getText().equals("Ethnic & Religion")) {
            holidays.add(new Holidays( "Chinese New Year", "28-29 Jan 2017"));
            holidays.add(new Holidays( "Good Friday", "14 April 2017"));
        }
        aa = new HolidayAdapter(this, R.layout.row2, holidays);
        lvH.setAdapter(aa);


        lvH.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedHol = holidays.get(position);
                Toast.makeText(Main2Activity.this, selectedHol.getName()
                                + " Date: " + selectedHol.getDate(),
                        Toast.LENGTH_LONG).show();


            }
        });

    }
}
