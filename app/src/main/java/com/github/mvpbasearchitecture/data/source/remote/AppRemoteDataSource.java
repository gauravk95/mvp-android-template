package com.github.mvpbasearchitecture.data.source.remote;

import com.github.mvpbasearchitecture.data.source.repository.AppDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Concrete implementation of a data source as a db.
 */
@Singleton
public class AppRemoteDataSource implements AppDataSource {

    @Inject
    public AppRemoteDataSource() {

    }

}