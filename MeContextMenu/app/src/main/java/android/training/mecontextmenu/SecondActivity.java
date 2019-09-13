package android.training.mecontextmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult    = (TextView) findViewById(R.id.tvResult);
        registerForContextMenu(tvResult);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select The Action");
        menu.setHeaderIcon(android.R.drawable.ic_menu_share);

        menu.add(Menu.NONE, 101, 0, "Small");
        menu.add(Menu.NONE, 102, 1, "Medium");
        menu.add(Menu.NONE, 103, 2, "Large");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String currentTitle = item.getTitle().toString();

        if(currentTitle.equals("Small")){
            tvResult.setTextSize(10);
        }else if(currentTitle.equals("Medium")){
            tvResult.setTextSize(30);
        }else{
            tvResult.setTextSize(50);
        }

        return super.onContextItemSelected(item);
    }


    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
