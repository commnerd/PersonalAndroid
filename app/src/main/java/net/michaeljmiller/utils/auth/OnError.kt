package net.michaeljmiller.utils.auth

import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture

/**
 * Created by commnerd on 3/25/18.
 */
class OnError<T>: AccountManagerCallback<T> {
    override fun run(p0: AccountManagerFuture<T>?) {
    }

}