package com.github.mvpbasearchitecture.data.models.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "item")
public class Item {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item_id")
    private String itemId;

    @NonNull
    @ColumnInfo(name = "item_name")
    private String itemName;

    public Item(@NonNull String itemId, @NonNull String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

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