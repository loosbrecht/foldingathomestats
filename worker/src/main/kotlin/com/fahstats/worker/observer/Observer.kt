package com.fahstats.core.worker.observer

interface Observer<T> {

    fun update(t: T)
}