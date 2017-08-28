package cn.zz8z.studentinfoclient;

/**
 * Created by Mike Lee on 2016/10/16.
 */

public class StudentPassword {
    private String mStudentId;
    private String mIdNumber;
    private String mPassword;
    StudentPassword(String[] args)
    {
        mStudentId=args[0];
        mIdNumber=args[1];
        mPassword=args[2];
    }
    boolean isEmpty()
    {
        return mStudentId.isEmpty()||mIdNumber.isEmpty()||mPassword.isEmpty();
    }
    String getStudentId()
    {
        return mStudentId;
    }
    String getIdNumber()
    {
        return mIdNumber;
    }
    String getPassword()
    {
        return mPassword;
    }
}
