package ddwucom.mobile.hw7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

     MyCircle myCircle;
     int variableColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircle = findViewById(R.id.myCircle);
        registerForContextMenu(myCircle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        MenuItem item1 = menu.findItem(R.id.red);
        MenuItem item2 = menu.findItem(R.id.green);
        MenuItem item3 = menu.findItem(R.id.blue);

        variableColor = myCircle.getPaintColor();
        Log.d("you", "variableColor: "+ myCircle.getPaintColor());

        if(variableColor == Color.RED) {
            item1.setChecked(true);
        }
        if(variableColor == Color.GREEN) {
            item2.setChecked(true);
        }
        if(variableColor == Color.BLUE) {
            item3.setChecked(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.big:
                myCircle.setCircleR(myCircle.getCircleR() + 100);
                break;
            case R.id.small:
                myCircle.setCircleR(myCircle.getCircleR() - 100);
                break;
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                myCircle.setPaintColor(Color.RED);
                Log.d("you", "getRedColor: "+ myCircle.getPaintColor());
                break;
            case R.id.green:
                myCircle.setPaintColor(Color.GREEN);
                Log.d("you", "getGreenColor: "+ myCircle.getPaintColor());
                break;
            case R.id.blue:
                myCircle.setPaintColor(Color.BLUE);
                Log.d("you", "getBlueColor: "+ myCircle.getPaintColor());
                break;
        }
        return true;
    }

}
