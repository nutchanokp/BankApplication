package com.nutchanok.nat.bankapplication.model.mock

object FakeModel {

    fun getLoremMessage(): String =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

    fun getAvatar(): String {
        val temp = arrayListOf<String>()
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/female/1.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/female/2.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/female/3.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/female/4.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/female/5.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/1.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/2.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/3.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/4.png")
        temp.add("https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/5.png")
        temp.shuffle()
        return temp.first()
    }

    fun getCover(): String {
        val temp = arrayListOf(
            "https://images.pexels.com/photos/1423658/pexels-photo-1423658.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/356171/pexels-photo-356171.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/176398/pexels-photo-176398.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/208701/pexels-photo-208701.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/6934/beach-vacation-water-summer.jpg?&h=750&w=1260",
            "https://images.pexels.com/photos/449627/pexels-photo-449627.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/590029/pexels-photo-590029.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/59520/pexels-photo-59520.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/372098/pexels-photo-372098.jpeg",
            "https://images.pexels.com/photos/236171/pexels-photo-236171.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/6496/man-person-jumping-desert.jpg?&h=750&w=1260",
            "https://images.pexels.com/photos/60219/pexels-photo-60219.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/6557/sea-man-person-holiday.jpg?&h=750&w=1260",
            "https://images.pexels.com/photos/386009/pexels-photo-386009.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/895254/pexels-photo-895254.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/208213/pexels-photo-208213.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/248771/pexels-photo-248771.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/208701/pexels-photo-208701.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/248759/pexels-photo-248759.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1007657/pexels-photo-1007657.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/842155/pexels-photo-842155.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/930676/pexels-photo-930676.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/132037/pexels-photo-132037.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/462044/pexels-photo-462044.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/163872/italy-cala-gonone-air-sky-163872.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/302549/pexels-photo-302549.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1079033/pexels-photo-1079033.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1488017/pexels-photo-1488017.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/354103/pexels-photo-354103.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/723997/pexels-photo-723997.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/416676/pexels-photo-416676.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/221395/pexels-photo-221395.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/99551/hot-air-balloon-valley-sky-99551.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/390051/surfer-wave-sunset-the-indian-ocean-390051.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/699558/pexels-photo-699558.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/307008/pexels-photo-307008.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/36372/pexels-photo.jpg?&h=750&w=1260",
            "https://images.pexels.com/photos/746386/pexels-photo-746386.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/772665/pexels-photo-772665.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1376960/pexels-photo-1376960.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/997462/pexels-photo-997462.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1039302/pexels-photo-1039302.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/994605/pexels-photo-994605.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/235615/pexels-photo-235615.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/589840/pexels-photo-589840.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/7976/pexels-photo.jpg?&h=750&w=1260",
            "https://images.pexels.com/photos/441379/pexels-photo-441379.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1033729/pexels-photo-1033729.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/733047/pexels-photo-733047.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/460376/pexels-photo-460376.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/721169/pexels-photo-721169.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/460223/pexels-photo-460223.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1360255/pexels-photo-1360255.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/304694/pexels-photo-304694.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/601175/pexels-photo-601175.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/962930/pexels-photo-962930.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/402028/pexels-photo-402028.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/347145/pexels-photo-347145.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/1191375/pexels-photo-1191375.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/771079/pexels-photo-771079.jpeg?&h=750&w=1260",
            "https://images.pexels.com/photos/891252/pexels-photo-891252.jpeg?&h=750&w=1260"
        )
        temp.shuffle()
        return temp.first()
    }

    fun getCovers(count: Int = 6): MutableList<String> {
        val temp = mutableListOf<String>()
        for (i in 1..count) {
            temp.add(getCover())
        }
        return temp
    }

    fun getRandomPicture(): String {
        val temp = arrayListOf<String>()
        temp.add("https://images.unsplash.com/photo-1534528741775-53994a69daeb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8cG9ydHJhaXR8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1557053910-d9eadeed1c58?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8d29tYW4lMjBwb3J0cmFpdHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1555320818-21ebf0faf145?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTN8fHBvcnRyYWl0c3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTl8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1544005313-94ddf0286df2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cG9ydHJhaXR8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1596215143922-eedeaba0d91c?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzZ8fGh1bWFufGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1558507652-2d9626c4e67a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cG9ydHJhaXRzfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1606143412458-acc5f86de897?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cG9ydHJhaXQlMjBwaG90b2dyYXBoeXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjN8fHBvcnRyYWl0fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1554151228-14d9def656e4?ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8cG9ydHJhaXR8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1531123897727-8f129e1688ce?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8cG9ydHJhaXR8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
        temp.add("https://images.unsplash.com/photo-1611670100179-6bd505085301?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fHBvcnRyYWl0JTIwcGhvdG9ncmFwaHl8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")
        temp.shuffle()
        return temp.first()
    }

    fun getRandomPictures(count: Int = 6): MutableList<String> {
        val temp = mutableListOf<String>()
        for (i in 1..count) {
            temp.add(getRandomPicture())
        }
        return temp
    }

    fun getVideo(): String {
        val temp = arrayListOf(
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
        )
        temp.shuffle()
        return temp.first()
    }
}