package ddwucom.mobile.finalreport;

import android.os.Parcel;
import android.os.Parcelable;

public class MyMusic implements Parcelable {
    private long _id;
    private String title;
    private String name;
    private String genre;
    private String date;
    private String company;
    private int image_id;


    public MyMusic(String title, String name, String genre) {
        this.title = title;
        this.name = name;
        this.genre = genre;
    }


    public MyMusic(long _id, String title, String name, String genre, String date, String company){
        this._id = _id;
        //this.image = image;
        this.title = title;
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.company = company;
    }


    protected MyMusic(Parcel in) {
        _id = in.readLong();
        title = in.readString();
        name = in.readString();
        image_id = in.readInt();
        genre = in.readString();
        date = in.readString();
        company = in.readString();
    }

    public static final Creator<MyMusic> CREATOR = new Creator<MyMusic>() {
        @Override
        public MyMusic createFromParcel(Parcel in) {
            return new MyMusic(in);
        }

        @Override
        public MyMusic[] newArray(int size) {
            return new MyMusic[size];
        }
    };

    public void setDate(String date) {
        this.date = date;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public String getCompany() {
        return company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(_id);
        dest.writeString(title);
        dest.writeString(name);
        dest.writeInt(image_id);
        dest.writeString(genre);
        dest.writeString(date);
        dest.writeString(company);
    }
}
