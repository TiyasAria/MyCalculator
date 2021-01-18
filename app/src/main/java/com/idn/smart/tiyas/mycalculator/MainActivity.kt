package com.idn.smart.tiyas.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //global variable (yang semua bisa diakses )
    private lateinit var btnCalculate:Button
    private lateinit var etLength:EditText
    private lateinit var etWidth:EditText
    private lateinit var etHeight:EditText
    private lateinit var tvResult:TextView
    //membuat kelas button yang diberi nama btnCalculate (harus camelcase),etLength dll
    // lateinit var fungsinya untuk memanggil inisial
    // kalau dalam inisial , kalau val pakainya lazy
    // kita menggunakan private untuk lebih private

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etLength = et_panjang
        etWidth = et_lebar
        etHeight = et_tinggi
        tvResult = tv_jawaban
        btnCalculate = btn_hitung
        btnCalculate.setOnClickListener(this)
        //return untuk ke konteks (fungsi dari this)
       //btn_hitung.setOnClickListener {ketika kita masih memanggil secara manual belum menerapkan OOP}
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.btn_hitung){
            //mengambil input user
            val inputLength = etLength.text.toString().trim()
            val inputWidth = etWidth.text.toString().trim()
            val inputHeight = etHeight.text.toString().trim()
            // menghitung dari si inputan
            // pertama membuat variable dengan val agar tetap, lalu panggil si class panjang,lebar dan tinggi
            // lalu semua class tsb masih berbentuk angka, sedangkan program hanya bisa menerima dlam bentuk text
            //.text (berfungsi untuk mengubah kedalam bentuk text), .string(untuk mengubah kedlam string)
            // lalu untuk .trim ()
            var isEmptyField = false
            //membuat variable jika kosong
            when {
                inputLength.isEmpty() -> {
                isEmptyField = true
                etLength.error = getString(R.string.txt_error)
                 }
                //
                inputWidth.isEmpty() -> {
                    isEmptyField = true
                    etWidth.error = getString(R.string.txt_error)
                }
                inputHeight.isEmpty() -> {
                    isEmptyField = true
                    etHeight.error = getString(R.string.txt_error)
                }
            }
            if (!isEmptyField){
                val result = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
                tvResult.text = result.toString()
            }
        }
    }
}