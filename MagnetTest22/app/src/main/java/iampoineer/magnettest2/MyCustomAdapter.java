package iampoineer.magnettest2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;


import com.magnetapi.examples.model.beans.Datum;

import java.util.List;
import android.widget.TextView;


/**
 * Created by macbook on 23/10/14.
 */
public class MyCustomAdapter extends BaseAdapter {
    private List<Datum> mAsanUsers;
    private Context mContext;

    public MyCustomAdapter(Context MainActivity, List<Datum> asanusers){
        mContext=MainActivity;
        mAsanUsers=asanusers;
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

        Datum AsanaUserItem = mAsanUsers.get(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView id = (TextView) rowView.findViewById(R.id.id);
        TextView name = (TextView) rowView.findViewById(R.id.name);

        id.setText(AsanaUserItem.getId().toString());
        name.setText(AsanaUserItem.getName());

        return rowView;
    }
}
