package com.github.mvpbasearchitecture.ui.main;

import android.support.annotation.NonNull;

import com.github.mvpbasearchitecture.base.BaseContract;
import com.github.mvpbasearchitecture.data.models.local.Item;

import java.util.List;

/**
 * The main contract, consists of Screen specific Presenter and View interface
 *
 * Created by gk
 */
public interface MainContract {

    interface View extends BaseContract.View<Presenter> {

        void refreshItemList(@NonNull List<Item> itemList);

        void showEmptyListUI();

    }

    interface Presenter extends BaseContract.Presenter<View> {

        void loadItems(boolean refresh);

    }
}
