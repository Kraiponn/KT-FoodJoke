package com.codemakerlab.foodmaster.data.repository

import com.codemakerlab.foodmaster.data.network.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
        private val remoteDataSource: RemoteDataSource
) {

    val remote: RemoteDataSource = remoteDataSource

}