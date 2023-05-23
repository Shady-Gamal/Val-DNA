package com.example.data.repositoriesContracts
import com.example.data.model.*
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

   @GET("bundles")
   suspend fun getBundles() : BundlesResponse
@GET("buddies")
   suspend fun getBuddies() : BuddiesResponse

   @GET("sprays")
   suspend fun getSprays() : SpraysResponse

   @GET("playertitles")
   suspend fun getPlayerTitles() : PlayerTitlesResponse

   @GET("playercards")
   suspend fun getPlayerCards() : PlayerCardsResponse




}