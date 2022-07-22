package com.example.myapplication.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemImageBinding
import com.squareup.picasso.Picasso

private const val TAG = "ImageAdapter"
class ImageAdapter(private var dataSet: List<String>): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    fun updateNextPage(newDataSet: List<String>){
        //dataSet.toMutableList().addAll(newDataSet)
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    class ImageViewHolder(private val binding: ItemImageBinding):
        RecyclerView.ViewHolder(binding.root){
            fun onBind(itemImage: String){
                Log.d(TAG, "onBind: #${itemImage}")

                Picasso.get().load(
                    itemImage
                )
                    .into(
                    binding.itemImage
                )
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        holder.onBind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}