package ddwucom.mobile.adapterview_test;

import java.util.ArrayList;

public class subjectManager {
    private ArrayList<String> subjectList;

    //생성자
    public subjectManager(){
        subjectList = new ArrayList<String>();// 동적배열
        subjectList.add("모바일 소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }
    public String getItem(int pos){
        return subjectList.get(pos);
    }
    //추가
    public void addData(String newSubject){
        subjectList.add(newSubject);
    }
    //삭제
    public void removeData(int pos){
        subjectList.remove(pos);
    }
    //수정-set 이용
    public void updateDate(int pos, String updateSubject){
        subjectList.set(pos, updateSubject);
    }
}
