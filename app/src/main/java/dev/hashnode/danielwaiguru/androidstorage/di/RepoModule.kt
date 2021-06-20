package dev.hashnode.danielwaiguru.androidstorage.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.hashnode.danielwaiguru.androidstorage.data.repos.ImageRepositoryImpl
import dev.hashnode.danielwaiguru.androidstorage.domain.repos.ImageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    @Singleton
    abstract fun provideImageRepository(imageRepositoryImpl: ImageRepositoryImpl): ImageRepository

}