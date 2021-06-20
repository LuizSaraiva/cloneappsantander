package com.example.appsantander.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appsantander.R
import com.example.appsantander.data.Cliente
import com.example.appsantander.data.Conta
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_main.*
import kotlinx.android.synthetic.main.header_nav.*
import kotlinx.android.synthetic.main.header_nav.view.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var headerMenu: ConstraintLayout

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_main)

        initComponets()


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.getConta().observe(this, Observer { conta ->

            setDataHome(conta)
            setDataHeaderMenu(conta)
        })
    }


    private fun initComponets() {
        toolbar = toolbarMain
        navigationView = rv_menu
        drawerLayout = drawerMain
        headerMenu = navigationView.getHeaderView(0) as ConstraintLayout

        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item_menu_home -> {
            }
            R.id.item_menu_confirm_abert -> {
            }
            R.id.item_menu_saldo_extrato -> {
            }
            R.id.item_menu_trans -> {
            }
            R.id.item_menu_card -> {
            }
            R.id.item_menu_sant_on -> {
            }
            R.id.item_menu_emprest -> {
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setDataHeaderMenu(conta: Conta) {

        with(headerMenu) {
            tv_header_nome.text = "${conta.cliente.nome}"
            tv_header_ag.text = "Ag ${conta.agencia}"
            tv_header_cc.text = "Cc ${conta.conta}"
        }
    }

    private fun setDataHome(conta: Conta) {
        tv_welcome.text = "Ola, ${conta.cliente.nome}"
        tv_ag.text = "Ag ${conta.agencia}"
        tv_conta.text = "Cc ${conta.conta}"
        tv_v_saldo.text = "R$ ${conta.saldo}"
        tv_v_limite.text = "R$ ${conta.limite}"

        val dig = conta.cartao.numero
        tv_cartao_final.text = "${dig.substring(dig.length - 4, dig.length)}"

    }

}