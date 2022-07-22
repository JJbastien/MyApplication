package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.view.FragmentImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inflateDisplayFragment()
    }

    private fun inflateDisplayFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentImage())
            .commit()
    }

    /*
    https://api-staging-ypidedhdqa-uc.a.run.app/
    public/images/paginate?
    cursorIndex=10&
    limit=10

Parameters:
cursorIndex: Int (starting index of batch in the array of images, should start with 0)
limit: Int (the maximum number of elements to return)

response:
imageURLs: [string] (array of image URLs to fetch. jpeg and png)
     */
}

/*
{"imageURLs":["https://i.imgur.com/QRnWxWv.png","https://i.imgur.com/0c9sGUg.jpeg",
"https://i.imgur.com/VhONytJ.jpeg","https://i.imgur.com/o5cNUee.jpeg",
"https://i.imgur.com/X8ubT5O.png","https://i.imgur.com/9f08xGm.jpeg",
"https://i.imgur.com/bVRClCr.jpeg","https://i.imgur.com/p41qf8n.jpeg","https://i.imgur.com/dhPpdQU.jpeg","https://i.imgur.com/gHeCCMc.jpeg"]}
 */