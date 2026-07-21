package com.example.kostmeal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kostmeal.R
import com.example.kostmeal.databinding.ItemMenuBinding
import com.example.kostmeal.model.MenuMakanan

class MenuAdapter(
    private val onItemClick: (MenuMakanan) -> Unit
) : ListAdapter<MenuMakanan, MenuAdapter.MenuViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MenuViewHolder(
        private val binding: ItemMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(menu: MenuMakanan) = with(binding) {
            imgMenu.setImageResource(menu.gambar)
            imgMenu.contentDescription = root.context.getString(
                R.string.deskripsi_gambar_menu,
                menu.nama
            )

            tvNamaMenu.text = menu.nama
            tvHargaMenu.text = menu.formatHarga()
            tvKategoriMenu.text = menu.kategori
            tvLabelMenu.text = menu.label
            tvKesulitanMenu.text = menu.tingkatKesulitan
            tvDeskripsiMenu.text = menu.deskripsi

            aturWarnaLabel(tvLabelMenu, menu.label)
            root.contentDescription = menu.getInfoSingkat()
            root.setOnClickListener { onItemClick(menu) }
        }

        private fun aturWarnaLabel(textView: TextView, label: String) {
            val context = textView.context
            val (background, warnaTeks) = when (label.lowercase()) {
                "hemat" -> R.drawable.bg_badge_green to R.color.green_primary
                "praktis" -> R.drawable.bg_badge_blue to R.color.blue_primary
                "sehat" -> R.drawable.bg_badge_teal to R.color.teal_primary
                "mengenyangkan" -> R.drawable.bg_badge_purple to R.color.purple_primary
                else -> R.drawable.bg_badge_blue to R.color.blue_primary
            }

            textView.setBackgroundResource(background)
            textView.setTextColor(ContextCompat.getColor(context, warnaTeks))
        }


    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MenuMakanan>() {
            override fun areItemsTheSame(
                oldItem: MenuMakanan,
                newItem: MenuMakanan
            ): Boolean = oldItem.nama == newItem.nama

            override fun areContentsTheSame(
                oldItem: MenuMakanan,
                newItem: MenuMakanan
            ): Boolean = oldItem == newItem
        }
    }
}
