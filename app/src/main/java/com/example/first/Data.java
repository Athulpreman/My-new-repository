package com.example.first;

public class Data
{
    String usrname,mailid,pswd,phoneno;

    public Data()
    {
    }

    public Data(String usrname, String phoneno, String mailid, String pswd)
    {
        this.usrname = usrname;
        this.phoneno = phoneno;
        this.mailid = mailid;
        this.pswd = pswd;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
