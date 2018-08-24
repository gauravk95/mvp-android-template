package com.github.mvpbasearchitecture.data.models.remote;

import com.github.mvpbasearchitecture.data.models.local.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the list of items from the sever
 *
 * Created by gk
 */

public class ResponseItemHolder implements Serializable{

    @SerializedName("itemList")
    @Expose
    private List<Item> items;

    public ResponseItemHolder(ArrayList<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
