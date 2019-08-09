package com.example.android.complaintapp;

/**
 * Created by ritika on 5/3/18.
 */
public class Complaint {
    private String name;
    private String email;
    private String rollno;
    private String hostel;
    private String roomno;
    private String number;
    private String condition;
    private String description;
    private String key;
    private String res;
    private String service;

    public Complaint()
    {

    }
    public Complaint(String n,String e,String r,String h,String ro,String nu,String c,String d,String k,String se,String reso)
    {
        name=n;
        email=e;
        rollno=r;
        hostel=h;
        roomno=ro;
        number=nu;
        condition=c;
        description=d;
        key=k;
        service=se;
        res=reso;

    }
   /* public Complaint(String n,String e,String r,String h,String ro,String nu,String c,String d,String k,String re)
    {
        name=n;
        email=e;
        rollno=r;
        hostel=h;
        roomno=ro;
        number=nu;
        condition=c;
        description=d;
        key=k;
        re=res;

    }*/

    public String getName(){return name;}
    public String getEmail(){return email;}

    public String getRollno() {
        return rollno;
    }

    public String getCondition() {
        return condition;
    }

    public String getHostel() {
        return hostel;
    }

    public String getNumber() {
        return number;
    }

    public String getRoomno() {
        return roomno;
    }

    public String getDescription() {
        return description;
    }


    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
