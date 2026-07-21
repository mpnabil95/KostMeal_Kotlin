package com.example.kostmeal.data

import com.example.kostmeal.R
import com.example.kostmeal.model.MenuMakanan

object MenuData {

    fun getMenuMakanan(): List<MenuMakanan> {
        return listOf(
            MenuMakanan(
                nama = "Nasi Telur Kecap",
                kategori = "Sarapan",
                harga = 8000,
                tingkatKesulitan = "Mudah",
                label = "Hemat",
                bahan = listOf(
                    "1 piring nasi putih",
                    "1 butir telur",
                    "Kecap manis secukupnya",
                    "Garam secukupnya",
                    "Minyak goreng"
                ),
                caraMembuat = "Goreng telur hingga matang. Siapkan nasi putih, tambahkan telur di atasnya, lalu beri kecap sesuai selera.",
                deskripsi = "Menu sederhana, murah, cepat dibuat, dan cocok untuk anak kos saat pagi hari.",
                gambar = R.drawable.nasi_telur_kecap
            ),
            MenuMakanan(
                nama = "Mie Goreng Sayur",
                kategori = "Makan Malam",
                harga = 10000,
                tingkatKesulitan = "Mudah",
                label = "Praktis",
                bahan = listOf(
                    "1 bungkus mie instan",
                    "Sawi atau kol",
                    "1 butir telur",
                    "Cabai sesuai selera",
                    "Air secukupnya"
                ),
                caraMembuat = "Rebus mie sebentar. Tumis sayur dan telur, lalu campurkan mie dengan bumbu. Masak hingga matang.",
                deskripsi = "Menu praktis untuk malam hari dengan tambahan sayur agar lebih bergizi.",
                gambar = R.drawable.mie_goreng_sayur
            ),
            MenuMakanan(
                nama = "Tumis Kangkung Tempe",
                kategori = "Makan Siang",
                harga = 12000,
                tingkatKesulitan = "Sedang",
                label = "Sehat",
                bahan = listOf(
                    "1 ikat kangkung",
                    "Tempe secukupnya",
                    "Bawang merah",
                    "Bawang putih",
                    "Garam dan penyedap"
                ),
                caraMembuat = "Tumis bawang hingga harum, masukkan tempe, lalu masukkan kangkung. Tambahkan bumbu dan masak sebentar.",
                deskripsi = "Menu sehat dan hemat yang cocok untuk makan siang anak kos.",
                gambar = R.drawable.tumis_kangkung_tempe
            ),
            MenuMakanan(
                nama = "Nasi Ayam Suwir",
                kategori = "Makan Siang",
                harga = 15000,
                tingkatKesulitan = "Sedang",
                label = "Mengenyangkan",
                bahan = listOf(
                    "1 piring nasi",
                    "Ayam rebus",
                    "Bawang merah",
                    "Bawang putih",
                    "Cabai",
                    "Kecap atau saus"
                ),
                caraMembuat = "Suwir ayam rebus. Tumis bumbu hingga harum, masukkan ayam suwir, lalu sajikan bersama nasi.",
                deskripsi = "Menu mengenyangkan dengan protein yang cukup untuk aktivitas kuliah.",
                gambar = R.drawable.nasi_ayam_suwir
            ),
            MenuMakanan(
                nama = "Oat Pisang",
                kategori = "Sarapan",
                harga = 12000,
                tingkatKesulitan = "Mudah",
                label = "Sehat",
                bahan = listOf(
                    "Oat secukupnya",
                    "1 buah pisang",
                    "Susu cair atau air panas",
                    "Madu jika ada"
                ),
                caraMembuat = "Campurkan oat dengan susu atau air panas. Tambahkan potongan pisang dan madu jika tersedia.",
                deskripsi = "Menu sarapan sehat, ringan, dan cocok untuk mahasiswa yang ingin makan praktis.",
                gambar = R.drawable.oat_pisang
            ),
            MenuMakanan(
                nama = "Roti Telur",
                kategori = "Sarapan",
                harga = 10000,
                tingkatKesulitan = "Mudah",
                label = "Praktis",
                bahan = listOf(
                    "2 lembar roti tawar",
                    "1 butir telur",
                    "Margarin",
                    "Saus atau mayones"
                ),
                caraMembuat = "Panggang roti dengan margarin. Goreng telur, lalu susun telur di antara roti.",
                deskripsi = "Menu cepat untuk sarapan sebelum berangkat kuliah.",
                gambar = R.drawable.roti_telur
            ),
            MenuMakanan(
                nama = "Nasi Sarden",
                kategori = "Makan Malam",
                harga = 17000,
                tingkatKesulitan = "Mudah",
                label = "Mengenyangkan",
                bahan = listOf(
                    "1 piring nasi",
                    "Sarden kaleng",
                    "Bawang merah",
                    "Bawang putih",
                    "Cabai"
                ),
                caraMembuat = "Tumis bawang dan cabai, masukkan sarden, lalu masak hingga mendidih. Sajikan dengan nasi.",
                deskripsi = "Menu praktis dan mengenyangkan untuk malam hari.",
                gambar = R.drawable.nasi_sarden
            ),
            MenuMakanan(
                nama = "Tahu Tempe Sambal",
                kategori = "Makan Siang",
                harga = 9000,
                tingkatKesulitan = "Mudah",
                label = "Hemat",
                bahan = listOf(
                    "Tahu",
                    "Tempe",
                    "Cabai",
                    "Bawang putih",
                    "Garam",
                    "Nasi putih"
                ),
                caraMembuat = "Goreng tahu dan tempe. Ulek cabai, bawang, dan garam. Sajikan dengan nasi hangat.",
                deskripsi = "Menu akhir bulan yang murah, sederhana, tetapi tetap mengenyangkan.",
                gambar = R.drawable.tahu_tempe_sambal
            ),
            MenuMakanan(
                nama = "Sup Telur Sayur",
                kategori = "Makan Malam",
                harga = 13000,
                tingkatKesulitan = "Sedang",
                label = "Sehat",
                bahan = listOf(
                    "1 butir telur",
                    "Wortel",
                    "Kol",
                    "Daun bawang",
                    "Bawang putih",
                    "Air secukupnya"
                ),
                caraMembuat = "Rebus air, masukkan bawang dan sayur. Tambahkan telur kocok, lalu masak hingga matang.",
                deskripsi = "Menu hangat dan sehat yang cocok saat malam atau ketika cuaca dingin.",
                gambar = R.drawable.sup_telur_sayur
            ),
            MenuMakanan(
                nama = "Nasi Nugget Mayo",
                kategori = "Makan Malam",
                harga = 14000,
                tingkatKesulitan = "Mudah",
                label = "Praktis",
                bahan = listOf(
                    "1 piring nasi",
                    "Nugget ayam",
                    "Mayones",
                    "Saus sambal",
                    "Minyak goreng"
                ),
                caraMembuat = "Goreng nugget hingga matang. Sajikan di atas nasi, lalu tambahkan mayones dan saus.",
                deskripsi = "Menu praktis untuk anak kos yang ingin makan cepat tanpa banyak persiapan.",
                gambar = R.drawable.nasi_nugget_mayo
            )
        )
    }
}