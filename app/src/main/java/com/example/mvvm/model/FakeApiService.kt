package com.example.mvvm.model

import com.example.mvvm.model.domain.Wisdom
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class FakeApiService {

    private val wisdomList = listOf<Wisdom>(
        Wisdom("لا تعطنى سمكة ولكن علمنى كيف اصطادها" , "24-11-2000"),
        Wisdom("لا تبحث في الحياة عن السعادة بنفس المكان الذي فقدتها فيه" , "13-11-2011"),
        Wisdom("عامل الناس باخلاقك ليس باخلاقهم" , "5 -9 -2014"),
        Wisdom("وقتك محدود، لذا لا تضيعه في عيش حياة شخص آخر" , "17 -8 -1996")
    )

    fun getRandomWisdom():Wisdom{
        val wisdom = (Math.random() * wisdomList.size) .toInt()
        return wisdomList[wisdom]
    }


    fun getRxRandomWisdom() : Single<Wisdom> {
        val random = (Math.random() * wisdomList.size) .toInt()
        val wisdom = wisdomList[random]

        return Single.just(wisdom).delay(5000 , TimeUnit.MILLISECONDS)
    }
}