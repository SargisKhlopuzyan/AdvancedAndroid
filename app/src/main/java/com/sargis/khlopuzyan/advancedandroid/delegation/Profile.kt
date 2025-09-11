package com.sargis.khlopuzyan.advancedandroid.delegation

fun main() {
    val tomProfile = MyProfile()
    val myProfileC = MyProfileC(tomProfile)
    println(myProfileC.name) // Outputs: Tom
    println(myProfileC.age)  // Outputs: 26
}

interface BaseProfile {
}

interface Profile : BaseProfile {
    val name: String
}

class MyProfile : Profile {
    override val name: String = "Tom"
}

class MyProfileB : Profile {
    override val name: String = "Tom"
    val age = 26
}

/**
 * In the MyProfileC class, we delegate the implementation of the Profile interface
 * to an instance of another class, reducing redundancy:
 * */
class MyProfileC(profile: Profile) : Profile by profile {
    val age = 26
}