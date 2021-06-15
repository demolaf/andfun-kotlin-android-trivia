package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflating and returning the View with DataBindingUtil
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title, container, false)

        // Inside our lambda, use view.findNavController to get the
        // navigation controller for our Navigation Host Fragment. Then, use the navController to navigate using the titleFragment to gameFragment action
        /*binding.playButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_titleFragment_to_gameFragment)
        }*/

        // Navigation can create the onClick listener for us. We can replace the anonymous function with the Navigation.createNavigateOnClickListener cal
        binding.playButton.setOnClickListener(Navigation
                .createNavigateOnClickListener(TitleFragmentDirections.actionTitleFragmentToGameFragment()))

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView()
                .findNavController()) || super
                .onOptionsItemSelected(item)

    }





}