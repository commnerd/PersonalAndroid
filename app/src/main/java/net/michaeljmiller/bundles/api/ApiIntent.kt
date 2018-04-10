package net.michaeljmiller.bundles.api

import android.content.Context
import android.content.Intent

class ApiIntent<T>(cont: Context): Intent(cont, ListActivity::class.java) {

    private inline fun <reified T: Any> inlineGetClassType(): Class<T> {
        return T::class.java
    }

    fun getClassType(): Class<Any> {
        return inlineGetClassType()
    }

}