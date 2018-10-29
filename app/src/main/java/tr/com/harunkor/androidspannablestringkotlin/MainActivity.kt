package tr.com.harunkor.androidspannablestringkotlin

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var txtspannable : TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtspannable= findViewById(R.id.spantxt)


        val str:String = "There are two ways to live: you can live as if nothing is a miracle; you can live as if everything is a miracle. CLICK harunkor”"

        val spannableString = SpannableString(str)
        spannableString.setSpan(StrikethroughSpan(),0,5,0)
        spannableString.setSpan(StyleSpan(Typeface.BOLD),6,13,0)
        spannableString.setSpan(UnderlineSpan(),14,18,0)
        spannableString.setSpan(StyleSpan(Typeface.ITALIC),18,25,0)
        spannableString.setSpan(ForegroundColorSpan(Color.WHITE),26,32,0)
        spannableString.setSpan(BackgroundColorSpan(Color.RED),27,32,0)
        spannableString.setSpan(RelativeSizeSpan(2f),36,40,0)
        spannableString.setSpan(SuperscriptSpan(),40,50,0)
        spannableString.setSpan(SubscriptSpan(),69,73,0)
        spannableString.setSpan(URLSpan("http://www.harunkor.com"),40,45,0)

        val clickableSpan = object : ClickableSpan()
        {
            override fun onClick(p0: View) {
                Toast.makeText(applicationContext," Clicked. ",Toast.LENGTH_LONG).show()

            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.setUnderlineText(true)

            }

        }

        spannableString.setSpan(clickableSpan,113,119,0)
        spannableString.setSpan(URLSpan("http://www.harunkor.com"),119,128,0)

        txtspannable!!.setText(spannableString)

        txtspannable!!.movementMethod =LinkMovementMethod.getInstance()







    }
}
