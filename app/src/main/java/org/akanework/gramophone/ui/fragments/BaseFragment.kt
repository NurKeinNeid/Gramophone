package org.akanework.gramophone.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.MaterialSharedAxis
import org.akanework.gramophone.MainActivity

abstract class BaseFragment : Fragment() {

	protected var waitForContainer = false // used by PlayerFragment, all other fragment sets false

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
		returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
		exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ true)
		reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, /* forward= */ false)
	}

	override fun onStart() {
		super.onStart()
		(requireActivity() as MainActivity).waitForContainer = waitForContainer
	}

	// https://github.com/material-components/material-components-android/issues/1984#issuecomment-1089710991
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val colorBackground = MaterialColors.getColor(view, android.R.attr.colorBackground)
		view.setBackgroundColor(colorBackground)
	}
}