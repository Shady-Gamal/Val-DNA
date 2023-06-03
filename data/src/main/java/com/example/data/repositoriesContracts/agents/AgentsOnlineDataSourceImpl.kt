package com.example.data.repositoriesContracts.agents

import android.content.Context
import android.widget.Toast
import com.example.data.database.ValorantDatabase
import com.example.data.model.toAgentItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.AgentItemDTO
import com.example.domain.entities.Resource
import com.example.domain.repository.AgentsOnlineDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AgentsOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase,
val context: Context) : AgentsOnlineDataSource {
    override suspend fun getAgents() {

        try {


        val response = webServices.getAgents()
            response.data?.let { valorantDatabase.getAgentsDao().saveAgents(it) }

        }catch (ex : Exception){

            Toast.makeText(context,"something is wrong with the server", Toast.LENGTH_LONG  ).show()
        }


    }
}