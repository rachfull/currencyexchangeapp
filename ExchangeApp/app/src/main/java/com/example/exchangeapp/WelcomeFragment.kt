package com.example.exchangeapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

private val HOME_CURR : String = "homeCurrency" //vals are immutable in Kotlin
private val TARGET_CURR : String = "wantCurrency"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    private var homeCurrency : String = "USD" //default value is USD
    private var wantCurrency : String = "nevernull" //must specify if a var can be null. I don't want this one to ever be null or the program won't work
 //   private var calcButton: Button? = null
  //  private var editHomeCurr : EditText? = null
  //  private var editWantCurr : EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            homeCurrency = it.getString(HOME_CURR).toString() //FIXME: WHY IS THE TOSTRING CALL NECESSARY??
            wantCurrency = it.getString(TARGET_CURR).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_welcome, container, false)
        var editHomeCurr : EditText = rootView.findViewById<EditText>(R.id.home_curr)
        var editWantCurr : EditText = rootView.findViewById(R.id.target_curr)
        val calcButton : Button = rootView.findViewById(R.id.calc_button)


    val watchButtons: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {
            calcButton.setEnabled(DataCache.getInstance().isAllWelcomeFieldsFill)
        }
        override fun afterTextChanged(editable: Editable) {}
    }
        calcButton.addTextChangedListener(watchButtons)
        
        return rootView
}
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WelcomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(homeCurr: String, targetCurr: String) =
            WelcomeFragment().apply {
                arguments = Bundle().apply {
                    putString(HOME_CURR, homeCurr)
                    putString(TARGET_CURR, targetCurr)
                }
            }
    }
}