package iampoineer.espn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.magnetapi.examples.model.beans.SportsNewsResult;

import java.util.List;
import android.view.LayoutInflater;


/**
 * Created by macbook on 23/10/14.
 */


public class MyCustomAdapter extends BaseAdapter {

    private List<SportsNewsResult> mSportnews;
    private Context mcontext;

    public MyCustomAdapter(Context MyActivity,List<SportsNewsResult> sportnews){
        mcontext=MyActivity;
        mSportnews=sportnews;
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

        SportsNewsResult sportnewsitem = mSportnews.get(position);
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        


        return null;
    }
}
