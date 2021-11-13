package kr.bracket.homework.searchrepository.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.bracket.homework.data.repository.GithubRepositoryImpl
import kr.bracket.homework.domain.repository.GithubRepository


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideGithubRepository(repository : GithubRepositoryImpl) : GithubRepository
}