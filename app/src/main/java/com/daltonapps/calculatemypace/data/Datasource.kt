package com.daltonapps.calculatemypace.data

import android.content.Context
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore

class Datasource {

    fun getAll(context: Context, listener: OnSuccessListener<QuerySnapshot>) {
        FirebaseApp.initializeApp(context)
        val db = Firebase.firestore

        db.collection("activities").get().addOnSuccessListener(listener)
    }
}