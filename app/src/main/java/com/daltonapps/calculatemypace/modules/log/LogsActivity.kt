package com.daltonapps.calculatemypace.modules.log

import android.app.Activity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.GridView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.daltonapps.calculatemypace.calculatemypace.R
import com.daltonapps.calculatemypace.data.Datasource
import com.daltonapps.calculatemypace.models.Run
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QuerySnapshot

class LogsActivity: Activity(), OnSuccessListener<QuerySnapshot> {

    @BindView(R.id.runs_recycler_view) lateinit var runsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_logs)
        ButterKnife.bind(this)

        Datasource().getAll(this, this)
    }

    override fun onSuccess(data: QuerySnapshot) {
        val runs = arrayListOf<Run>()

        for (run in data) {
            runs.add(Run(run.id,
                run.data["date"] as String,
                run.data["distance"] as Long,
                run.data["time"] as Long,
                run.data["avg_heart_rate"] as Long
            ))
        }

        runsRecyclerView.adapter = LogsAdapter(runs)
    }
}