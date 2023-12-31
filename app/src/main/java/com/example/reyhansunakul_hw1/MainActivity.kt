package com.example.reyhansunakul_hw1

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
//import com.example.myapplication.R
//import com.example.myapplication.databinding.ActivityMainBinding
import com.example.reyhansunakul_hw1.databinding.ActivityMainBinding
import reyhansunakul_hw1.Customer

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var amountText: TextView
    lateinit var customDialog: Dialog
    lateinit var spinnerMovie: Spinner
    lateinit var imgMovie: ImageView
    lateinit var seatNumber: TextView
    lateinit var binding: ActivityMainBinding

    val c1 = Customer("E1")
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hiding title bar using code
        getSupportActionBar()?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Log cat usage to check my object's content and additionally array movies content
        val cities = resources.getStringArray(R.array.movieArray)
        Log.d("RESOURCE: ", "array movies : " + java.lang.String.join(",", *cities))

        val myList: MutableList<Customer> = mutableListOf()

        myList.add(c1)
        for (c1 in myList) {
            Log.d("LIST", "My Log D List: $c1")
        }

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        amountText= findViewById(R.id.amountText)
        spinnerMovie=findViewById(R.id.spinnerMovie)
        imgMovie=findViewById(R.id.imgMovie)
        seatNumber=findViewById(R.id.seatText)

        //Blink animation
        val animator = ObjectAnimator.ofInt(textView, "backgroundColor", Color.WHITE, Color.BLACK)

        // Set the duration of the animation
        animator.duration = 200

        // Set the number of repetitions of the animation
        animator.repeatCount = ValueAnimator.INFINITE

        // Start the animation
        animator.start()

        var secondActivityResultLauncher= registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()){ result->

            if(result.resultCode== RESULT_OK){
                val data = result.data
                val receivedData = data!!.getStringExtra("res")
                Toast.makeText(this@MainActivity, receivedData, Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity, "Warning, went to 1st page", Toast.LENGTH_SHORT).show()
            }
        }


        binding.button.setOnClickListener {
            //sending intent item and object to another activity which is Activitymain2Activity
            val switchActivityIntent: Intent
            switchActivityIntent = Intent(this@MainActivity, Activitymain2Activity::class.java)
            val num1 = amountText.text.toString().toInt()

            val b = Bundle()
            b.putInt("num1", num1)
            b.putParcelable("c1",c1)

            switchActivityIntent.putExtras(b)
            secondActivityResultLauncher.launch(switchActivityIntent)
            intent.putExtras(b)
            startActivity(intent)
        }


        val imgIds = intArrayOf(R.drawable.caroline, R.drawable.toystory, R.drawable.incredibles)
        spinnerMovie.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, i: Int, id: Long) {
                imgMovie.setImageResource(imgIds[i]) }
            override fun onNothingSelected(parent: AdapterView<*>?) {} })


      /* button.setOnClickListener {
            val switchActivityIntent: Intent
            switchActivityIntent = Intent(this@MainActivity, Activitymain2Activity::class.java)
            activityResultLauncher.launch(switchActivityIntent) } */



    }

   }