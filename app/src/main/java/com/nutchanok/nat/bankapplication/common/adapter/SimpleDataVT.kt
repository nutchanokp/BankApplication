package com.nutchanok.nat.bankapplication.common.adapter

class SimpleDataVT<T> : BaseItemViewType {

    var data: T? = null

    constructor(data: T) : super(SimpleViewType.TYPE_ITEM, false) {
        this.data = data
    }

    constructor() : super(SimpleViewType.TYPE_ITEM)

}