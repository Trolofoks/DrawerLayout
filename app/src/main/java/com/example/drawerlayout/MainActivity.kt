package com.example.drawerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.drawerlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //дает id кнопок и фрагментов
    lateinit var conf: AppBarConfiguration
    //контроллер через navigation
    lateinit var navController: NavController

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // добавляем поддержку Тул бара через !!!include
        setSupportActionBar(binding.include.toolbar)

        navController = findNavController(R.id.fragmentContainerView)
        conf = AppBarConfiguration(
            setOf(
                //на кнопке и на фрагменте(в navigation) должен быть одинаковый id
                R.id.item1,
                R.id.item2
            ),
            //указываем наш drawerLayout на котором идет переключение
            binding.drawerLayout
        )
        //настраиваем работу Toolbar с контролером
        setupActionBarWithNavController(navController, conf)
        //присоединяем меню и контроллер
        binding.navigationMenu.setupWithNavController(navController)

    }

    //чтобы работала кнопка Вызвать меню слева сверху
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(conf) || super.onSupportNavigateUp()
    }
}