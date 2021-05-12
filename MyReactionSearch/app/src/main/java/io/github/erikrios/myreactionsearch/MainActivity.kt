package io.github.erikrios.myreactionsearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    @FlowPreview
    val viewModel: MainViewModel by viewModels()

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edPlace = findViewById<AutoCompleteTextView>(R.id.ed_place)

        edPlace.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                lifecycleScope.launch {
                    viewModel.queryChannel.send(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        viewModel.searchResult.observe(this, { placesItem ->
            val placesName = arrayListOf<String?>()
            placesItem.map {
                placesName.add(it.placeName)
            }
            val adapter =
                ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, placesName)
            adapter.notifyDataSetChanged()
            edPlace.setAdapter(adapter)
        })
    }
}