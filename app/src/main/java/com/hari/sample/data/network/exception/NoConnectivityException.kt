package com.hari.sample.data.network.exception

import java.io.IOException

class NoConnectivityException : IOException() {
    // You can send any message whatever you want from here.
    override val message: String
        get() = "No internet found. Check your connection or try again."
}