package com.myapplicationdev.android.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holidays> {

    private ArrayList<Holidays> holidays;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivType;

    public HolidayAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a rowSecond

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the rowSecond.xmll as the layout for the View object
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivType = (ImageView) rowView.findViewById(R.id.ivType);

        // The parameter "position" is the index of the
        //  rowSecond ListView is requesting.
        //  We get back the food at the same index.
        Holidays currentHol = holidays.get(position);
        // Set the TextView to show the food

        tvName.setText(currentHol.getName());
        tvDate.setText(currentHol.getDate());
        for(int j=0; j<holidays.size(); j++){
            if(holidays.get(j).getName().equals("New Year's Day")){
                ivType.setImageResource(R.drawable.newyear);
            }else if(holidays.get(j).getName().equals("Labour Day")){
                ivType.setImageResource(R.drawable.labourday);
            }else if(holidays.get(j).getName().equals("Chinese New Year")){
                ivType.setImageResource(R.drawable.cny);
            }else if(holidays.get(j).getName().equals("Good Friday")){
                ivType.setImageResource(R.drawable.goodfriday);
            }
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
