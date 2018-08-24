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
package com.github.mvpbasearchitecture.data.source.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.github.mvpbasearchitecture.data.models.local.Item;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Data access objects for connection to SQLite DB using Room
 *
 * Created by gk
 */

@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingleItem(Item item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleItem(List<Item> itemList);

    @Query("SELECT * FROM Item WHERE item_id = :itemId")
    Flowable<Item> fetchItemByItemId(int itemId);

    @Query("SELECT * FROM Item")
    Flowable<List<Item>> fetchItems();

    @Update
    void updateItem(Item item);

    @Delete
    void deleteItem(Item item);

}