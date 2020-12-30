package ddwucom.mobile.hw7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.jjazang:
                Toast.makeText(this,"짜장면은 춘장으로 만듭니다",
                        Toast.LENGTH_SHORT).show();
            break;
            case R.id.jjamppong:
                Toast.makeText(this, "짬뽕은 돼지고기 들어가야 맛있습니다.",
                        Toast.LENGTH_SHORT).show();
            break;
        }
        return true;
    }

    public void onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.kimchi:
                Toast.makeText(this,"김치찌개는 신김치로 끓여야 제맛입니다.",
                        Toast.LENGTH_SHORT).show();
            break;
            case R.id.tufu:
                Toast.makeText(this,"순두부찌개는 계란이 생명입니다.",
                        Toast.LENGTH_SHORT).show();
            break;
        }
    }
}
