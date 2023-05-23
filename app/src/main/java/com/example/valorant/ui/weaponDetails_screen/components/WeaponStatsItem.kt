package com.example.valorant.ui.weaponDetails_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valorant.ui.theme.RedPrimary


@Composable
fun WeaponStatsItem(
 title : String,
 value : String
                    ) {

        Column(modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(RedPrimary)
            .size(80.dp, 120.dp)
            .padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = title , textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold,
            color = Color.White , fontSize = 10.sp)
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = value,
                modifier = Modifier.background(Color.White, shape = CircleShape).fillMaxWidth()
                , textAlign = TextAlign.Center)
        }
    }
