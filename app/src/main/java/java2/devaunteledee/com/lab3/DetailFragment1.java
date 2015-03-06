package java2.devaunteledee.com.lab3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by devaunteledee on 3/6/15.
 */
public class DetailFragment1 extends Fragment {

    public static final String detailFragmentTag1 = "MyFragment.TAG";

    public static DetailFragment1 newInstance() {
        DetailFragment1 fragment = new DetailFragment1();


        Bundle args = new Bundle();


        fragment.setArguments(args);

        return fragment;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detailfragment1layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

  }
}
