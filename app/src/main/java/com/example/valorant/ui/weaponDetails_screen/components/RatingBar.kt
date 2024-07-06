package com.example.valorant.ui.weaponDetails_screen.components

import android.widget.RatingBar
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.example.valorant.ui.theme.RedPrimary

@Composable
fun RatingBar(currentRate : Float, maxRate : Float , title : String) {

    Column(modifier = Modifier.padding(20.dp)) {


        Text(text = title)
        Spacer(modifier = Modifier.height(5.dp))

        Row {
            

            Canvas(modifier = Modifier.fillMaxWidth().height(30.dp)) {

                drawLine(color = Color.Gray, Offset.Zero, Offset(size.width, 0.dp.toPx()), strokeWidth = 10.dp.toPx()
                , cap = StrokeCap.Round)
                drawLine(
                    color = RedPrimary,
                    Offset.Zero,
                    Offset(currentRate / maxRate * size.width, 0.dp.toPx()),
                    strokeWidth = 4.dp.toPx(), cap = StrokeCap.Round
                )
            }

        }
    }
}