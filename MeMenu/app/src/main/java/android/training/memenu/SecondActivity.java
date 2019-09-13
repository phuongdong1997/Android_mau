package android.training.memenu;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult    = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItemShare = menu.add(0, 101, 10, "Share");
        menuItemShare.setIcon(android.R.drawable.ic_menu_share);
        menuItemShare.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);


        MenuItem menuItemSearch = menu.add(0, 102, 20, "Search");
        menuItemSearch.setIcon(android.R.drawable.ic_menu_search);
        menuItemSearch.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add(0, 103, 30, "Setting");
        menu.add(0, 104, 40, "Update");

        SubMenu subMenuAbout = menu.addSubMenu(0, 105, 50, "About");

        subMenuAbout.add(0, 106, 60, "About Me");
        subMenuAbout.add(0, 107, 70, "About App");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 101:
                tvResult.setText("Share");
                break;
            case 102:
                tvResult.setText("Search");
                break;
        }
        tvResult.setText(item.getTitle().toString());


        return super.onOptionsItemSelected(item);
    }

    // Hiển thị thông báo với Toast
    public void showToast(String msg){
        Toast.makeText(SecondActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
