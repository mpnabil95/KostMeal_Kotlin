package com.example.kostmeal

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kostmeal.databinding.ActivityDetailMenuBinding
import com.example.kostmeal.model.MenuMakanan

class DetailMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menu = ambilMenuDariIntent()
        if (menu == null) {
            Toast.makeText(this, R.string.pesan_data_menu_tidak_ditemukan, Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        tampilkanDetail(menu)
        binding.btnKembali.setOnClickListener { finish() }
    }

    private fun tampilkanDetail(menu: MenuMakanan) = with(binding) {
        imgDetailMenu.setImageResource(menu.gambar)
        imgDetailMenu.contentDescription = getString(R.string.deskripsi_gambar_menu, menu.nama)

        tvDetailNama.text = menu.nama
        tvDetailHarga.text = menu.formatHarga()
        tvDetailKategori.text = menu.kategori
        tvDetailLabel.text = menu.label
        tvDetailKesulitan.text = menu.tingkatKesulitan
        tvDetailDeskripsi.text = menu.deskripsi
        tvDetailBahan.text = menu.bahanSebagaiTeks()
        tvDetailCaraMembuat.text = menu.caraMembuat

        aturWarnaLabel(tvDetailLabel, menu.label)
        aturWarnaKesulitan(tvDetailKesulitan, menu.tingkatKesulitan)
    }

    private fun aturWarnaLabel(textView: TextView, label: String) {
        val (background, warnaTeks) = when (label.lowercase()) {
            "hemat" -> R.drawable.bg_badge_green to R.color.green_primary
            "praktis" -> R.drawable.bg_badge_blue to R.color.blue_primary
            "sehat" -> R.drawable.bg_badge_teal to R.color.teal_primary
            "mengenyangkan" -> R.drawable.bg_badge_purple to R.color.purple_primary
            else -> R.drawable.bg_badge_blue to R.color.blue_primary
        }

        textView.setBackgroundResource(background)
        textView.setTextColor(ContextCompat.getColor(this, warnaTeks))
    }

    private fun aturWarnaKesulitan(textView: TextView, kesulitan: String) {
        val (background, warnaTeks) = when (kesulitan.lowercase()) {
            "mudah" -> R.drawable.bg_badge_orange to R.color.orange_primary
            "sedang" -> R.drawable.bg_badge_blue to R.color.blue_primary
            else -> R.drawable.bg_badge_purple to R.color.purple_primary
        }

        textView.setBackgroundResource(background)
        textView.setTextColor(ContextCompat.getColor(this, warnaTeks))
    }

    @Suppress("DEPRECATION")
    private fun ambilMenuDariIntent(): MenuMakanan? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_MENU, MenuMakanan::class.java)
        } else {
            intent.getSerializableExtra(EXTRA_MENU) as? MenuMakanan
        }
    }

    companion object {
        private const val EXTRA_MENU = "extra_menu"

        fun newIntent(context: Context, menu: MenuMakanan): Intent {
            return Intent(context, DetailMenuActivity::class.java).apply {
                putExtra(EXTRA_MENU, menu)
            }
        }
    }
}
