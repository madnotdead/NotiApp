package com.apps.madnotdead.notiapp.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by madnotdead on 7/30/17.
 */
fun Context.longToast (message: String) {
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}