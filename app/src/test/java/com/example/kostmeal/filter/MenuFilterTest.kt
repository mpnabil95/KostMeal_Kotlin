package com.example.kostmeal.filter

import com.example.kostmeal.model.MenuMakanan
import org.junit.Assert.assertEquals
import org.junit.Test

class MenuFilterTest {

    private val menu = listOf(
        buatMenu("A", 8_000, "Hemat"),
        buatMenu("B", 10_000, "Praktis"),
        buatMenu("C", 12_000, "Sehat"),
        buatMenu("D", 14_000, "Praktis")
    )

    @Test
    fun filterHemat_menggunakanBatasHargaMaksimalSepuluhRibu() {
        assertEquals(2, MenuFilter.terapkan(menu, KategoriFilter.HEMAT).size)
    }

    @Test
    fun filterPraktis_menggunakanLabelPraktis() {
        assertEquals(2, MenuFilter.terapkan(menu, KategoriFilter.PRAKTIS).size)
    }

    @Test
    fun hitungMenuHemat_menghitungDenganBenar() {
        assertEquals(2, MenuFilter.hitungMenuHemat(menu))
    }

    private fun buatMenu(nama: String, harga: Int, label: String): MenuMakanan {
        return MenuMakanan(
            nama = nama,
            kategori = "Sarapan",
            harga = harga,
            tingkatKesulitan = "Mudah",
            label = label,
            bahan = emptyList(),
            caraMembuat = "-",
            deskripsi = "-",
            gambar = 0
        )
    }
}
