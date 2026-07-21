package com.example.kostmeal

import com.example.kostmeal.model.MenuMakanan
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MenuMakananTest {

    private val menu = MenuMakanan(
        nama = "Nasi Telur Kecap",
        kategori = "Sarapan",
        harga = 8_000,
        tingkatKesulitan = "Mudah",
        label = "Hemat",
        bahan = listOf("Nasi", "Telur", "Kecap"),
        caraMembuat = "Masak dan sajikan.",
        deskripsi = "Menu sederhana.",
        gambar = 0
    )

    @Test
    fun formatHarga_menggunakanFormatRupiahIndonesia() {
        assertEquals("Rp8.000", menu.formatHarga())
    }

    @Test
    fun isHemat_benarUntukHargaMaksimalSepuluhRibu() {
        assertTrue(menu.isHemat())
        assertFalse(menu.copy(harga = 10_001).isHemat())
    }

    @Test
    fun bahanSebagaiTeks_membuatDaftarBerpoin() {
        assertEquals("• Nasi\n• Telur\n• Kecap", menu.bahanSebagaiTeks())
    }
}
