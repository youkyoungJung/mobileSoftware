package ddwucom.mobile.customadapter;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    int count;
    private Context context;
    private  int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        count = 0;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        viewHolder viewHolder = null;

        Log.d("you", "getView!");
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
            Log.d("you", "count: " + ++count);

            viewHolder = new viewHolder();
            viewHolder.tvNo = convertView.findViewById(R.id.tvNo);//요소데이터 결합
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.btnCheck = convertView.findViewById(R.id.button);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (viewHolder) convertView.getTag();
        }

        //화면객체만들기
//        TextView tvNo = convertView.findViewById(R.id.tvNo);//요소데이터 결합
//        TextView tvName = convertView.findViewById(R.id.tvName);
//        TextView tvPhone = convertView.findViewById(R.id.tvPhone);
//        Button btnCheck = convertView.findViewById(R.id.button);
//        btnCheck.setFocusable(false);//버튼 이외에 이벤트 처리 허락

        viewHolder.tvNo.setText(String.valueOf(myDataList.get(pos).get_id()));
        viewHolder.tvName.setText(myDataList.get(pos).getName());
        viewHolder.tvPhone .setText(myDataList.get(pos).getPhone());

        viewHolder.btnCheck .setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getPhone() + " 선택", Toast.LENGTH_SHORT).show();
            }
        });
            return convertView;
    }
    static class viewHolder{
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button btnCheck;//정적멤버: 상수로됨-> 계속 유지
    }
}
