/*
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.github.mvpbasearchitecture.data.models.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Describes the data to be modeled
 * Note:
 * Uses both the Room specific annotations for Local DB
 * Uses Gson annotations for Json serialization for Network requests
 *
 * Created by gk
 */

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