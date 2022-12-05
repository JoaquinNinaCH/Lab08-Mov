package com.miempresa.proyectousomenus

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lista.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this)

        var llenarLista = ArrayList<Elementos>()
        for (i in 1..20){
            llenarLista.add(
                Elementos("Elemento "+i,
                    BitmapFactory.decodeResource(resources, R.drawable.imgconfiguracion))
            )
        }
        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter
        registerForContextMenu(lista)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nombre -> {
                Toast.makeText(this, "Elegiste nombre", Toast.LENGTH_LONG).show()
            }
            R.id.semestre -> {
                Toast.makeText(this, "Elegiste semestre", Toast.LENGTH_LONG).show()
            }
            R.id.email -> {
                Toast.makeText(this, "Elegiste email", Toast.LENGTH_LONG).show()
            }
            R.id.carrera -> {
                Toast.makeText(this, "Elegiste carrera", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menucontextual,menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.configuracion){
            //Toast.makeText(this, "Elegiste menu configuracion",Toast.LENGTH_LONG).show()
            val llamarActividad = Intent(applicationContext, Configuracion::class.java)
            startActivity(llamarActividad)
            return true
        }
        if (id == R.id.informacion){
            //Toast.makeText(this, "Elegiste menu informacion",Toast.LENGTH_LONG).show()
            val llamarActividad = Intent(applicationContext, Informacion::class.java)
            startActivity(llamarActividad)
            return true
        }
        if (id == android.R.id.home){
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> Toast.makeText(this, "Elegiste menu inicio", Toast.LENGTH_LONG).show()
            R.id.nav_settings -> {
                val llamarActividad = Intent(applicationContext, ListaCardView::class.java)
                startActivity(llamarActividad)
            }
        }
        return true
    }
}