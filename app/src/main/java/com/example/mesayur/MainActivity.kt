package com.example.mesayur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mesayur.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameNamaSayur()
    }

    private fun nameNamaSayur() {
        val namaSayur = arrayOf(
            "Broccoli",
            "Carrot",
            "Chili",
            "Cucumber",
            "Eggplant",
            "Lettuce",
            "Onion",
            "Peppers",
            "Potato",
            "Tomato"
        )

        val gambarSayur = arrayOf(
            R.drawable.broccoli,
            R.drawable.carrot,
            R.drawable.chilli,
            R.drawable.cucumber,
            R.drawable.eggplant,
            R.drawable.lettuce,
            R.drawable.onion,
            R.drawable.peppers,
            R.drawable.potato,
            R.drawable.tomato,
        )

        val suaraSayur = arrayOf(
            R.raw.broccoli,
            R.raw.carrot,
            R.raw.chilli,
            R.raw.cucumber,
            R.raw.eggplant,
            R.raw.lettuce,
            R.raw.onion,
            R.raw.peppers,
            R.raw.potato,
            R.raw.tomato,
        )

        val sayurAdapter = SayurAdapter(namaSayur, gambarSayur, suaraSayur)
        binding.rvSayur.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            setHasFixedSize(true)
            adapter = sayurAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if (item.itemId == R.id.menu_List){
            binding.rvSayur.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        if (item.itemId == R.id.menu_grid){
            binding.rvSayur.layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        return super.onOptionsItemSelected(item)
    }
}