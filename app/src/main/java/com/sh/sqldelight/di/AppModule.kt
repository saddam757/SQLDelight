package com.sh.sqldelight.di

import com.sh.sqldelight.PersonDatabase
import com.sh.sqldelight.data.repository.PersonDataSourceImpl
import com.sh.sqldelight.domain.repository.PersonDataSource
import com.sh.sqldelight.ui.PersonListViewModel
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

import org.koin.dsl.module

val personModule = module {

    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = PersonDatabase.Schema,
            context = androidApplication().applicationContext,
            name = "person_db"
        )
    }
    single { PersonDatabase(get()) }

    singleOf(::PersonDataSourceImpl) { bind<PersonDataSource>() }

    viewModelOf(::PersonListViewModel)
}