package com.vrushank.crickstars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vrushank.crickstars.data.repository.TeamRepository
import com.vrushank.crickstars.data.room.PlayerDataBase
import com.vrushank.crickstars.presentation.HomeScreen
import com.vrushank.crickstars.presentation.MainViewModel
import com.vrushank.crickstars.presentation.SelectTeamPlayers
import com.vrushank.crickstars.presentation.StartNewMatch
import com.vrushank.crickstars.ui.theme.CrickStarsTheme
import com.vrushank.crickstars.util.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dao = PlayerDataBase.getInstance(this).teamDao()
        val vm:MainViewModel by viewModels {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(MainViewModel::class.java)){

                        val repo = TeamRepository(dao)
                        @Suppress("UNCHECKED_CAST")
                        return MainViewModel(repo) as T
                    }
                    throw IllegalArgumentException("not valid viewModel")
                }
            }
        }


        setContent {
            CrickStarsTheme {


                val navController = rememberNavController()

                NavHost(navController,Screens.Home.route){
                    composable(Screens.Home.route){
                        HomeScreen(){
                           navController.navigate(it)
                        }
                    }
                    composable(Screens.NewMatch.route){
                        StartNewMatch({navController.navigate(it)},{navController.navigate(it)})
                    }
                    composable(Screens.SelectTeamPlayers.route){
                        SelectTeamPlayers({return@SelectTeamPlayers vm.teamName},{
                            vm.teamName = it
                        },{ vm.saveTeam()})
                    }
                }

                }
            }
        }
    }


