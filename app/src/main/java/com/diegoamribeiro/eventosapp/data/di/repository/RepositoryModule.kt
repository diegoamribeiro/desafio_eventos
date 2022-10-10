package com.diegoamribeiro.eventosapp.data.di.repository

import com.diegoamribeiro.eventosapp.data.remote.datasource.RemoteDataSource
import com.diegoamribeiro.eventosapp.data.repository.RepositoryImpl
import com.diegoamribeiro.eventosapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideEventRepository(
        remoteDataSource: RemoteDataSource
    ) : Repository {
        return RepositoryImpl(remoteDataSource)
    }

}