package iampoineer.earthquake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.magnetapi.examples.model.beans.Earthquake;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {

    private List<Earthquake> mEarthQuakes;
    private Context mContext;

    public MyCustomAdapter(Context myActivity, List<Earthquake> earthquakes) {
        mContext = myActivity;
        mEarthQuakes = earthquakes;

    }

    @Override
    public int getCount() {
        return mEarthQuakes.size();
    }

    @Override
    public Earthquake getItem(int position) {
        return mEarthQuakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Earthquake earthQuakeItem = mEarthQuakes.get(position);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView regionView = (TextView) rowView.findViewById(R.id.region);
        TextView latitudeView = (TextView) rowView.findViewById(R.id.latitude);
        TextView longitudeView = (TextView) rowView.findViewById(R.id.longitude);
        TextView depthView = (TextView) rowView.findViewById(R.id.depth);

        regionView.setText(earthQuakeItem.getRegion());
        latitudeView.setText(earthQuakeItem.getLat());
        longitudeView.setText(earthQuakeItem.getLon());
        depthView.setText(earthQuakeItem.getDepth());

        return rowView;


    }
}
