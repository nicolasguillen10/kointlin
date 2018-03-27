package com.nicolasguillen.kointlin.ui.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import com.nicolasguillen.kointlin.libs.util.addTo
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity<ViewModelType: Any> : AppCompatActivity(){

    private val disposables = CompositeDisposable()

    @Inject lateinit var viewModel: ViewModelType

    protected fun <I> Observable<I>.crashingSubscribe(onNext: (I) -> Unit) {
        subscribe(onNext, { throw OnErrorNotImplementedException(it) }).addTo(disposables)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}