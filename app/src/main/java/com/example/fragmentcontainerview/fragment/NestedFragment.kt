package com.example.fragmentcontainerview.fragment

import android.os.Bundle
import androidx.annotation.Keep
import androidx.preference.PreferenceFragmentCompat
import com.example.fragmentcontainerview.R

@Keep
class NestedFragment : PreferenceFragmentCompat() {
    /**
     * Called during [.onCreate] to supply the preferences for this fragment.
     * Subclasses are expected to call [.setPreferenceScreen] either
     * directly or via helper methods such as [.addPreferencesFromResource].
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state,
     * this is the state.
     * @param rootKey            If non-null, this preference fragment should be rooted at the
     * [PreferenceScreen] with this key.
     */
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference_nested, rootKey)
    }
}
