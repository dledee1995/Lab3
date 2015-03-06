package java2.devaunteledee.com.lab3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FunnyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Funny> mObjects;

    private static final long ID_CONSTANT = 123456789;

    public FunnyAdapter(Context mContext, ArrayList<Funny> mObjects) {
        this.mContext = mContext;
        this.mObjects = mObjects;
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Funny getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ID_CONSTANT + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listlayout, parent, false);
        }

        Funny item = getItem(position);
        TextView textView1 = (TextView)convertView.findViewById(R.id.NameOF);


        textView1.setText(item.name);

        Log.i("a", "a:...." + convertView);

        return convertView;
//        return null;
    }
}
