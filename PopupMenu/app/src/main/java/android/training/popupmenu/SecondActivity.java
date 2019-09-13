package android.training.popupmenu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{

    private Button btnShow;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow    = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);

        popupMenu = new PopupMenu(SecondActivity.this, btnShow);

        popupMenu.getMenu().add(0, 101, 10, "Small");
        popupMenu.getMenu().add(0, 102, 20, "Medium");
        popupMenu.getMenu().add(0, 103, 30, "Large");
        popupMenu.setOnMenuItemClickListener(this);
    }


    // Hiển thị thông báo với Toast
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case 101:
                btnShow.setTextSize(10);
                break;
            case 102:
                btnShow.setTextSize(30);
                break;
            case 103:
                btnShow.setTextSize(50);
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        popupMenu.show();
    }
}
