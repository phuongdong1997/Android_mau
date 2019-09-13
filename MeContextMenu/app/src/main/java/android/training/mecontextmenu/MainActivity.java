package android.training.mecontextmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult    = (TextView) findViewById(R.id.tvResult);

        registerForContextMenu(tvResult);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderIcon(android.R.drawable.ic_media_play);
        menu.setHeaderTitle("Select an action");
        getMenuInflater().inflate(R.menu.context_textview, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_context_font_small:
                tvResult.setTextSize(30);
                break;
            case R.id.action_context_font_medium:
                tvResult.setTextSize(50);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
