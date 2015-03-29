package cz.hlubyluk.tcd;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by HlubyLuk on 29.03.15.
 */
public class ActivityDetail extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        if (getIntent().getStringExtra("text") != null) {
            TextView textView = (TextView) findViewById(R.id.dvTV);
            textView.setText(getIntent().getStringExtra("text"));
        }
    }
}
