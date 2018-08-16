package com.example.sshaukat.dadataexample.dadata.api.address;

import com.example.sshaukat.dadataexample.dadata.api.address.base.DaDataAddressSuggestion;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DaDataAddressRes {
    @SerializedName("suggestions")
    @Expose
    private List<DaDataAddressSuggestion> suggestions = null;

    public List<DaDataAddressSuggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<DaDataAddressSuggestion> suggestions) {
        this.suggestions = suggestions;
    }
}