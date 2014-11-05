package iampoineer.magnetgoogleapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;


import com.magnetapi.examples.model.beans.TimeZoneResult;

import java.util.List;

/**
 * Created by macbook on 22/10/14.
 */
public class MyCustomAdapter extends BaseAdapter{

    private List<TimeZoneResult> mTimezone;
    private Context mContext;

    public MyCustomAdapter(Context MainActivity, List<TimeZoneResult> timezone){
        mContext=MainActivity;
        mTimezone=timezone;

    }




    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimeZoneResult timezoneitem = mTimezone.get(position);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_row, parent, false);
        TextView regionView = (TextView) rowView.findViewById(R.id.region);
        TextView latitudeView = (TextView) rowView.findViewById(R.id.latitude);
        TextView longitudeView = (TextView) rowView.findViewById(R.id.longitude);
        TextView depthView = (TextView) rowView.findViewById(R.id.depth);

        regionView.setText(timezoneitem.getTimeZoneName());
        latitudeView.setText(timezoneitem.getTimeZoneId());


        return rowView;
    }
}
