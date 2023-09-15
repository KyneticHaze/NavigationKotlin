package com.example.navigationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationkotlin.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            // Second Fragment'ta bir argüman belirlediğimiz için SecondFragmentArgs diye bir sınıf otomatikman oluşturuldu.
            val kullaniciAdi = SecondFragmentArgs.fromBundle(it).username

            binding.text2.text = kullaniciAdi
        }

        val secondButton = binding.secondFragmentButton

        secondButton.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()

            Navigation.findNavController(it).navigate(action)
        }
    }
}