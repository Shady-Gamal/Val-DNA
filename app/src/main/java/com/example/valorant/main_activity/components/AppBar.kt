package com.example.valorant.main_activity.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.valorant.R
import com.example.valorant.ui.theme.BackGround
import com.example.valorant.ui.theme.RedPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun AppBar(
    onNavigationIconClick: ()-> Unit
) {

   TopAppBar(
       title = {},
       navigationIcon = {
           IconButton(onClick = onNavigationIconClick, modifier = Modifier.testTag("Nav")) {
               Icon(painter = painterResource(id = R.drawable.navigation_icon), contentDescription = null,
              tint = RedPrimary)

           }
       }, colors = TopAppBarDefaults.topAppBarColors(containerColor = BackGround),
       actions = {

           Icon(painter = painterResource(id = R.drawable.appbar_icon),contentDescription = null,
           modifier = Modifier.padding(end = 10.dp), tint = RedPrimary )
       }



   )

}