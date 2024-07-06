package com.example.data.repositoriesContracts.bundles

import android.content.Context
import android.widget.Toast
import com.example.data.database.ValorantDatabase
import com.example.data.model.toBundleItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.BundleItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.BundlesOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class BundlesOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase,
val context: Context) :
    BundlesOnlineDataSource {
    override suspend fun getBundles(){

        try {

            val response = webServices.getBundles()

            response.data?.let { valorantDatabase.getBundlesDao().saveBundles(it) }
        }
        catch (ex : Exception){

            Toast.makeText(context,"something is wrong with the server", Toast.LENGTH_LONG  ).show()


        }

         }
}