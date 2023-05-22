package com.example.valorant.ui.agentDetails_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.valorant.ui.agentDetails_screen.AgentDetailsState

@Composable
fun AgentDetailsBody(agentDetailsState: AgentDetailsState) {

    Column() {


        Row {

            AgentAbitliteis(agentDetailsState)

        }
    }
}