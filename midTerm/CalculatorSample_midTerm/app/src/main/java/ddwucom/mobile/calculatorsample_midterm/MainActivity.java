/*
과제명 : 2020년1학기_모바일소프트웨어_중간평가과제
분반 : 02
학번 : 20181013
성명 : 정유경
제출일 : 2020년 5월 14일

<가선점 기능 구현>
1.화면디자인 개선
    버튼색상, 버튼xml, 이미지, 글씨크기, 글씨체, 소리 등

2.오류처리
    문제 발생시 토스트를 이용하여 오류메시지를 띄우고 다시 진행.

3. 연속 계산 기능

가산점 항목 모두 완료하였습니다.

*/
package ddwucom.mobile.calculatorsample_midterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    LayoutInflater inflater;
    EditText editText;// 상단에 숫자값과 결과가 보여짐
    Toast myToast;

    Button add, sub, multi, div, clear; //연산자, 익명 내부클래스, 임시객체
    Button answer; //익명 내부 클래스
    Button power, s_root, sin; // 공학 계산기 연산자
    //피연산자
    String num;

    //사칙연산 확인
    int value = -1;

    int ADD = 0;
    int SUB = 1;
    int MULTI = 2;
    int DIV = 3;
    int C = 7;

    //공학계산기 연산자
    int POWER = 4;
    int S_ROOT = 5;
    int SIN = 6;

    //클릭시 소리 넣어줌
    SoundPool soundPool;
    int sound;

    //연속 연산 계산기 - ArrayList를 이용하여 저장
    ArrayList<Double>history = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etDisplay);

        num = "";

        //answer 버튼 연결
        answer = findViewById(R.id.btnAnswer);
        answer.setOnClickListener(mListener);

        //연산자 버튼 생성
        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        multi= findViewById(R.id.btnMulti);
        div = findViewById(R.id.btnDiv);
        clear = findViewById(R.id.btnClear);

        //클릭시 소리 넣어줌
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        sound = soundPool.load(this,R.raw.wrong_answer,1);

        history.add(0.0);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("you", "history=> "+ history);
                editText.setHint("+");
                if(value == ADD) {
                    history.add(((history.get(history.size() - 1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == SUB){
                    history.add(((history.get(history.size() - 1)) - Double.parseDouble(editText.getText().toString())));
                }else if(value == MULTI){
                    history.add(((history.get(history.size() - 1)) * Double.parseDouble(editText.getText().toString())));
                }else if(value == DIV){
                    history.add(((history.get(history.size() - 1)) / Double.parseDouble(editText.getText().toString())));
                }else {
                    history.add(((history.get(history.size() - 1)) + Double.parseDouble(editText.getText().toString())));
                }
                editText.setText("");//내용물 비우기
                value = ADD;
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setHint("-");
                if(value == -1) {
                    history.add(((history.get(history.size()-1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == SUB){
                    history.add(((history.get(history.size() - 1)) - Double.parseDouble(editText.getText().toString())));
                }else if(value == ADD) {
                    history.add(((history.get(history.size() - 1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == MULTI){
                    history.add(((history.get(history.size() - 1)) * Double.parseDouble(editText.getText().toString())));
                }else if(value == DIV){
                    history.add(((history.get(history.size() - 1)) / Double.parseDouble(editText.getText().toString())));
                }
                editText.setText("");//내용물 비우기
                value = SUB;
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setHint("*");
                if(value == -1) {
                    history.add(((history.get(history.size()-1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == MULTI){
                    history.add(((history.get(history.size() - 1)) * Double.parseDouble(editText.getText().toString())));
                }if(value == ADD) {
                    history.add(((history.get(history.size() - 1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == SUB){
                    history.add(((history.get(history.size() - 1)) - Double.parseDouble(editText.getText().toString())));
                }else if(value == DIV){
                    history.add(((history.get(history.size() - 1)) / Double.parseDouble(editText.getText().toString())));
                }
                editText.setText("");//내용물 비우기
                value = MULTI;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setHint("/");
                if(value == -1) {
                    history.add(((history.get(history.size()-1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == DIV){
                    history.add(((history.get(history.size() - 1)) / Double.parseDouble(editText.getText().toString())));
                }else if(value == MULTI){
                    history.add(((history.get(history.size() - 1)) * Double.parseDouble(editText.getText().toString())));
                }if(value == ADD) {
                    history.add(((history.get(history.size() - 1)) + Double.parseDouble(editText.getText().toString())));
                }else if(value == SUB){
                    history.add(((history.get(history.size() - 1)) - Double.parseDouble(editText.getText().toString())));
                }
                editText.setText("");//내용물 비우기
                value = DIV;
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = "";
                editText.setText("");//내용물 비우기
                value = -1;
                history.clear();
                history.add(0.0);
            }
        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnAnswer:
                    soundPool.play(sound, 1, 1,0,0,1);

                    while(true) {
                        if (value == ADD) {
                            editText.setHint("");
                            editText.setText(""+ ((history.get(history.size()-1)) + Double.parseDouble(editText.getText().toString())));
                        } else if (value == SUB) {
                            editText.setHint("");
                            editText.setText(""+ ((history.get(history.size()-1)) - Double.parseDouble(editText.getText().toString())));
                        } else if (value == MULTI) {
                            editText.setHint("");
                            editText.setText(""+ ((history.get(history.size()-1)) * Double.parseDouble(editText.getText().toString())));
                        } else if (value == DIV) {
                            editText.setHint("");
                            editText.setText(""+ ((history.get(history.size()-1)) / Double.parseDouble(editText.getText().toString())));
                        }
                        //공학계산기
                        else if (value == POWER) {
                            editText.setText("" +
                                    Math.pow((Double.parseDouble(num)),
                                            Double.parseDouble(editText.getText().toString())));
                            editText.setHint("");
                        } else if (value == S_ROOT) {
                            editText.setText("" +
                                    Math.sqrt((Double.parseDouble(num))));
                            editText.setHint("");
                        } else if (value == SIN) {
                            editText.setText("" +
                                    Math.sin(((Math.PI) * (Double.parseDouble(num)) / 180)));
                            editText.setHint("");
                        } else if(value == C){
                            history.clear();
                            history.add(0.0);
                        }
                        num = editText.getText().toString();//최종 결과값, 다음 연산.
                        history.add(Double.parseDouble(num));
                        break;
                    }
                    //토스트 출력
                    if(value == -1 || editText.getText().toString().equals("Infinity")||editText.getText().toString().equals("NaN")){
                        myToast = Toast.makeText(MainActivity.this, "연산 오류가 발생하였습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                        editText.setText("");
                        Log.d("you", "value=> "+ value);
                        Log.d("you", "restart!");
                        onResume();
                        onRestart();
                    }
            }
        }
    };
    protected void onRestart() {
        super.onRestart();
    }

    //메뉴 형성메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //메뉴선택시 호출하는 메소드, 라디오박스 변경
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = findViewById(R.id.linearLayoutPosition);
        switch(item.getItemId()){
            case R.id.general:
                layout.removeAllViews();

                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                break;

            case R.id.engineering:
                inflater.inflate(R.layout.activity2_main,layout,true);

                //공학계산기 연산자
                power = findViewById(R.id.button_Power);
                sin = findViewById(R.id.button_SIN);
                s_root = findViewById(R.id.button_ROOT);


                power.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num = editText.getText().toString();
                        editText.setHint("Power");
                        editText.setText("");
                        value = POWER;
                    }
                });
                s_root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num = editText.getText().toString();
                        editText.setHint("ROOT");
                        editText.setText("");
                        value = S_ROOT;
                    }
                });
                sin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num = editText.getText().toString();
                        editText.setHint("SIN");
                        editText.setText("");
                        value = SIN;
                    }
                });

                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                break;
        }
        return true;
    }

    //숫자버튼 위젯 이벤트 처리방법
    public void onClick(View v){
        editText = findViewById(R.id.etDisplay);

        switch (v.getId()){
            case R.id.btn0:
                editText.setText(editText.getText().toString() + "0"); break;
            case R.id.btn1:
                editText.setText(editText.getText().toString() + "1"); break;
            case R.id.btn2:
                editText.setText(editText.getText().toString() + "2"); break;
            case R.id.btn3:
                editText.setText(editText.getText().toString() + "3"); break;
            case R.id.btn4:
                editText.setText(editText.getText().toString() + "4"); break;
            case R.id.btn5:
                editText.setText(editText.getText().toString() + "5"); break;
            case R.id.btn6:
                editText.setText(editText.getText().toString()+ "6"); break;
            case R.id.btn7:
                editText.setText(editText.getText().toString() + "7"); break;
            case R.id.btn8:
                editText.setText(editText.getText().toString() + "8"); break;
            case R.id.btn9:
                editText.setText(editText.getText().toString() + "9"); break;
        }
    }
}
