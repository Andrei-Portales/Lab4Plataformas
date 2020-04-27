package com.portales.lab4plataformas.ui.slideshow

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.portales.lab4plataformas.MainActivity
import com.portales.lab4plataformas.PersonaInfoBiding
import com.portales.lab4plataformas.R
import com.portales.lab4plataformas.databinding.FragmentSlideshowBinding
import kotlinx.android.synthetic.main.fragment_slideshow.view.*

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private lateinit var binding: FragmentSlideshowBinding

    private var pos = 0
    private lateinit var root:View

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_elegir,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.opcorrect -> {
                (activity as MainActivity).lista.get(pos).invitado = true
                pos++
                if (pos <=  (activity as MainActivity).lista.size - 1) {
                    root.txtNombre.text =  (activity as MainActivity).lista.get(pos).nombre
                    root.txtTel.text =  (activity as MainActivity).lista.get(pos).tel
                    root.txtCorreo.text =  (activity as MainActivity).lista.get(pos).correo
                    (activity as MainActivity).changeTitle("Registrando (" + (pos + 1).toString() + "/"+ (activity as MainActivity).lista.size.toString()+")")
                }else{
                    (activity as MainActivity).resultados()
                }

            }
            R.id.opwrong -> {
                (activity as MainActivity).lista.get(pos).invitado = false
                pos++
                if (pos <=  (activity as MainActivity).lista.size - 1) {
                    root.txtNombre.text =  (activity as MainActivity).lista.get(pos).nombre
                    root.txtTel.text =  (activity as MainActivity).lista.get(pos).tel
                    root.txtCorreo.text =  (activity as MainActivity).lista.get(pos).correo
                    (activity as MainActivity).changeTitle("Registrando (" + (pos + 1).toString() + "/"+ (activity as MainActivity).lista.size.toString()+")")
                }else{
                    (activity as MainActivity).resultados()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        (activity as MainActivity).lista = listOf<PersonaInfoBiding>(
            PersonaInfoBiding("Andrei Portales","505569551","andrei@gmail.com",false),
            PersonaInfoBiding("Hansel Lopez","78945612","hansel@gmail.com",false),
            PersonaInfoBiding("Juan Marco","78451296","juan@gmail.com",false),
            PersonaInfoBiding("Pedro","98725416","pedro@gmail.com",false),
            PersonaInfoBiding("Jorge Martinez","79461305","jorge@gmail.com",false),
            PersonaInfoBiding("Maria","12312312","maria@gmail.com",false),
            PersonaInfoBiding("Augusto","97645212","augusto@gmail.com",false),
            PersonaInfoBiding("Saytha","42031568","saytha@gmail.com",false),
            PersonaInfoBiding("Marcos","78787456","marcos@gmail.com",false),
            PersonaInfoBiding("Francisco","55664455","francisco@gmail.com",false)
        )

        root.txtNombre.text =  (activity as MainActivity).lista.get(pos).nombre
        root.txtTel.text =  (activity as MainActivity).lista.get(pos).tel
        root.txtCorreo.text =  (activity as MainActivity).lista.get(pos).correo
        (activity as MainActivity).changeTitle("Registrando (" + (pos + 1).toString() + "/"+  (activity as MainActivity).lista.size.toString()+")")

        return root
    }
}
