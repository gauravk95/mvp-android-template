package com.github.mvpbasearchitecture.data.models.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "item")
public class Item {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item_id")
    @SerializedName("id")
    @Expose
    private String itemId;

    @NonNull
    @ColumnInfo(name = "item_name")
    @SerializedName("name")
    @Expose
    private String itemName;

    @Nullable
    @ColumnInfo(name = "item_image_link")
    @SerializedName("imageLink")
    @Expose
    private String itemImageLink;

    public Item(@NonNull String itemId, @NonNull String itemName,@Nullable String itemImageLink) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImageLink = itemImageLink;
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

    @Nullable
    public String getItemImageLink() {
        return itemImageLink;
    }

    public void setItemImageLink(@Nullable String itemImageLink) {
        this.itemImageLink = itemImageLink;
    }
}