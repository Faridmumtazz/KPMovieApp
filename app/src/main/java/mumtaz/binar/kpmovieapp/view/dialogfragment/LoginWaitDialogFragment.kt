package mumtaz.binar.kpmovieapp.view.dialogfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import mumtaz.binar.kpmovieapp.R
import mumtaz.binar.kpmovieapp.databinding.FragmentLoginWaitDialogBinding
import mumtaz.binar.kpmovieapp.viewmodel.UserApiViewModel


class LoginWaitDialogFragment : DialogFragment() {

    private var _binding : FragmentLoginWaitDialogBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserApiViewModel by hiltNavGraphViewModels(R.id.nav_main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginWaitDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginStatus.postValue(false)

        viewModel.loginStatus.observe(viewLifecycleOwner){
            if (it){
                dialog?.dismiss()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}