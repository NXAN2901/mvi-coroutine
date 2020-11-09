package com.example.core.data.datastore

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import com.example.mvi.data.datastore.AppPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object AppPrefsSerializer : Serializer<AppPreferences> {
    override fun readFrom(input: InputStream): AppPreferences {
        try {
            return AppPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: AppPreferences, output: OutputStream) {
        t.writeTo(output)
    }

}