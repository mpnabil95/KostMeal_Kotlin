package com.example.kostmeal

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kostmeal.adapter.MenuAdapter
import com.example.kostmeal.data.MenuData
import com.example.kostmeal.databinding.ActivityMainBinding
import com.example.kostmeal.filter.KategoriFilter
import com.example.kostmeal.filter.MenuFilter
import com.example.kostmeal.model.MenuMakanan
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var menuAdapter: MenuAdapter

    private val semuaMenu: List<MenuMakanan> by lazy {
        MenuData.getMenuMakanan()
    }

    private var filterAktif: KategoriFilter = KategoriFilter.SEMUA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        filterAktif = savedInstanceState
            ?.getString(KEY_FILTER_AKTIF)
            ?.let { nama -> runCatching { KategoriFilter.valueOf(nama) }.getOrNull() }
            ?: KategoriFilter.SEMUA

        setupRecyclerView()
        setupButtonFilter()
        setupRekomendasi()
        terapkanFilter(filterAktif)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(KEY_FILTER_AKTIF, filterAktif.name)
        super.onSaveInstanceState(outState)
    }

    private fun setupRecyclerView() {
        menuAdapter = MenuAdapter { menu ->
            startActivity(DetailMenuActivity.newIntent(this, menu))
        }

        binding.rvMenu.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = menuAdapter
            setHasFixedSize(false)
        }
    }

    private fun setupButtonFilter() {
        binding.btnSemua.setOnClickListener {
            terapkanFilter(KategoriFilter.SEMUA)
        }

        binding.btnHemat.setOnClickListener {
            terapkanFilter(KategoriFilter.HEMAT)
        }

        binding.btnPraktis.setOnClickListener {
            terapkanFilter(KategoriFilter.PRAKTIS)
        }

        binding.btnSehat.setOnClickListener {
            terapkanFilter(KategoriFilter.SEHAT)
        }
    }

    private fun setupRekomendasi() {
        binding.btnRandom.setOnClickListener {
            semuaMenu.randomOrNull()?.let { menuAcak ->
                startActivity(DetailMenuActivity.newIntent(this, menuAcak))
            }
        }
    }

    private fun terapkanFilter(kategoriFilter: KategoriFilter) {
        filterAktif = kategoriFilter
        val hasilFilter = MenuFilter.terapkan(semuaMenu, kategoriFilter)

        menuAdapter.submitList(hasilFilter.toList())
        tampilkanRingkasan(hasilFilter)
        tampilkanPesanFilter(kategoriFilter)
        perbaruiTampilanTombol(kategoriFilter)
    }

    private fun tampilkanRingkasan(daftarMenu: List<MenuMakanan>) {
        val jumlahHemat = MenuFilter.hitungMenuHemat(daftarMenu)
        binding.tvJumlahMenu.text = getString(
            R.string.format_ringkasan_menu,
            daftarMenu.size,
            jumlahHemat
        )
    }

    private fun tampilkanPesanFilter(kategoriFilter: KategoriFilter) {
        binding.tvRekomendasi.setText(
            when (kategoriFilter) {
                KategoriFilter.SEMUA -> R.string.pesan_filter_semua
                KategoriFilter.HEMAT -> R.string.pesan_filter_hemat
                KategoriFilter.PRAKTIS -> R.string.pesan_filter_praktis
                KategoriFilter.SEHAT -> R.string.pesan_filter_sehat
            }
        )
    }

    private fun perbaruiTampilanTombol(kategoriFilter: KategoriFilter) {
        val daftarTombol = listOf(
            KategoriFilter.SEMUA to binding.btnSemua,
            KategoriFilter.HEMAT to binding.btnHemat,
            KategoriFilter.PRAKTIS to binding.btnPraktis,
            KategoriFilter.SEHAT to binding.btnSehat
        )

        for ((filter, tombol) in daftarTombol) {
            aturStatusTombol(tombol, filter == kategoriFilter)
        }
    }

    private fun aturStatusTombol(tombol: MaterialButton, aktif: Boolean) {
        val warnaOranye = ContextCompat.getColor(this, R.color.orange_primary)
        val warnaPutih = ContextCompat.getColor(this, R.color.white)
        val warnaTransparan = ContextCompat.getColor(this, android.R.color.transparent)

        tombol.backgroundTintList = ColorStateList.valueOf(
            if (aktif) warnaOranye else warnaTransparan
        )
        tombol.strokeColor = ColorStateList.valueOf(warnaOranye)
        tombol.setTextColor(if (aktif) warnaPutih else warnaOranye)
        tombol.isSelected = aktif
    }

    companion object {
        private const val KEY_FILTER_AKTIF = "filter_aktif"
    }
}
