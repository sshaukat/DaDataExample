package com.example.sshaukat.dadataexample.dadata.api.address;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaDataBodyReq {

    @SerializedName("query")
    @Expose
    private String query;

    @SerializedName("count")
    @Expose
    private int count;

    public  DaDataBodyReq(String query, int count) {
        this.query = query;
        this.count = count;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
