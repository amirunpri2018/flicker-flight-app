package id.djaka.flicker.ui.main

import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.djaka.flicker.R
import id.djaka.flicker.ui.HomeFragment
import id.djaka.mvpanddagger.base.BasePresenter

class MainPresenter(mainView: MainView) : BasePresenter<MainView>(mainView){
    private var homeFragment: Fragment? = null

    override fun onViewCreated() {
        super.onViewCreated()

        Log.e("TAG", "DOES IT OWRK ?")

        setNavigationSelectedListener()
    }

    private fun setNavigationSelectedListener(){
        val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if(homeFragment == null)
                        homeFragment = HomeFragment()
                    view.replaceFrame(homeFragment, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {

                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        view.setBottomNavigationBehaviour(navListener)
    }
}