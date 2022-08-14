package com.tozmd.bardx.services.module

import com.tozmd.bardx.services.AccountService
import com.tozmd.bardx.services.impl.AccountServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/*
    Module of services and their impl
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun getAccountService(impl: AccountServiceImpl): AccountService
}