package com.nutchanok.nat.bankapplication.manager

import com.nutchanok.nat.bankapplication.constant.PaperKey
import com.nutchanok.nat.bankapplication.model.UIContentModel
import io.paperdb.Paper

class AppManager {

    companion object {

        /*ui contents*/
        fun saveUIContents(list: List<UIContentModel>?) {
//            Paper.book().write(PaperKey.UI_CONTENT, list)
        }

        fun getUIContents(): List<UIContentModel>? {
            return Paper.book().read(PaperKey.UI_CONTENT)
        }
    }

}