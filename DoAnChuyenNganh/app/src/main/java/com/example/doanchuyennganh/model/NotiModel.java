package com.example.doanchuyennganh.model;

public class NotiModel {
    private String Apartment, Block, NotiContent, NotiDay, Owner,TotalWord;
    private Long Month, ServiceBill, Total, WaterNew, WaterOld, WaterUsed, Year, WaterBill;

    public NotiModel() {
    }

    public NotiModel(String apartment, String block, String notiContent, String notiDay, String owner, Long month, Long serviceBill, Long total, Long waterNew, Long waterOld, Long waterUsed, Long year, Long waterBill, String totalWord) {
        Apartment = apartment;
        Block = block;
        NotiContent = notiContent;
        NotiDay = notiDay;
        Owner = owner;
        Month = month;
        ServiceBill = serviceBill;
        Total = total;
        WaterNew = waterNew;
        WaterOld = waterOld;
        WaterUsed = waterUsed;
        Year = year;
        WaterBill = waterBill;
        TotalWord = totalWord;
    }

    public String getTotalWord() {
        return TotalWord;
    }

    public void setTotalWord(String totalWord) {
        TotalWord = totalWord;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }

    public String getBlock() {
        return Block;
    }

    public void setBlock(String block) {
        Block = block;
    }

    public String getNotiContent() {
        return NotiContent;
    }

    public void setNotiContent(String notiContent) {
        NotiContent = notiContent;
    }

    public String getNotiDay() {
        return NotiDay;
    }

    public void setNotiDay(String notiDay) {
        NotiDay = notiDay;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public Long getMonth() {
        return Month;
    }

    public void setMonth(Long month) {
        Month = month;
    }

    public Long getServiceBill() {
        return ServiceBill;
    }

    public void setServiceBill(Long serviceBill) {
        ServiceBill = serviceBill;
    }

    public Long getTotal() {
        return Total;
    }

    public void setTotal(Long total) {
        Total = total;
    }

    public Long getWaterNew() {
        return WaterNew;
    }

    public void setWaterNew(Long waterNew) {
        WaterNew = waterNew;
    }

    public Long getWaterOld() {
        return WaterOld;
    }

    public void setWaterOld(Long waterOld) {
        WaterOld = waterOld;
    }

    public Long getWaterUsed() {
        return WaterUsed;
    }

    public void setWaterUsed(Long waterUsed) {
        WaterUsed = waterUsed;
    }

    public Long getYear() {
        return Year;
    }

    public void setYear(Long year) {
        Year = year;
    }
    public Long getWaterBill(){
        return WaterBill;
    }
    public void setWaterBill(Long waterBill){
        WaterBill = waterBill;
    }
}
