package mobi.porquenao.poc.kotlin

import android.app.Application

import com.raizlabs.android.dbflow.config.FlowManager

public class DatabaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FlowManager.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        FlowManager.destroy()
    }

}
