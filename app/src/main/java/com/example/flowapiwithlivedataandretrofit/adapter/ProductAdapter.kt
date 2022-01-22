package com.example.flowapiwithlivedataandretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flowapiwithlivedataandretrofit.model.ProductItem
import com.example.flowapiwithlivedataandretrofit.R

class ProductAdapter (private val context: Context, private var productList:ArrayList<ProductItem>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product=productList[position]
        holder.title.text=product.title
    }

    override fun getItemCount(): Int =productList.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView =itemView.findViewById(R.id.body)
    }

    fun setPostData(productList: ArrayList<ProductItem>)
    {
        this.productList=productList
        notifyDataSetChanged()
    }
}