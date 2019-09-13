package android.myevent;

import android.training.eventlisteners.R;
import android.view.View;
import android.widget.TextView;

public class EventButton implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        TextView textViewResult  = (TextView) v.getRootView().findViewById(R.id.tvResult);
        textViewResult.setText("Explicit listener class");
    }
}
