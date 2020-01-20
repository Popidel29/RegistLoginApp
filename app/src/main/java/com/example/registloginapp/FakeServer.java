package com.example.registloginapp;

import android.os.Parcel;
import android.os.Parcelable;

public class FakeServer implements Parcelable {
    private String username;
    private String password;

    public FakeServer() {
        super();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    protected FakeServer(Parcel in) {
        username = in.readString();
        password = in.readString();
    }


    public static final Creator<FakeServer> CREATOR = new Creator<FakeServer>() {
        @Override
        public FakeServer createFromParcel(Parcel in) {
            return new FakeServer(in);
        }

        @Override
        public FakeServer[] newArray(int size) {
            return new FakeServer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }


    public void registerUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isExistingUser(String username2, String password2) {

        return username.equals(username) && password.equals(password2);


    }


}
