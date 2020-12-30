package ddwucom.mobile.test08.adapterclicktest;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("돈까스");
        subjectList.add("냉면");
        subjectList.add("피자");
        subjectList.add("치킨");
        subjectList.add("떡볶이");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }
    public  String getItem(int pos){return subjectList.get(pos);}

//    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

//    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

// 수정
    public  void updateData(int pos, String updateSubject){
        subjectList.set(pos, updateSubject);
    }

}
