package cn.zz8z.studentinfoclient;

/**
 * Created by Mike Lee on 2016/10/16.
 */

public abstract class DatabaseConnector {
    public abstract void connect(String url);
    public abstract boolean isConnected();
    public abstract boolean verify(StudentPassword password);
    public abstract boolean getInfo(StudentPassword password,StudentInfo info);
    public abstract boolean updateInfo(StudentPassword password,StudentInfo info);
}
