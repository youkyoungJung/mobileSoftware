package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<MyMusic> myMusicList;
    private LayoutInflater inflater;

    private List<MyMusic> myMusicListFull = null;
    private MusicDBManager musicDBManager;

//
    int[] images = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4
            , R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public MyAdapter(Context context, int layout, ArrayList<MyMusic> myMusicList) {
        this.context = context;
        this.layout = layout;
        this.myMusicList = myMusicList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myMusicListFull = new ArrayList<>(myMusicList);
    }

    @Override
    public int getCount() {
        return myMusicList.size();
    }

    @Override
    public Object getItem(int position) {
        return myMusicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        viewHolder viewHolder = null;

        if(convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new viewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.name);
            viewHolder.tvTitle = convertView.findViewById(R.id.title);
            viewHolder.tvImage = convertView.findViewById(R.id.image);
            viewHolder.tvGenre = convertView.findViewById(R.id.genre);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (viewHolder)convertView.getTag();
        }

        viewHolder.tvName.setText(myMusicList.get(pos).getName());
        viewHolder.tvTitle.setText(myMusicList.get(pos).getTitle());
        viewHolder.tvGenre.setText(myMusicList.get(pos).getGenre());
        viewHolder.tvImage.setImageResource(images[position]);

        return convertView;
    }

    static class viewHolder{
        ImageView tvImage;
        TextView tvName;
        TextView tvTitle;
        TextView tvGenre;
    }
    //검색창 구현
//    @Override
//    public Filter getFilter() {
//        return myMusicFilter;
//    }
//
//    private Filter myMusicFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            ArrayList<MyMusic> filterList = new ArrayList<>();
//
//            if(constraint == null || constraint.length() == 0){
//                filterList.addAll(myMusicListFull);
//            }else{
//                String filterPattern = constraint.toString().toLowerCase().trim();
//
//                for(MyMusic item : myMusicListFull){
//                    if(item.getTitle().toLowerCase().contains(filterPattern)){
//                        filterList.add(item);
//                    }
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filterList;
//            results.count = filterList.size();
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            myMusicList.clear();
//            myMusicList.addAll((List) results.values);
//            notifyDataSetChanged();
//        }
//
//        public CharSequence convertResultToString(Object resultValue){
//            return ((MyMusic)resultValue).getTitle();
//        }
//    };


}
