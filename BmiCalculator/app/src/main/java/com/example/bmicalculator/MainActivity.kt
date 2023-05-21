package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var button:Button? = null
    private var wEditText:EditText? = null
    private var editText:EditText? = null
    private var textView:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       button = findViewById<Button>(R.id.result_button)
        editText = findViewById<EditText>(R.id.height_editText)
        wEditText = findViewById<EditText>(R.id.weight_editText)
        textView = findViewById<TextView>(R.id.result_text)
        button?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val height= editText?.text.toString()
                val weight= wEditText?.text.toString()
                var check:Boolean = checkCredential(height,weight)
                if(!check){
                  Toast.makeText(this@MainActivity,"please enter both height and weight",Toast.LENGTH_SHORT).show()
                }
                else{
                    editText?.text?.clear()
                    wEditText?.text?.clear()
                    val htoInt = height.toDouble()
                    val wtoInt = weight.toDouble()
                    val bmi = wtoInt.div(htoInt*htoInt)
                    if(bmi>25)textView?.text = "you're overWeight"
                    else if(bmi<18) textView?.text = "you're underWeight"
                    else textView?.text = "you're healthy"
                }
            }
        })
    }

    private fun checkCredential(height:String,weight:String): Boolean {
        return !(height.isEmpty() || weight.isEmpty())
    }
}