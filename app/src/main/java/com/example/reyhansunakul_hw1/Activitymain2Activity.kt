package com.example.reyhansunakul_hw1

import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
//import com.example.myapplication.R
//import com.example.myapplication.databinding.Activitymain2Binding
import com.example.reyhansunakul_hw1.databinding.Activitymain2Binding
import reyhansunakul_hw1.Customer

class Activitymain2Activity : AppCompatActivity() {
    lateinit var btnClose: Button
    lateinit var feeTextView: TextView
    lateinit var intent2: Intent
    lateinit var seekBarRate: SeekBar
    lateinit var rateShowTV: TextView
    lateinit var btnOpenDialog: Button
    lateinit var customDialog: Dialog
    lateinit var binding: Activitymain2Binding

    lateinit var tvResult: TextView
    var curentName = ""
    lateinit var btnSave: Button
    lateinit var btnCancel: Button
    lateinit var etFirstName: EditText



    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activitymain2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        getSupportActionBar()?.hide();

        @Suppress("DEPRECATION")
        //setContentView(R.layout.activitymain2)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) //enable full screen, can be called before or after
        feeTextView = findViewById(R.id.feeTextView)
        btnClose = findViewById(R.id.closeButton)
        seekBarRate=findViewById(R.id.seekBarRate)
        rateShowTV=findViewById(R.id.rateShowTV)
        btnOpenDialog = findViewById<Button>(R.id.btnOpenDialog)

        intent2 = getIntent()
        val b = intent2.getExtras()
        val c1 = intent.getParcelableExtra("c1", Customer::class.java)

        val num1 = b!!.getInt("num1")
        val num2 = 50
        val res = ((num1 * num2))

        binding.feeTextView.setText("Amount to be paid: $res and ${c1.toString()}" )


        seekBarRate.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged( seekBarRate: SeekBar, progress: Int, fromUser: Boolean ) {
                rateShowTV.text=("This is how much you're excited $progress . Thanks for feedback!") } // end method onProgressChanged
                override fun onStartTrackingTouch(seekBarRate: SeekBar) {} // end method
                override fun onStopTrackingTouch(seekBarRate: SeekBar) { // To Obtain SeekBar progress value //
                seekBarRate.getProgress(); } })


        //setContentView(view)

       // Create an AlertDialog builder with ticket fee calculation.
        val builder = AlertDialog.Builder(this)

        // Set the title and message of the dialog.
        builder.setTitle("Fee")
        builder.setMessage("Amount to be paid: $res")

        // Set the buttons of the dialog.
        builder.setPositiveButton("OK", null)

        btnClose.setOnClickListener(View.OnClickListener { finish() })
        builder.show()

        btnOpenDialog.setOnClickListener{
            customDialog!!.show()
        }
        createDailog()
    }

    fun createDailog() {
        customDialog = Dialog(this)
        customDialog.setContentView(R.layout.activity_main3)

        btnSave = customDialog!!.findViewById<Button>(R.id.btnSave)
        btnCancel = customDialog!!.findViewById<Button>(R.id.btnCancel)
        etFirstName = customDialog!!.findViewById<EditText>(R.id.etFirstname)
        tvResult=customDialog!!.findViewById(R.id.tvTitle)

        btnSave.setOnClickListener(View.OnClickListener {
            curentName = etFirstName.getText().toString()
            tvResult!!.text = "Your Name is $curentName"
           customDialog!!.dismiss() //
           // customDialog.hide();
            //if it is too expensive to create it, call hide() otherwise call dismiss()
            //if you hide and and call the finish() method for the activity, this may cause problem.
            //if you hide a dialog before finish() method call dismiss() method for the dialog
        })
        btnCancel.setOnClickListener(View.OnClickListener { //customDialog.hide();
            customDialog!!.dismiss()
        })
    }
}