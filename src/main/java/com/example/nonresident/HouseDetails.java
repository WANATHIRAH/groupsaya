package com.example.nonresident;
import java.sql.Blob;
import java. util. Date;
import java.lang.reflect.Field;

public class HouseDetails {
        public Integer hID;
        public String hName;
        public Double hMP;
        public String hAddress;
        public Date hPublishDate;
        public Boolean hAvailability;
        public Integer hNoTenants;
        public Integer hNoRoom;
        public Integer hNoToilet;
        public Integer hNoAC;
        public Boolean hWifi;
        public Integer hFurniture;
        public Integer hWM;
        public String desc;
        //public String hPicture; //ganti dgn blob nnti lepas ada connection
        public String hPicName;
        public String hAgreeName;

    public HouseDetails(Integer hID, String hName, Double hMP, String hAddress, Date hPublishDate, Boolean hAvailability, Integer hNoTenants, Integer hNoRoom, Integer hNoToilet, Integer hNoAC, Boolean hWifi, Integer hFurniture, Integer hWM, String desc, String hPicName, String hAgreeName) {
        this.hID = hID;
        this.hName = hName;
        this.hMP = hMP;
        this.hAddress = hAddress;
        this.hPublishDate = hPublishDate;
        this.hAvailability = hAvailability;
        this.hNoTenants = hNoTenants;
        this.hNoRoom = hNoRoom;
        this.hNoToilet = hNoToilet;
        this.hNoAC = hNoAC;
        this.hWifi = hWifi;
        this.hFurniture = hFurniture;
        this.hWM = hWM;
        this.desc = desc;
        //this.hPicture = hPicture;
        this.hPicName = hPicName;
        this.hAgreeName = hAgreeName;
    }

    public Integer gethID() {
        return hID;
    }

    public void sethID(Integer hID) {
        this.hID = hID;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Double gethMP() {
        return hMP;
    }

    public void sethMP(Double hMP) {
        this.hMP = hMP;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public Date gethPublishDate() {
        return hPublishDate;
    }

    public void sethPublishDate(Date hPublishDate) {
        this.hPublishDate = hPublishDate;
    }

    public Boolean gethAvailability() {
        return hAvailability;
    }

    public void sethAvailability(Boolean hAvailability) {
        this.hAvailability = hAvailability;
    }

    public Integer gethNoTenants() {
        return hNoTenants;
    }

    public void sethNoTenants(Integer hNoTenants) {
        this.hNoTenants = hNoTenants;
    }

    public Integer gethNoRoom() {
        return hNoRoom;
    }

    public void sethNoRoom(Integer hNoRoom) {
        this.hNoRoom = hNoRoom;
    }

    public Integer gethNoToilet() {
        return hNoToilet;
    }

    public void sethNoToilet(Integer hNoToilet) {
        this.hNoToilet = hNoToilet;
    }

    public Integer gethNoAC() {
        return hNoAC;
    }

    public void sethNoAC(Integer hNoAC) {
        this.hNoAC = hNoAC;
    }

    public Boolean gethWifi() {
        return hWifi;
    }

    public void sethWifi(Boolean hWifi) {
        this.hWifi = hWifi;
    }

    public Integer gethFurniture() {
        return hFurniture;
    }

    public void sethFurniture(Integer hFurniture) {
        this.hFurniture = hFurniture;
    }

    public Integer gethWM() {
        return hWM;
    }

    public void sethWM(Integer hWM) {
        this.hWM = hWM;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

//    public Blob gethPicture() {
//        return hPicture;
//    }
//
//    public void sethPicture(Blob hPicture) {
//        this.hPicture = hPicture;
//    }

    public String gethPicName() {
        return hPicName;
    }

    public void sethPicName(String hPicName) {
        this.hPicName = hPicName;
    }

    public String gethAgreeName() {
        return hAgreeName;
    }

    public void sethAgreeName(String hAgreeName) {
        this.hAgreeName = hAgreeName;
    }
}


