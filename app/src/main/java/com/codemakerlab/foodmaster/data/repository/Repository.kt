package com.codemakerlab.foodmaster.data.repository

import com.codemakerlab.foodmaster.data.database.LocalDataSource
import com.codemakerlab.foodmaster.data.network.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource
) {

    val remote: RemoteDataSource = remoteDataSource
    val local: LocalDataSource = localDataSource

}