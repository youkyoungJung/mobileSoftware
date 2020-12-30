package ddwucom.mobile.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayout);
    }

    public void onClick (View v){

        switch(v.getId()){
            case R.id.btnvertical:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
            case R.id.btnhorizontal:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;

        }
    }
}
