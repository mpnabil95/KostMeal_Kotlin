package com.example.kostmeal.model

import java.io.Serializable
import java.text.NumberFormat
import java.util.Locale

data class MenuMakanan(
    val nama: String,
    val kategori: String,
    val harga: Int,
    val tingkatKesulitan: String,
    val label: String,
    val bahan: List<String>,
    val caraMembuat: String,
    val deskripsi: String,
    val gambar: Int
) : Serializable {

    fun formatHarga(): String {
        val angka = NumberFormat.getNumberInstance(Locale.forLanguageTag("id-ID")).format(harga)
        return "Rp$angka"
    }

    fun isHemat(): Boolean = harga <= BATAS_HARGA_HEMAT

    fun getKategoriHarga(): String {
        return when {
            harga <= BATAS_HARGA_HEMAT -> "Menu Hemat"
            harga <= BATAS_HARGA_STANDAR -> "Menu Standar"
            else -> "Menu Spesial"
        }
    }

    fun getInfoSingkat(): String {
        return "$nama adalah $label, termasuk ${getKategoriHarga()}, dengan estimasi harga ${formatHarga()}."
    }

    fun bahanSebagaiTeks(): String {
        val hasil = StringBuilder()

        // Perulangan eksplisit dipakai agar konsep loop terlihat jelas dalam project.
        for ((index, item) in bahan.withIndex()) {
            hasil.append("• ").append(item)
            if (index < bahan.lastIndex) hasil.append('\n')
        }

        return hasil.toString()
    }

    companion object {
        const val BATAS_HARGA_HEMAT = 10_000
        private const val BATAS_HARGA_STANDAR = 15_000
    }
}
