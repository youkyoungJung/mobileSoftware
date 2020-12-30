package ddwucom.mobile.hw10_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context; // Inflater 객체 생성시 필요
    private  int layout; // AdapterView 항목에 대한 Layout
    private ArrayList<MyData> myDataList;  // 원본데이터리스트
    private LayoutInflater inflater; // inflater 객체

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList){ // 생성자
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 인수로 받은 Context 를 사용하여 inflater 객체 준비
    }
    @Override
    public int getCount() {
        return myDataList.size();
    }//전체 원본데잍터의 개수 반환. AdaterView 가 표시할 View의 개수를 확인 시 호출

    @Override
    public Object getItem(int position) {
        return myDataList.get(position); //특정 위치의 데이터 항목 반환
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_no(); // 특정 위치의 데이터 항목 아이디 반환환
   }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        viewHolder viewHolder = null;

        if(convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new viewHolder();
            viewHolder.no = convertView.findViewById(R.id.no);//요소데이터 결합
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.detail = convertView.findViewById(R.id.detail);
            viewHolder.info = convertView.findViewById(R.id.info);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (viewHolder)convertView.getTag();
        }

        //화면 데이터
        viewHolder.no.setText(String.valueOf(myDataList.get(pos).get_no()));
        viewHolder.no.setOnTouchListener(new TextView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context, myDataList.get(pos).getDetail() + myDataList.get(pos).getName() +
                        " 의 날씨는 "+ myDataList.get(pos).getInfo(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        viewHolder.name.setText(myDataList.get(pos).getName());
        viewHolder.detail.setText(myDataList.get(pos).getDetail());
        viewHolder.info.setText(myDataList.get(pos).getInfo());



        return convertView;
    }

    static class viewHolder{
        TextView no;
        TextView name;
        TextView detail;
        TextView info; // 정적 멤버/
    }
}
