package com.metehanbolat.relationshipsroomdatabasecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.relationshipsroomdatabasecompose.ui.theme.RelationshipsRoomDatabaseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelationshipsRoomDatabaseComposeTheme {
                
            }
        }
    }
}
