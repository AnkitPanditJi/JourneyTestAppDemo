package com.trendnxt.utils

object ServerConfig {
    const val IS_STAGING = true
    const val BASE_URL_STAGING = "https://jsonplaceholder.typicode.com/"
    const val BASE_URL_PRODUCTION = "https://jsonplaceholder.typicode.com/"
    val BASE_URL = if (IS_STAGING) BASE_URL_STAGING else BASE_URL_PRODUCTION
    val Trends_url = BASE_URL_STAGING + "posts"
    val Trends_url_Comments = BASE_URL_STAGING + "comments?postId="


}