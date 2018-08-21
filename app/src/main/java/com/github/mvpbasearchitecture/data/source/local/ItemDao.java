package com.github.mvpbasearchitecture.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.github.mvpbasearchitecture.data.models.local.Item;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ItemDao {

    @Insert
    void insertSingleItem(Item item);

    @Insert
    void insertMultipleItem(List<Item> itemList);

    @Update
    void updateMultipleItem(List<Item> itemList);

    @Query("SELECT * FROM Item WHERE item_id = :itemId")
    Flowable<Item> fetchItemByItemId(int itemId);

    @Query("SELECT * FROM Item")
    Flowable<List<Item>> fetchItems();

    @Update
    void updateItem(Item item);

    @Delete
    void deleteItem(Item item);

}