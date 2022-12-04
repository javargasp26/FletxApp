package com.example.fletxapp.ui.main_activity.view.adapter

import android.content.Context
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fletxapp.databinding.RowItemBinding
import com.example.fletxapp.domain.Model

class DataViewHolder(private val itemBinding: RowItemBinding, viewHolderListener: ViewHolderListener) :
    RecyclerView.ViewHolder(itemBinding.root) {

    private val holder: ViewHolderListener = viewHolderListener

    fun bind(model: Model, context: Context) {
        itemBinding.tvDriverName.text = model.driverName
        itemBinding.tvLicensePlate.text = model.licensePlate
        itemBinding.tvTrailerLicensePlate.text = "Trailer" + model.trailerLicensePlate

        itemBinding.lytContentCard.setOnClickListener {
            holder.onClickItem(layoutPosition)
        }

        bindImage(itemBinding.imgRow, model.imageUrl)
    }

    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri =
                imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .into(imgView)
        }
    }

    interface ViewHolderListener {
        fun onClickItem(
            position: Int
        )
    }
}