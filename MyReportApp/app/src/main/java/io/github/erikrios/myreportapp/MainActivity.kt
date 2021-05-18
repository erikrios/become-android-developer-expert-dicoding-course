package io.github.erikrios.myreportapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.github.erikrios.myreportapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCrash.setOnClickListener {
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            throw RuntimeException("Test Crash")
        }
    }
}