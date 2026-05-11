package com.example.definaa.network

import com.example.definaa.model.MenuItem
import retrofit2.http.GET

interface ApiService {
    @GET("menu_cheatday.json")
    suspend fun getMenus(): List<MenuItem>
}