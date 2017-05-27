package com.example.zver.firsttry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zver on 24.05.2017.
 */

public class MyAdapter extends ArrayAdapter<Article> {
    private final Context context;
    private final Article[] values;

    public MyAdapter(Context context, Article[] values) {
        super(context, R.layout.activity_main, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_element_layout, parent, false);
        TextView viewTitle = (TextView) rowView.findViewById(R.id.title);
        TextView viewDesc = (TextView) rowView.findViewById(R.id.desc);
        ImageView icon = (ImageView) rowView.findViewById(R.id.icon);
//        Button button = (Button) rowView.findViewById(R.id.makeFavorite);
//        button.setOnClickListener(new View.OnClickListener(){
//                                      @Override
//                                      public void onClick(View view)
//                                      {
//                                          values[position].IsFavorite = true;
//                                      }
//                                  }
//        );
        icon.setImageResource(R.drawable.kaelthas);
        viewTitle.setText(values[position].Title);
        viewDesc.setText(values[position].PictureUrl);
        return  rowView;
    }

}
