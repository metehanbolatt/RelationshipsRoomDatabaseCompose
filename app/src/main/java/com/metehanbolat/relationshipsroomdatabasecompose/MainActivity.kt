package com.metehanbolat.relationshipsroomdatabasecompose

import android.app.Application
import android.os.Bundle
import android.service.autofill.UserData
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.metehanbolat.relationshipsroomdatabasecompose.entity.*
import com.metehanbolat.relationshipsroomdatabasecompose.ui.theme.Purple500
import com.metehanbolat.relationshipsroomdatabasecompose.ui.theme.RelationshipsRoomDatabaseComposeTheme
import com.metehanbolat.relationshipsroomdatabasecompose.ui.theme.lightGray100
import com.metehanbolat.relationshipsroomdatabasecompose.viewmodel.UserViewModel

import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelationshipsRoomDatabaseComposeTheme {
                ManyToManyDb()
            }
        }
    }
}

val userData = listOf(
    User(1, "User 1", 10),
    User(2, "User 2", 20),
    User(3, "User 3", 30),
    User(4, "User 4", 40),
    User(5, "User 5", 50),

)

val libraryData = listOf(
    Library(1, "Library 1", 2),
    Library(2, "Library 2", 1),
    Library(3, "Library 3", 3),
    Library(4, "Library 4", 2),
    Library(5, "Library 5", 1),
    Library(6, "Library 6", 3),
    Library(7, "Library 7", 1),
)

val userAndLibrary = listOf(
    UserLibraryCrossRef(1,1),
    UserLibraryCrossRef(1,3),
    UserLibraryCrossRef(2,4),
    UserLibraryCrossRef(1,5),
    UserLibraryCrossRef(3,4),
    UserLibraryCrossRef(2,5),
    UserLibraryCrossRef(5,6),
    UserLibraryCrossRef(4,2),
    UserLibraryCrossRef(3,3),
    UserLibraryCrossRef(2,7),
)

/*
@Composable
fun OneToOneDb() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val userViewModel: UserViewModel = viewModel()

    userViewModel.addUser(userData)
    userViewModel.addLibrary(libraryData)

    val getUserRecord = userViewModel.readAllData.observeAsState(listOf()).value

    val userId = remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = userId.value,
                onValueChange = { userId.value = it },
                label = { Text(text = "Enter User Id") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    scope.launch {
                        userViewModel.getUser(userId.value.toInt())
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(60.dp)
                    .padding(10.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Purple500)
            ) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .padding(15.dp)
            ) {
                Text(
                    text = "User Id",
                    modifier = Modifier.weight(0.3f),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "User Name",
                    modifier = Modifier.weight(0.3f),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Library Name",
                    modifier = Modifier.weight(0.3f),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            if (getUserRecord.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(15.dp)
                ) {
                    Text(
                        text = getUserRecord[0].user.userId.toString(),
                        modifier = Modifier.weight(0.3f),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = getUserRecord[0].user.name,
                        modifier = Modifier.weight(0.3f),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = getUserRecord[0].library.title,
                        modifier = Modifier.weight(0.3f),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}

 */
/*
@Composable
fun OneToManyDb() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val userViewModel: UserViewModel = viewModel()

    userViewModel.addUser(userData)
    userViewModel.addLibrary(libraryData)

    val getUserRecord = userViewModel.readAllData.observeAsState(listOf()).value

    val userId = remember { mutableStateOf("") }
    
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "One To Many Relationship",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = userId.value,
                    onValueChange = {
                        userId.value = it
                    },
                    label = { Text(text = "Enter User Id") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(25.dp))
                
                Button(
                    onClick = {
                        scope.launch {
                            userViewModel.getUser(userId.value.toInt())
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(60.dp)
                        .padding(10.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Purple500)
                ) {
                    Text(
                        text = "Submit",
                        color = Color.White,
                        fontSize = 13.sp
                    )
                }
                
                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Purple500)
                        .padding(15.dp)
                ) {
                    Text(
                        text = "User Id",
                        modifier = Modifier.weight(0.3f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Name",
                        modifier = Modifier.weight(0.3f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Age",
                        modifier = Modifier.weight(0.3f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (getUserRecord.isNotEmpty()) {
                    LazyColumn {
                        items(getUserRecord.size) { index ->
                            UserDataList(getUserRecord[index])
                        }

                        item { 
                            Spacer(modifier = Modifier.height(30.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Purple500)
                                    .padding(15.dp)
                            ) {
                                Text(
                                    text = "Library Id",
                                    modifier = Modifier.weight(0.3f),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Library Name",
                                    modifier = Modifier.weight(0.3f),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        items(getUserRecord[0].library.size) { index ->
                            LibraryDataList(getUserRecord[0].library[index])
                        }
                    }
                }


            }
        }
    }
}
 */

@Composable
fun ManyToManyDb() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val userViewModel: UserViewModel = viewModel()

    userViewModel.addUser(userData)
    userViewModel.addLibrary(libraryData)
    userViewModel.addUserLibrary(userAndLibrary)

    val getUserRecord = userViewModel.readAllData.observeAsState(listOf()).value

    val userId = remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Many To Many Relationship",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = userId.value,
                    onValueChange = {
                        userId.value = it
                    },
                    label = { Text(text = "Enter User Id") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = {
                        scope.launch {
                            userViewModel.getUser(userId.value.toInt())
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(60.dp)
                        .padding(10.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Purple500)
                ) {
                    Text(
                        text = "Submit",
                        color = Color.White,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Purple500)
                        .padding(15.dp)
                ) {
                    Text(
                        text = "User Id",
                        modifier = Modifier.weight(0.3f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Name",
                        modifier = Modifier.weight(0.3f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Age",
                        modifier = Modifier.weight(0.3f),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (getUserRecord.isNotEmpty()) {
                    LazyColumn {
                        items(getUserRecord.size) { index ->
                            UserDataList(getUserRecord[index])
                        }

                        item {
                            Spacer(modifier = Modifier.height(30.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Purple500)
                                    .padding(15.dp)
                            ) {
                                Text(
                                    text = "Library Id",
                                    modifier = Modifier.weight(0.3f),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Library Name",
                                    modifier = Modifier.weight(0.3f),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        items(getUserRecord[0].library.size) { index ->
                            LibraryDataList(getUserRecord[0].library[index])
                        }
                    }
                }


            }
        }
    }
}

@Composable
fun UserDataList(userAndLibrary: UserWithLibrary) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(lightGray100)
            .padding(15.dp)
    ) {
        Text(
            text = userAndLibrary.user.userId.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = userAndLibrary.user.name,
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = userAndLibrary.user.age.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun LibraryDataList(library: Library) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(lightGray100)
            .padding(15.dp)
    ) {
        Text(
            text = library.id.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = library.title,
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}
/*
@Composable
fun UserDataList(userAndLibraryOtM: UserAndLibraryOtM) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(lightGray100)
            .padding(15.dp)
    ) {
        Text(
            text = userAndLibraryOtM.user.userId.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = userAndLibraryOtM.user.name,
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = userAndLibraryOtM.user.age.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }

}

 */

/*
@Composable
fun LibraryDataList(library: Library) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(lightGray100)
            .padding(15.dp)
    ) {
        Text(
            text = library.id.toString(),
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = library.title,
            modifier = Modifier.weight(0.3f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}
 */