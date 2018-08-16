package com.example.sshaukat.dadataexample.dadata.api.address.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaDataAddressSuggestion {

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("unrestricted_value")
    @Expose
    private String unrestrictedValue;

    @SerializedName("data")
    @Expose
    private DaDataAddressSuggestionData data;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnrestrictedValue() {
        return unrestrictedValue;
    }

    public void setUnrestrictedValue(String unrestrictedValue) {
        this.unrestrictedValue = unrestrictedValue;
    }

    public DaDataAddressSuggestionData getData() {
        return data;
    }

    public void setData(DaDataAddressSuggestionData data) {
        this.data = data;
    }
}
