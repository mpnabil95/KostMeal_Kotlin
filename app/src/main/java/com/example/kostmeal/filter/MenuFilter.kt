package com.example.kostmeal.filter

import com.example.kostmeal.model.MenuMakanan

enum class KategoriFilter {
    SEMUA,
    HEMAT,
    PRAKTIS,
    SEHAT
}

object MenuFilter {

    fun terapkan(
        semuaMenu: List<MenuMakanan>,
        kategoriFilter: KategoriFilter
    ): List<MenuMakanan> {
        return when (kategoriFilter) {
            KategoriFilter.SEMUA -> semuaMenu
            KategoriFilter.HEMAT -> semuaMenu.filter { it.isHemat() }
            KategoriFilter.PRAKTIS -> semuaMenu.filter {
                it.label.equals("Praktis", ignoreCase = true)
            }
            KategoriFilter.SEHAT -> semuaMenu.filter {
                it.label.equals("Sehat", ignoreCase = true)
            }
        }
    }

    fun hitungMenuHemat(daftarMenu: List<MenuMakanan>): Int {
        var jumlah = 0

        for (menu in daftarMenu) {
            if (menu.isHemat()) jumlah++
        }

        return jumlah
    }
}
