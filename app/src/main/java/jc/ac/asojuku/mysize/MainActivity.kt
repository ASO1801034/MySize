package jc.ac.asojuku.mysize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //再表示のたびに呼ばれるライフサイクルイベントのコールバックメソッド
    override fun onResume() {
        super.onResume()
        //入力値を端末内に保存
        //共有プリファレンスのインスタンスを取得
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        //共有プリファレンスのインスタンスから４つの保存済みの値を取り出す
        val editNeck = pref.getString("NECK", "");//取得した首回りの値で表示を更新
        val editSleeve = pref.getString("SLEEVE", "");//取得した裄丈の値で表示を更新
        val editWaist = pref.getString("WAIST", "");//取得した胴回りの値で表示を更新
        val editInseam = pref.getString("INSEAM", "");//取得した股下の値で表示を更新
        //取得した保存地で各入力欄の表示を上書きする
        neck.setText(editNeck);
        sleeve.setText(editSleeve);
        waist.setText(editWaist);
        inseam.setText(editInseam);
        //保存ボタンが押された時の処理を設定
        save.setOnClickListener{onSaveTapped()};

        //身長アイコンのボタンクリック時の画面遷移
        heightButton.setOnClickListener{
            //クリックされた時にOSが呼び出す処理を実装
            //インテントを定義(どこからどこまで情報)
            val intent = Intent(this,HeightActivity::class.java);
            //画面遷移メソッド(startActivity)を実行
            this.startActivity(intent);
        }
    }
        //保存ボタンが押されたらOSがコールバックする処理
        private fun onSaveTapped(){
            //画面表示の値を共有プリファレンスに保存する
            //共有プリファレンスのインスタンスを取得
            val pref = PreferenceManager.getDefaultSharedPreferences(this);
        //共有プリファレンスを更新(editメソッド)
            pref.edit{//ラムだ式でインスタンスに対して引継ぎアよりを実行
            this.putString("NECK",neck.text.toString());
            this.putString("SLEEVE",sleeve.text.toString());//裄丈の入力値を保存
            this.putString("WAIST",waist.text.toString());//胴回りの入力値を保存
            this.putString("INSEAM",inseam.text.toString());//股下の入力値を保存
        }
    }
}
