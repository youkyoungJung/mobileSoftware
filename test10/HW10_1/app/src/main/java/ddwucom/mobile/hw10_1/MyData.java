package ddwucom.mobile.hw10_1;

public class MyData {
    private int _no;
    private String name;
    private String detail;
    private String info;


    public MyData(int _no, String name, String detail, String info) {
        this._no = _no;
        this.name = name;
        this.detail = detail;
        this.info = info;
    }

    public int get_no() {
        return _no;
    }
    public void set_no(int _no) {
        this._no = _no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) { this.detail = detail;}

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
