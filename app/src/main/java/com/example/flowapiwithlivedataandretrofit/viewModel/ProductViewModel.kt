package com.example.flowapiwithlivedataandretrofit.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowapiwithlivedataandretrofit.Repository.ProductRepository
import com.example.flowapiwithlivedataandretrofit.model.ProductItem
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductViewModel (private val productRepository: ProductRepository) : ViewModel() {

    val productData: MutableLiveData<List<ProductItem>> = MutableLiveData()

    /*  way 1 */
    fun getProduct()
    {
        viewModelScope.launch {
            productRepository.getProduct()
                .catch { e->
                    Log.d("main", "getProduct: ${e.message}")
                }
                .collect {

                    productData.value = it
                }
        }
    }

    /*
       way 2
     val postData1:LiveData<List<Post>> = liveData {
          postRepository.getPost()
              .catch {  }
              .collect {postData->
                  emit(postData)
              }
      }
     */

    /*
    way 3
     val postData2:LiveData<List<Post>> = postRepository.getPost()
         .catch {  }
         .asLiveData()
     */
}