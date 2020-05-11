package com.portales.lab4plataformas.invitados

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.portales.lab4plataformas.MainActivity
import com.portales.lab4plataformas.R
import kotlinx.android.synthetic.main.fragment_resultado.view.*
import kotlinx.android.synthetic.main.fragment_resultado.view.txt2

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultadoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var texto = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.compartir_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opShare -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, texto)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista = inflater.inflate(R.layout.fragment_resultado, container, false)

        for (n in (activity as MainActivity).lista){
            var invitado = if (n.invitado) "Si" else "No"
            texto += n.nombre + ":"+ invitado + ",  "
        }


        vista.txt1.setText("Invitados: "+(activity as MainActivity).lista.size.toString())
        var cant = 0
        for (n in (activity as MainActivity).lista){
            if (n.invitado){
                cant++
            }
        }
        vista.txt2.setText("Registrados: " + cant.toString())

        vista.btnREcinciar.setOnClickListener {
            (activity as MainActivity).iniciar()
        }

        vista.btnResiltados.setOnClickListener {
            Toast.makeText(activity,texto,Toast.LENGTH_LONG).show()
        }



        return vista
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultadoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultadoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
