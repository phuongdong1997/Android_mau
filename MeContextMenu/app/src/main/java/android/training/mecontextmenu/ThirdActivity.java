package android.training.mecontextmenu;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvResult    = (TextView) findViewById(R.id.tvResult);
        btnResult   = (Button) findViewById(R.id.btnResult);

        registerForContextMenu(tvResult);
        registerForContextMenu(btnResult);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select The Action");
        menu.setHeaderIcon(android.R.drawable.ic_menu_share);

        if(v.getId() == R.id.tvResult){
            getMenuInflater().inflate(R.menu.context_textview, menu);
        }else  if(v.getId() == R.id.btnResult){
            getMenuInflater().inflate(R.menu.context_button, menu);
        }



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_context_font_small:
                tvResult.setTextSize(10);
                break;
            case R.id.action_context_font_medium:
                tvResult.setTextSize(30);
                break;
            case R.id.action_context_background_blue:
                btnResult.setBackgroundColor(Color.parseColor("#81BEF7"));
                break;
            case R.id.action_context_background_yellow:
                btnResult.setBackgroundColor(Color.parseColor("#F2F5A9"));
                break;
        }

        return super.onContextItemSelected(item);
    }


    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
