package java2.devaunteledee.com.lab3;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Listfragment extends ListFragment  {

    public static final String FunnyList = "MyListFragment.TAG";



    public static Listfragment newInstance(){
        Listfragment funnyList = new Listfragment();
        return funnyList;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] strings = new String[]{"1","3","5","1","3","5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,strings);



        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        String selected = (String)l.getAdapter().getItem(position);
    }

}
