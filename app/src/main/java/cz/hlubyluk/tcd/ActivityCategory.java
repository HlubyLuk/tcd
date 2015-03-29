package cz.hlubyluk.tcd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by HlubyLuk on 29.03.15.
 */
public class ActivityCategory extends ActionBarActivity implements CustomListViewAdapter.SelectedItem {

    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_caetgory);
        ListView listView = (ListView) findViewById(R.id.cvLv);
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), this);
        listView.setAdapter(customListViewAdapter);

    }

    @Override
    public void clickOnItem(View view) {
        Intent intent = new Intent(this, ActivityDetail.class);
        intent.putExtra("text", ((TextView) view.findViewById(R.id.rowTV)).getText());
        startActivity(intent);
    }
}
