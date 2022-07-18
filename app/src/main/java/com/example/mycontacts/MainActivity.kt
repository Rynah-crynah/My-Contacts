package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContact()
    }

    fun displayContact(){
        var contact1 = Contact("Suu", "0777333600", "suhailayusuf1999@gmail.com", "BlueRoom","https://images.unsplash.com/photo-1583147610149-78ac5cb5a303?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8YmxhY2slMjBhbWVyaWNhbiUyMGxhZGllc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60")
        var contact2 = Contact("Sham", "0700874576", "shamunyusf@gmail.com", "BlueRoom","https://media.istockphoto.com/photos/emotional-african-american-man-with-african-hairstyle-picture-id1319662868?k=20&m=1319662868&s=612x612&w=0&h=kJGhd54o_bsRDTQHrerOrdbF_sLAav-MkFBHcvrso5w=")
        var contact3 = Contact("Bhabhii", "0712944214", "suhailyusuf1999@gmail.com", "BlueRoom","https://media.istockphoto.com/photos/joyful-student-with-phone-picture-id1210216717?k=20&m=1210216717&s=612x612&w=0&h=T3_LH_IwOkeW9FLwjbZlMb1YvC1HwqA9XwKoJcl43uQ=")
        var contact4 = Contact("Zuu", "0777444014", "zulekhasham1999@gmail.com", "BlueRoom","https://media.istockphoto.com/photos/beauty-portrait-of-african-american-girl-with-afro-hair-picture-id1336246945?b=1&k=20&m=1336246945&s=170667a&w=0&h=t00HvLpP4d-QWmAVaAKif5n3LPwXU4F3X78xvmdUsNs=")
        var contact5 = Contact("Ninah", "0777986468", "swabrayusuf1999@gmail.com", "BlueRoom","https://i.pinimg.com/736x/b2/e7/8d/b2e78dfb59113ecec80404a398e6aa15.jpg")
        var contact6 = Contact("Hakan", "0712345678", "hakanshamun1999@gmail.com", "BlueRoom","https://cdn.pixabay.com/photo/2015/06/22/08/40/child-817373__480.jpg")
        var contactList =
            listOf(contact1, contact2, contact3, contact4, contact5, contact6)
        var contactsAdapter = ContactsRvAdapter(contactList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactsAdapter

    }
}