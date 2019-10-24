
package cn.tklvyou.update_demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.vector.update_app.UpdateAppManager
import com.vector.update_app_kotlin.updateApp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTest.setOnClickListener {
            //kotlin 方式
//            updateApp().update(true,"9.0.1","http://huaiyuan.dashuiniu.com.cn/uploads/apk/huaiyuan.apk","体验有惊喜",false)

            //java 方式
            UpdateAppManager.Builder()
                //必须设置，当前Activity
                .setActivity(this)
                //设置点击升级后，消失对话框，默认点击升级后，对话框显示下载进度
                //.hideDialogOnDownloading()
                //设置头部，不设置显示默认的图片，设置图片后自动识别主色调，然后为按钮，进度条设置颜色
//                .setTopPic(R.mipmap.top_3)
                //为按钮，进度条设置颜色，默认从顶部图片自动识别。
                .setThemeColor(resources.getColor(R.color.colorAccent))
                //设置apk下砸路径，默认是在下载到sd卡下/Download/1.0.0/test.apk
                .setTargetPath(Environment.getExternalStorageDirectory().absolutePath)
                //设置appKey，默认从AndroidManifest.xml获取，如果，使用自定义参数，则此项无效
                //.setAppKey("ab55ce55Ac4bcP408cPb8c1Aaeac179c5f6f")
                //不显示通知栏进度条
                //.dismissNotificationProgress()
                //是否忽略版本
                //.showIgnoreVersion()
                .build()
                .update(true,"9.0.1","http://huaiyuan.dashuiniu.com.cn/uploads/apk/huaiyuan.apk","体验有惊喜",false)
        }


    }
}
