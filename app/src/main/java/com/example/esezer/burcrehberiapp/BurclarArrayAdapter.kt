package com.example.esezer.burcrehberiapp

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*
import org.w3c.dom.Text

//kendi sınıfımızı oluşturduk.
class BurclarArrayAdapter(
    var gelenContext: Context,
    resource: Int,
    textViewResourceId: Int,
    var burcAdlari: Array<String>,
    var burcTarihleri: Array<String>,
    var burcResimleri: Array<Int>
) :
    ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdlari) {

    //liste elemanları oluşturulurken sürekli olarak tetiklenir. Bunu yapan method ise getviewdir.
    //convertview : oluşturduğumuz viewları tekrar tekrar kullanmamızı sağlar
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var tek_satir_view = convertView

        var viewHolder:ViewHolder?=null



//uygulama ilk açılıdığında bütün elemanları inflate edilmesidir.
        if (tek_satir_view == null) {
            //parametre olarak değişkenimiz tanımadı o yüzden değişken olarak atadık. Bütün sınıf boyunca değişken olarak tnaımladık.
            val inflater = LayoutInflater.from(gelenContext)
            //parent listview özelliğini al genişlik gibi. özellikerlini al
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)
            viewHolder=ViewHolder(tek_satir_view)
            tek_satir_view.tag=viewHolder
            Log.e("elif", "Inflation yapıldı : " + burcAdlari[position])
        }
        else{

          //  viewHolder=ViewHolder(tek_satir_view)
            //var olanı bir daha çağırdık. bu şekilde tekrar üretmedik.
            viewHolder=tek_satir_view.getTag() as ViewHolder
        }




//position o an olutşrulan satırın position degeri

        viewHolder.burcadi.setText(burcAdlari[position])
        viewHolder.burcTarihleri.setText(burcTarihleri[position])
        viewHolder.burcResim.setImageResource(burcResimleri[position])

        Log.e("TEST", "" + parent.toString())
        Log.e("TEST", "" + parent)

        return tek_satir_view
    }

    class ViewHolder(tek_satir_view:View)
    {
        var burcResim:ImageView
        var burcadi:TextView
        var burcTarihleri:TextView

        init{
            this.burcResim=tek_satir_view.imgBurcSembol
            this.burcadi=tek_satir_view.tvBurcAdi
            this.burcTarihleri=tek_satir_view.tvBurcTarih
        }
    }
}