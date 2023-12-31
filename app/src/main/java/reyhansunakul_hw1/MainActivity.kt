package reyhansunakul_hw1

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import com.example.myapplication.R
import com.example.reyhansunakul_hw1.R

class MainActivity : AppCompatActivity() {

    lateinit var tvResult: TextView
    var curentName = ""
    var curentSurname = ""
    lateinit var btnSave: Button
    lateinit var btnCancel: Button
    lateinit var etFirstName: EditText
    lateinit var etLastName: EditText
    lateinit var customDialog: Dialog
    lateinit var tvTile: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customDialog = Dialog(this)
        setContentView(R.layout.activity_main3)
        tvTile=findViewById(R.id.tvTitle)
        btnSave = customDialog!!.findViewById<Button>(R.id.btnSave)
        btnCancel = customDialog!!.findViewById<Button>(R.id.btnCancel)
        etFirstName = customDialog!!.findViewById<EditText>(R.id.etFirstname)


    }
}