/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.example.android.codelabs.navigation.databinding.HomeFragmentBinding

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //COMPLETED STEP 5 - Set an OnClickListener, using Navigation.createNavigateOnClickListener()
        val navOptions = navOptions{
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        binding.navigateDestinationButton.setOnClickListener {
            view.findNavController().navigate(R.id.flow_step_one_dest, null, navOptions)
        }

        //COMPLETED STEP 7.2 - Update the OnClickListener to navigate using an action
        binding.navigateActionButton.setOnClickListener{
            view.findNavController().navigate(HomeFragmentDirections.nextAction())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
