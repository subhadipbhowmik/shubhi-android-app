package com.example.shubhadipbhowmik

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import nl.joery.animatedbottombar.AnimatedBottomBar

private val aboutFragment = AboutFragment()
private val skillFragment = SkillFragment()
private val experienceFragment = ExperienceFragment()
private val projectFragment = ProjectFragment()
private val educationFragment = EducationFragment()

class MainActivity : AppCompatActivity() {
    private lateinit var bottomBar: AnimatedBottomBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar = findViewById(R.id.bottom_bar)
        replaceFragment(AboutFragment())

        bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
              when(newIndex){
                  0->replaceFragment(aboutFragment)
                  1->replaceFragment(skillFragment)
                  2->replaceFragment(experienceFragment)
                  3->replaceFragment(projectFragment)
                  4->replaceFragment(educationFragment)

                  else->{
                      replaceFragment(AboutFragment())
                  }
              }
            }

        })
    }


    // replace fragments function
    private fun replaceFragment(fragment : Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }
}