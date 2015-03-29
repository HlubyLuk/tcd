package cz.hlubyluk.tcd;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by HlubyLuk on 29.03.15.
 */
public class FragmentNavigation extends Fragment implements View.OnClickListener {

    ClickedButton clickedButton;

    public static FragmentNavigation newInstance() {
        return new FragmentNavigation();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        clickedButton = (ClickedButton) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        for (int i = 0; i < ((LinearLayout) view).getChildCount(); i++) {
            if (((LinearLayout) view).getChildAt(i) instanceof Button) {
                ((LinearLayout) view).getChildAt(i).setOnClickListener(this);
            }
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        clickedButton.clickedButton(view);
    }

    public interface ClickedButton {
        void clickedButton(View view);
    }
}
