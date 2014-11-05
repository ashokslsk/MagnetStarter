package iampoineer.googledistance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;



import java.util.List;
import iampoineer.googledistance.controller.api.GoogleDistance;
import iampoineer.googledistance.model.beans.DistanceResult;

/**
 * Created by macbook on 20/10/14.
 */
public class MyCustomAdapter extends BaseAdapter {

    private List<DistanceResult> googleDistance;
    private Context mContext;

    public MyCustomAdapter(Context myActivity, List<DistanceResult> googleDist) {
        mContext = myActivity;
        googleDistance = googleDist;

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
       DistanceResult gdistanceitem = (DistanceResult) googleDistance.get(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView regionView = (TextView) rowView.findViewById(R.id.region);
        TextView latitudeView = (TextView) rowView.findViewById(R.id.latitude);
        TextView longitudeView = (TextView) rowView.findViewById(R.id.longitude);
        TextView depthView = (TextView) rowView.findViewById(R.id.depth);
        regionView.setText((CharSequence) gdistanceitem.getDestination_addresses());


        return null;
    }
}
