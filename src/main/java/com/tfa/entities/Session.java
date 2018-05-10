package com.tfa.entities;

public class Session {

    private boolean isConnected;
    private String reasonWhyNotConnected;
    private String whoIsConnected;


    public Session(boolean isConnected, String reasonWhyNotConnected,
            String whoIsConnected) {
        this.isConnected = isConnected;
        this.reasonWhyNotConnected = reasonWhyNotConnected;
        this.whoIsConnected = whoIsConnected;
    }

    public Session(boolean isConnected, String reasonWhyNotConnected) {
        this.isConnected = isConnected;
        this.reasonWhyNotConnected = reasonWhyNotConnected;
        this.whoIsConnected = null;
    }

    public boolean isConnected() {
        return isConnected;
    }


    public void setConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }


    public String getReasonWhyNotConnected() {
        return reasonWhyNotConnected;
    }


    public void setReasonWhyNotConnected(String reasonWhyNotConnected) {
        this.reasonWhyNotConnected = reasonWhyNotConnected;
    }


    public String getWhoIsConnected() {
        return whoIsConnected;
    }


    public void setWhoIsConnected(String whoIsConnected) {
        this.whoIsConnected = whoIsConnected;
    }



}
