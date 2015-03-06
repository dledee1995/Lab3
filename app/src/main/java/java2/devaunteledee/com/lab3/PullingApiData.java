package java2.devaunteledee.com.lab3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class PullingApiData extends AsyncTask<String,Integer,String> {
    ProgressDialog progressDialog;
    String _title;
    String _Author;
    String jsonString;
    String _numberOfComments;
    String _thumbnail;
 private Context mContext;
    ArrayList<Funny> theFunnySubRedditArrayList;

    public PullingApiData(Context context) {
           mContext = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setProgressStyle((ProgressDialog.STYLE_SPINNER));
        progressDialog.setMessage("Loading ");
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressPercentFormat(null);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            //URL connection check
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            jsonString = IOUtils.toString(is);
            is.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {


        super.onPostExecute(s);

        try{
            //JSON
            JSONObject outerObject = new JSONObject(jsonString);

            JSONArray childrenArray = outerObject.getJSONObject("data").getJSONArray("children");
            for (int i = 0; i < childrenArray.length(); i++){
                JSONObject childObject = childrenArray.getJSONObject(i).getJSONObject("data");

                if(childObject.has("title")){
                    _title = childObject.getString("title");
                    Log.e("Title", _title);
                }else{
                    _title = "N/A";
                }
                if (childObject.has("author")){
                    _Author = childObject.getString("author");
                    Log.i("Author",_Author);
                }else{
                    _Author = "N/A";

                }if(childObject.has("thumbnail")){
                    _thumbnail = childObject.getString("thumbnail");
                    Log.i("_thumbnail",_thumbnail);
                }else{
                _thumbnail = "N/A";
                }if(childObject.has("num_comments")){
                    _numberOfComments = childObject.getString("num_comments");
                    Log.i("_numberOfComments",_numberOfComments);
                }else{
                    _numberOfComments = "N/A";
                }

            theFunnySubRedditArrayList = new ArrayList<>();
                 theFunnySubRedditArrayList.add(new Funny(_title,_Author,_numberOfComments,_thumbnail));
//                Log.i("a","a... " + Funny);
            }
        }catch (JSONException e){
            e.printStackTrace();
            Log.e("ERROR.........", "ERROR FOR ARRAY LIST");

        }



        progressDialog.dismiss();

    }
}
