package edu.uph.m24si2.mobileapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.uph.m24si2.mobileapp.R
import edu.uph.m24si2.mobileapp.model.Mahasiswa

class MahasiswaAdapter (
    private val mahasiswaList: List<Mahasiswa>
): RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {
    class MahasiswaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            val txvStudentID: TextView =
                itemView.findViewById(R.id.txvStudentID)
            val txvNama: TextView =
                itemView.findViewById(R.id.txvNama)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = mahasiswaList[position]
        holder.txvNama.text = mahasiswa.nama
        holder.txvStudentID.text = mahasiswa.studentID
    }

    override fun getItemCount(): Int = mahasiswaList.size
}