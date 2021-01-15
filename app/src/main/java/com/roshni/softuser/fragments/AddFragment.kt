package com.roshni.softuser.fragments

import android.location.Address
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.roshni.softuser.R
import com.roshni.softuser.Storage
import com.roshni.softuser.model.Student


class AddFragment : Fragment() {
    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnSave: Button
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private lateinit var etImageURL: EditText

    private var userImageURL = ""
    var res : Boolean = true
    private var gender = "Not Specified"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        etFullName = view.findViewById(R.id.etFullName)
        etAddress = view.findViewById(R.id.etAddress)
        etImageURL = view.findViewById(R.id.etImageURL)
        etAge = view.findViewById(R.id.etAge)
        btnSave = view.findViewById(R.id.btnSave)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)
        rbOthers = view.findViewById(R.id.rbOthers)
        btnSave = view.findViewById(R.id.btnSave)

        rbMale.setOnClickListener {
            gender = "male"
        }
        rbFemale.setOnClickListener {
            gender = "Female"
        }
        rbOthers.setOnClickListener {
            gender = "Others"
        }

        btnSave.setOnClickListener {
            if(validateInput()) {
                var fullname = etFullName.text.toString()
                var userImageURL = etImageURL.text.toString()
                var age = etAge.text.toString()
                var address = etAddress.text.toString()
                Storage().appendStudent(Student(fullname, userImageURL, age, address,))
                Toast.makeText(view?.context, "Student Added Sucessfully", Toast.LENGTH_LONG).show()
                etFullName.setText("")
                etImageURL.setText("")
                etAddress.setText("")
                etAge.setText("")
            }else{
                Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
    private fun validateInput(): Boolean {

        when {
            TextUtils.isEmpty(etFullName.text) -> {
                etFullName.error = "This field should not be empty"
                etFullName.requestFocus()
                var res = false
            }
            TextUtils.isEmpty(etImageURL.text) -> {
                etImageURL.error = "This field should not be empty"
                etImageURL.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "This field should not be empty"
                etAddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "This field should not be empty"
                etAge.requestFocus()
                res = false
            }
        }

        return res

    }
}