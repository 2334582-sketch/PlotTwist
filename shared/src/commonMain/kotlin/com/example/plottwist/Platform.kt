package com.example.plottwist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform