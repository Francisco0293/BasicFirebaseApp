package mx.edu.itm.link.basicfirebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference
/*
        myRef.child("ejemplo").child("1").setValue(Card("1","rojo","corazones"))
        myRef.child("ejemplo").child("2").setValue(Card("9","rojo","treboles"))
        myRef.child("ejemplo").child("3").setValue(Card("3","rojo","diamantes"))
        myRef.child("ejemplo").child("4").setValue(Card("5","negro","espadas"))
*/
        myRef.child("users").child("user_id:01").setValue(User("francisco","jacinto",29,"fco@ejemplo.com"))
        myRef.child("users").child("user_id:02").setValue(User("jonathan","gutierrez",24,"pantostado@ejemplo.com"))
        myRef.child("users").child("user_id:03").setValue(User("deni","martinez",23,"dkm@ejemplo.com"))

        myRef.child("ejemplo").child("4").get().addOnSuccessListener { response ->
            //TODO value
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse", "Error getting data", it)
        }
    }
}