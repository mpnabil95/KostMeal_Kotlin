package com.example.kostmeal.filter

import com.example.kostmeal.data.MenuData
import org.junit.Assert.assertEquals
import org.junit.Test

class MenuDataIntegrationTest {

    private val semuaMenu = MenuData.getMenuMakanan()

    @Test
    fun dataUtama_memilikiSepuluhMenuDanEmpatMenuHemat() {
        assertEquals(10, semuaMenu.size)
        assertEquals(4, MenuFilter.hitungMenuHemat(semuaMenu))
    }

    @Test
    fun filterPraktis_memilikiTigaMenuDanDuaDiAntaranyaHemat() {
        val hasil = MenuFilter.terapkan(semuaMenu, KategoriFilter.PRAKTIS)
        assertEquals(3, hasil.size)
        assertEquals(2, MenuFilter.hitungMenuHemat(hasil))
    }

    @Test
    fun filterSehat_memilikiTigaMenuDanTidakAdaYangHemat() {
        val hasil = MenuFilter.terapkan(semuaMenu, KategoriFilter.SEHAT)
        assertEquals(3, hasil.size)
        assertEquals(0, MenuFilter.hitungMenuHemat(hasil))
    }
}
