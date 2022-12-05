package com.miempresa.proyectousomenus

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class ListaCardView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_card_view)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Elementos>()
        for (i in 1..20) {
            llenarLista.add(Elementos("Elemento "+i,
                BitmapFactory.decodeResource(resources, R.drawable.imgconfiguracion)))
        }

        val adapter = AdaptadorCardView(llenarLista)
        lista.adapter = adapter
    }
}