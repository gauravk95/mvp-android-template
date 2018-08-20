package com.github.mvpbasearchitecture.data.models.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseItem implements Serializable{

    @SerializedName("_id")
    @Expose
    private String itemId;

    @SerializedName("name")
    @Expose
    private String itemName;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
