package edu.uph.m24si2.mobileapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import edu.uph.m24si2.mobileapp.adapter.MahasiswaAdapter
import edu.uph.m24si2.mobileapp.model.Mahasiswa

class MainActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerMahasiswa: RecyclerView
    private lateinit var adapter: MahasiswaAdapter
    private val mahasiswaList = ArrayList<Mahasiswa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        recyclerMahasiswa = findViewById(R.id.recyclerMahasiswa)
        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        recyclerMahasiswa.layoutManager = LinearLayoutManager(this)
        adapter = MahasiswaAdapter(mahasiswaList)
    }
}