package com.cp.helloworldx.android.architect.jetpack.hilt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cp.helloworldx.R
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ServiceComponent
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    @Inject
    lateinit var hitInjectModel: HitInjectModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)

        findViewById<TextView>(R.id.message).text = "value" + hitInjectModel.time
    }
}


interface AnalyticsService {
    fun analyticsMethods(): Int
}


class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
    override fun analyticsMethods(): Int {
        return 4
    }


}


/*@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {
    @Binds
    abstract fun bindAnalyticsService(
            analyticsServiceImpl: AnalyticsServiceImpl
    ): AnalyticsService


}*/




@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule{

    @Provides
    fun provideAnalyticsService():AnalyticsService{
        return AnalyticsServiceImpl()
    }
}


