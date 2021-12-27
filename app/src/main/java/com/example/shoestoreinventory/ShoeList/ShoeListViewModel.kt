package com.example.shoestoreinventory.ShoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinventory.datastore.Shoe
import timber.log.Timber
import java.util.ArrayList

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()

    val shoeList : LiveData<ArrayList<Shoe>> get() = _shoeList

    init {
        _shoeList.value = ArrayList()
        Timber.i("ShoeListViewModel initialized")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeListViewModel Destroyed")
    }


    fun addShoe(shoe:Shoe){
        _shoeList.value?.add(shoe)
    }

    fun removeShoe(shoe: Shoe){
        _shoeList.value?.remove(shoe)
    }

    fun getShoeList(): ArrayList<Shoe>?{
        return _shoeList.value
    }

}