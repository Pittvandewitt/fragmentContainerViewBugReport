package com.example.fragmentcontainerview.preference

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.commit
import androidx.preference.DialogPreference
import androidx.preference.PreferenceDialogFragmentCompat
import com.example.fragmentcontainerview.R

class CustomDialogPreference(context: Context?, attrs: AttributeSet?) :
    DialogPreference(context, attrs) {

    init {
        dialogLayoutResource = R.layout.layout_with_fragment
    }

    class DialogFragment : PreferenceDialogFragmentCompat() {

        companion object {
            fun newInstance(key: String) = DialogFragment().apply {
                arguments = Bundle(1).apply { putString(ARG_KEY, key) }
            }
        }

        override fun onDialogClosed(positiveResult: Boolean) {
            // Workaround to remove the nested fragment manually
            parentFragmentManager.run {
                commit(allowStateLoss = true) { remove(findFragmentById(R.id.nested_fragment)!!) }
            }
        }
    }
}