package ddwucom.mobile.hw5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toast myToast;
    SoundPool soundPool;
    Vibrator vibrator;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToast = Toast.makeText(this,"정유경입니당><", Toast.LENGTH_SHORT);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        sound = soundPool.load(this, R.raw.baby_cry,1);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnToast:
                myToast.show();
                break;
            case R.id.btnSound:
                soundPool.play(sound, 1, 1, 0,0,1);
                break;
            case R.id.btnVibration:
                vibrator.vibrate(1000);
                vibrator.vibrate(new long[] {100, 100, 50, 200}, 0);
                vibrator.cancel();
                break;
        }

    }
}
