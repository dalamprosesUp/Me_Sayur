package com.example.mesayur

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SayurAdapter (
    val namaSayur: Array<String>,
    val gambarSayur: Array<Int>,
    val suaraSayur: Array<Int>
) : RecyclerView.Adapter<SayurAdapter.MyViewHolder>() {

    //    1. Deklarasi variabel yang terbuhung dengan layout
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaBuah = view.findViewById<TextView>(R.id.item_tv_sayur)
        val ivGambarBuah = view.findViewById<ImageView>(R.id.item_img)
    }
    //    2. Call Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SayurAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_row_sayur,parent, false)
        return MyViewHolder(view)
    }
    //    3. Penempatan data dengan widget sesuai urutan data
    override fun onBindViewHolder(holder: SayurAdapter.MyViewHolder, position: Int) {
        holder.tvNamaBuah.text = namaSayur[position]
        holder.ivGambarBuah.setImageResource(gambarSayur[position])
        holder.itemView.setOnClickListener {
            val mediaPlayer =  MediaPlayer.create(holder.itemView.context, suaraSayur[position])
            mediaPlayer.start()
        }
    }

    //    4. Seberapa banyak data yang ingin dikembalikan
    override fun getItemCount(): Int {
        return namaSayur.size
    }
}