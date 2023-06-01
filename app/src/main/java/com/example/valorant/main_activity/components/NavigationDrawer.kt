package com.example.valorant

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.valorant.main_activity.components.MenuItem


@Composable
fun drawerHeader(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .height(300.dp)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
       )

    }
}

@Composable
fun drawerBody(
    items : List<MenuItem>,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit,
        ) {
    LazyColumn(modifier = Modifier.testTag("NavDrawerList")){
        items(items){item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    onItemClick(item)
                }){
                Icon(painter = painterResource(id =item.icon ), contentDescription = null,
                    tint = Color.White
                    )
                Spacer(modifier.width(10.dp))
           Text(text = item.title,
               modifier = Modifier.weight(1f),
               color = Color.White
           )
            }
        }
    }
}