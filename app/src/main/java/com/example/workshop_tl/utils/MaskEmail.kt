package com.example.workshop_tl.utils

import java.security.MessageDigest


fun String.toSha256(): String {
    val bytes = this.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)

    // Convert the byte array to a hexadecimal string
    val result = StringBuilder()
    for (byte in digest) {
        result.append(String.format("%02x", byte))
    }

    return result.toString()
}