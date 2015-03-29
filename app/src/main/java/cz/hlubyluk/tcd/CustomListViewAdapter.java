package cz.hlubyluk.tcd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by HlubyLuk on 29.03.15.
 */
public class CustomListViewAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;
    private SelectedItem selectedItem;


    public CustomListViewAdapter(Context context, ActivityCategory activityCategory) {
        this.context = context;
        this.selectedItem = (SelectedItem) activityCategory;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.row1, viewGroup, false);
        view.setOnClickListener(this);
        TextView tv = (TextView) view.findViewById(R.id.rowTV);
        tv.setText("Položka číslo: " + i);
        return view;
    }

    @Override
    public void onClick(View view) {
        selectedItem.clickOnItem(view);
    }

    public interface SelectedItem {
        void clickOnItem(View view);
    }
}
