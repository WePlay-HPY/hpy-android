package hpy.pixstreet;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

public class AsyncLoadMap extends AsyncTask<Void, Void, Void> {

    private AppCompatActivity myActivity;
    private Intent myIntent;

    public AsyncLoadMap(AppCompatActivity a) {
        myActivity = a;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Toast.makeText(myActivity, "Début du traitement asynchrone", Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        myIntent = new Intent(myActivity, OpenStreetMap.class);
        myActivity.startActivity(myIntent);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        //Toast.makeText(myActivity, "Le traitement asynchrone est terminé", Toast.LENGTH_LONG).show();
    }
}