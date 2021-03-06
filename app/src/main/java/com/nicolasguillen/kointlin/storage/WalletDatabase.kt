package com.nicolasguillen.kointlin.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nicolasguillen.kointlin.storage.dao.AppSettingsDao
import com.nicolasguillen.kointlin.storage.dao.WalletDao
import com.nicolasguillen.kointlin.storage.entities.Asset
import com.nicolasguillen.kointlin.storage.entities.AppSettings

@Database(entities = [Asset::class, AppSettings::class], version = 6, exportSchema = false)
abstract class KointlinDatabase : RoomDatabase() {

    abstract fun walletDao(): WalletDao

    abstract fun appSettingsDao(): AppSettingsDao
}