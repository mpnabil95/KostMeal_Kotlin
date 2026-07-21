# Kost Meal

Aplikasi Android berbasis Kotlin dan XML untuk menampilkan rekomendasi menu makanan anak kos. Data disimpan secara statis di dalam project tanpa database atau API.

## Fitur yang tersedia

- Menampilkan 10 menu makanan statis.
- Filter Semua, Hemat, Praktis, dan Sehat.
- Ringkasan jumlah menu dan jumlah menu hemat.
- Rekomendasi menu secara acak.
- Halaman detail berisi harga, kategori, label, tingkat kesulitan, bahan, dan cara membuat.

## Perbaikan pada versi 1.1

- View Binding untuk mengurangi risiko salah ID pada view.
- `ListAdapter` dan `DiffUtil` untuk pembaruan RecyclerView yang lebih aman.
- Pengiriman satu objek `MenuMakanan` ke halaman detail.
- Status tombol filter aktif terlihat jelas dan dipertahankan saat rotasi layar.
- Warna badge menyesuaikan label dan tingkat kesulitan.
- Teks antarmuka dipindahkan ke `strings.xml`.
- Logika filter dipisahkan agar lebih mudah diuji.
- Ditambahkan perulangan eksplisit, percabangan, function, collection, dan OOP.
- Ditambahkan unit test untuk model dan filter.
- Project dibersihkan dari cache dan hasil build Android Studio.

## Cara menjalankan

1. Ekstrak ZIP.
2. Buka folder `KostMeal` melalui Android Studio.
3. Tunggu proses Gradle Sync selesai.
4. Jalankan aplikasi pada emulator atau perangkat Android minimal Android 6.0 (API 23).

Android Studio akan membuat `local.properties`, folder `.gradle`, `.idea`, dan hasil build secara otomatis pada komputer pengguna.
