package com.example.gifswithmvvm

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gifswithmvvm.databinding.ActivityMainBinding
import com.example.gifswithmvvm.databinding.DialogBinding
import com.example.gifswithmvvm.domain.model.Original
import com.example.gifswithmvvm.domain.model.ThisData
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getGift()
    }

    private fun getGift() {
        val viewModel by viewModel<ViewModel>()

        binding.btnSearch.setOnClickListener {
            viewModel.getAllViewModelGifts(binding.searchGifts.text.toString())
            viewModel.gifts.observe(this@MainActivity, Observer {
                with(binding.recyclerGifts) {
                    layoutManager = GridLayoutManager(
                        this@MainActivity,
                        3,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    adapter = AdapterGifList(it) {
                        openDialog(it)
                    }

                }
            })
        }
    }

    private fun openDialog(gif: Original) {
        val dialogBinding = DialogBinding.inflate(LayoutInflater.from(this))
        val dialog = Dialog(this)
        with(dialog) {
            setContentView(dialogBinding.root)
        }
        val link = gif.url
        val send = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, link)
            type = "text/plan"
        }

        Glide.with(this).load(gif.url).into(dialogBinding.sendGif)
        val shareActionGif = Intent.createChooser(send, null)

        dialogBinding.share.setOnClickListener {
            startActivity(shareActionGif)
            // dialog.dismiss()
        }
        dialog.show()

    }
}