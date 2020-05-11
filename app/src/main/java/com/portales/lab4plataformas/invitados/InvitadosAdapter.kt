package com.portales.lab4plataformas.invitados

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portales.lab4plataformas.R
import kotlinx.android.synthetic.main.invitado_elemento.view.*
import java.lang.Exception

class InvitadosAdapter(private var context: Context, private var List : ArrayList<Invitado>) : RecyclerView.Adapter<InvitadosAdapter.ViewHolder>() {

    private lateinit var view: View

    inner class ViewHolder(var item: View) : RecyclerView.ViewHolder(item){
        fun info(invitado:Invitado, position: Int){
            item.t1.setText((position + 1).toString())
            item.t2.setText(invitado.nombre)
            item.t3.setText(invitado.telefono)
            item.t4.setText(invitado.correo)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvitadosAdapter.ViewHolder {
        view = LayoutInflater.from(context).inflate(R.layout.invitado_elemento,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: InvitadosAdapter.ViewHolder, position: Int) {
        var invitado = List.get(position)
        holder.info(invitado,position)
    }


}