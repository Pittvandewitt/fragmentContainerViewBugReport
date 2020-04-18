package com.example.fragmentcontainerview.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceDialogFragmentCompat

class DialogFragment : PreferenceDialogFragmentCompat() {

    val argKey = ARG_KEY

    override fun onDialogClosed(positiveResult: Boolean) {}

    /*
     * Workaround starts here
     */
//    private lateinit var mView: View
//
//    override fun onCreateDialogView(context: Context?): View {
//        mView = super.onCreateDialogView(context)
//        return mView
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
//    ): View? = mView
}