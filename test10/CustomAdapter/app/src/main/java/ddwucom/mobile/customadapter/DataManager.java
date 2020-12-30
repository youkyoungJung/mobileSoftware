package ddwucom.mobile.customadapter;

import java.util.ArrayList;

public class DataManager {

    ArrayList<MyData> dataArrayList;

    public DataManager(){

        dataArrayList = new ArrayList<>();
        dataArrayList.add(new MyData(1,"홍길동","012345"));
        dataArrayList.add(new MyData(2,"전우치","123456"));
        dataArrayList.add(new MyData(3,"일지매","234567"));
        dataArrayList.add(new MyData(4,"홍길동","012345"));
        dataArrayList.add(new MyData(5,"전우치","123456"));
        dataArrayList.add(new MyData(6,"일지매","234567"));
        dataArrayList.add(new MyData(7,"홍길동","012345"));
        dataArrayList.add(new MyData(8,"전우치","123456"));
        dataArrayList.add(new MyData(9,"전우치","123456"));
        dataArrayList.add(new MyData(10,"일지매","234567"));

    }
    public  void deleteData(int index){
        dataArrayList.remove(index);
    }
}
