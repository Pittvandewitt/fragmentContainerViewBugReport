package com.example.fragmentcontainerview.fragment

import android.os.Bundle
import androidx.annotation.Keep
import androidx.preference.DialogPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.fragmentcontainerview.R

@Keep
class MainFragment : PreferenceFragmentCompat() {
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
        setPreferencesFromResource(R.xml.preference_main, rootKey)
    }

    /**
     * Called when a preference in the tree requests to display a dialog. Subclasses should
     * override this method to display custom dialogs or to handle dialogs for custom preference
     * classes.
     *
     * @param preference The [Preference] object requesting the dialog
     */
    override fun onDisplayPreferenceDialog(preference: Preference?) {
        when (preference) {
            is DialogPreference -> DialogFragment()
                .apply { arguments = Bundle().apply { putString(argKey, preference.key) } }
                .also { it.setTargetFragment(this, 0) }
                .also { it.show(parentFragmentManager, null) }
            else -> super.onDisplayPreferenceDialog(preference)
        }
    }
}