package com.fahstats.core.worker.observer

interface Observable<T> {
    val observers: MutableList<Observer<T>>

    fun addObserver(vararg obs: Observer<T>) {
        observers.addAll(obs)
    }

    fun updateObservers(t: T) {
        observers.forEach { it.update(t) }
    }

}