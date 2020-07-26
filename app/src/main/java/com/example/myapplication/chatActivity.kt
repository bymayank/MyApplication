package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat.*

class chatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        send.setOnClickListener {
            val msg:String= texts.text.toString()
            val email:String? = FirebaseAuth.getInstance().currentUser!!.email

            FirebaseDatabase.getInstance().reference.child( "messages")
                .push()
                .setValue(
                    Message(email!!,msg)
                )
        }
        val query = FirebaseDatabase.getInstance().reference.child("messages")
        val options=FirebaseL

    }
}
class Message(var email:String, var msg: String)
{
    constructor():this("","")
}