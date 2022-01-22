package com.example.flowapiwithlivedataandretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flowapiwithlivedataandretrofit.Repository.ProductRepository
import com.example.flowapiwithlivedataandretrofit.adapter.ProductAdapter
import com.example.flowapiwithlivedataandretrofit.model.ProductItem
import com.example.flowapiwithlivedataandretrofit.viewModel.ProductViewModel
import com.example.flowapiwithlivedataandretrofit.viewModel.ProductViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG="main"
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productViewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
        productAdapter= ProductAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=productAdapter
        }

        val productViewModelFactory=ProductViewModelFactory(ProductRepository())
        productViewModel= ViewModelProvider(this,productViewModelFactory)[ProductViewModel::class.java]
        productViewModel.getProduct()
        productViewModel.productData.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it[0].title}")
            productAdapter.setPostData(it as ArrayList<ProductItem>)
            progressBar.visibility= View.GONE
            recyclerView.visibility=View.VISIBLE
        })
    }
}