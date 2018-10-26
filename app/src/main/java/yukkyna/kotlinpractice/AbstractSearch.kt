package yukkyna.kotlinpractice

import android.content.Context
import android.support.v4.content.AsyncTaskLoader

abstract class AbstractSearch<D>(context: Context) : AsyncTaskLoader<D>(context) {
    private var result: D? = null
    private var nowLoading: Boolean = false

    override fun onStartLoading() {
        super.onStartLoading()

        /* Activityが再起動した場合などにLoadが再度呼ばれることを防ぐ */
        if (result != null) {
            deliverResult(result)
            return
        }

        if (!nowLoading || takeContentChanged()) {
            forceLoad()
        }
    }

    override fun onForceLoad() {
        super.onForceLoad()
        nowLoading = true
    }

    override fun deliverResult(data: D?) {
        result = data
        super.deliverResult(data)
    }

}


