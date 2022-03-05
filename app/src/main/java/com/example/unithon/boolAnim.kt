//package com.example.unithon
//
//import android.view.animation.Animation
//import android.view.animation.AnimationUtils
//
//class boolAnim {
//    private fun startScaleDownAnimation() {
//        var pagingStartAnim = AnimationUtils.loadAnimation(this, R.anim.scale_down_1_0_dur1000)
//        var pagingEndAnim = AnimationUtils.loadAnimation(this, R.anim.scale_up_reverse_0_1)
//        pagingEndAnim.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationRepeat(animation: Animation?) { }
//            override fun onAnimationEnd(animation: Animation?) {
//                binding.viewOpenedTopCover.visibility = View.VISIBLE
//                binding.ctOpendBottomCover.visibility = View.VISIBLE
//                binding.viewOpenedBack.visibility = View.VISIBLE binding.viewBookCenterLeft.visibility = View.VISIBLE
//            }
//            override fun onAnimationStart(animation: Animation?) { } })
//        pagingStartAnim.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationRepeat(animation: Animation?) { }
//            override fun onAnimationEnd(animation: Animation?) {
//                binding.page.startAnimation(pagingEndAnim)
//                binding.pageTop.setBackgroundResource(R.drawable.round_solid_white_border_d8d8d8)
//            }
//            override fun onAnimationStart(animation: Animation?) { } })
//        binding.page.startAnimation(pagingStartAnim)
//    }
//
//}