package java2.devaunteledee.com.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Spinner detailspinner = (Spinner) findViewById(R.id.detailViewSelectionSpinner);


        String[] detailArray = new String[]{
                "Detail 1",
                "Detail 2",
                "Detail 3"

        };

        ArrayAdapter<String> adapterSpinnerOne = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,detailArray);


        if (savedInstanceState == null) {




            Listfragment listFragmant = Listfragment.newInstance();


            getFragmentManager().beginTransaction().replace(R.id.ListContainer, listFragmant, listFragmant.FunnyList).commit();

            PullingApiData task = new PullingApiData(MainActivity.this);
            Log.i("TASK.......", "TASK" + task);
            task.execute("http://www.reddit.com/r/funny/hot.json");


//            FunnyAdapter adapter = new FunnyAdapter(MainActivity.this,task.theFunnySubRedditArrayList);
//
//            listFragmant.setListAdapter(adapter);

        }
        detailspinner.setAdapter(adapterSpinnerOne);
        detailspinner.setOnItemSelectedListener(itemClick);


    }

    AdapterView.OnItemSelectedListener itemClick = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {

            if (position == 0) {
                DetailFragment1 fragment = DetailFragment1.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.DetailContainer, fragment, DetailFragment1.detailFragmentTag1).commit();



            } else if (position == 1) {

                DetailFragment2 fragment = DetailFragment2.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.DetailContainer, fragment, DetailFragment2.detailFragmentTag2).commit();


            } else {
                DetailFragment3 fragment = DetailFragment3.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.DetailContainer, fragment, DetailFragment3.DetailFragment3).commit();

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    //PullingApiData task = new PullingApiData(MainActivity.this);


}
