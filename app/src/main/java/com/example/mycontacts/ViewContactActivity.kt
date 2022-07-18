package com.example.mycontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mycontacts.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class ViewConatactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
        getImageMainActivity()
    }

    fun getImageMainActivity(){
        binding.imgContact1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    fun getExtras(){
        val extras = intent.extras
        binding.tvName1.text= extras?.getString("NAME","")
        binding.tvNum2.text= extras?.getString("EMAIL","")
        binding.tvText1.text= extras?.getString("PHONE NUMBER","")
        binding.tvText2.text= extras?.getString("ADDRESS","")
        val imgContact1= extras?.getString("IMAGE","")
        Picasso.get().load(imgContact1)
            .placeholder(R.drawable.ic_baseline_person_24)
            .resize(350,350)
            .centerCrop()
            .into(binding.imgContact1)
//        binding.tvText4.text= extras?.getString("","")

        //Toast.makeText(this, "$name: $email", Toast.LENGTH_LONG).show()
    }
}