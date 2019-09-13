package android.training.popupmenu;


import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow    = (Button) findViewById(R.id.btnShow);

    }

    public void showPopup(final View v){
        if(v.getId() == R.id.btnShow) {
            final Button btn  = (Button) v;

            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    showToast(item.getTitle().toString());
                    switch (item.getItemId()) {
                        case R.id.action_small:
                            btn.setTextSize(10);
                            break;
                        case R.id.action_medium:
                            btn.setTextSize(30);
                            break;
                        case R.id.action_large:
                            btn.setTextSize(50);
                            break;
                    }
                    return false;
                }
            });

            popupMenu.show();
        }
    }

    // Hiển thị thông báo với Toast
    public void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
