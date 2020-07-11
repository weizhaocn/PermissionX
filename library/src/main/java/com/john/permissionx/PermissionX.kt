package com.john.permissionx

import androidx.fragment.app.FragmentActivity

/**
 * Created by john_ on 2020/7/11.
 * Describe:
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permissions: String, callback: PermissionCallback){
        val fragmentmanager = activity.supportFragmentManager
        val existedFragment = fragmentmanager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentmanager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}