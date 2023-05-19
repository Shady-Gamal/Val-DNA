package com.example.data.repositoriesContracts
import com.example.data.model.AgentsResponse
import com.example.data.model.MapsResponse
import com.example.data.model.WeaponsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

   @GET("agents")
   suspend fun getAgents(
      @Query("isPlayableCharacter") playable : Boolean = true
   ) : AgentsResponse

   @GET("maps")
   suspend fun getMaps() : MapsResponse

   @GET("weapons")
   suspend fun getWeapons() : WeaponsResponse

}