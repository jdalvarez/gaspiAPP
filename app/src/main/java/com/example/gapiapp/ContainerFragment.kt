package com.example.gapiapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gapiapp.databinding.FragmentContainerBinding
import com.example.gapiapp.dto.ApiService
import com.example.gapiapp.ui.SimplePost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ContainerFragment : Fragment() {

    private lateinit var binding: FragmentContainerBinding

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getResponse() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = getRetrofit().create(ApiService::class.java).getItems()

                if (response.isSuccessful) {
                    val redditResponse = response.body()
                    val listResult = redditResponse?.data?.children
                    val simpleList = listResult?.map {
                        SimplePost(
                            it.data?.numComments,
                            it.data?.title,
                            it.data?.secureMedia?.oembed?.thumbnailUrl
                        )
                    }
                    simpleList?.forEach {
                        Log.d(
                            "mensaje",
                            "Title: ${it.title}, Num of Comments: ${it.numComments}, Image: ${it.thumbnailUrl}"
                        )
                    }
                } else {
                    //show en error
                }

            } catch (e: Exception) {
                Log.d("exception", "${e.message}")
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContainerBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onResume() {
        super.onResume()
        getResponse()
    }
}

