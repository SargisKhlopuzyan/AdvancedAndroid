package com.sargis.khlopuzyan.advancedandroid.dataClass

data class DataClass(val x: Int): Interface1, Interface2, NormalClass()

/**
 * Error - Function 'fun component1(): Int' generated for the data class conflicts
 * with the supertype member 'fun component1(): String' defined in BaseDataClass
 * */
//data class DataClass2(val x: Int): Interface1, Interface2, BaseDataClass()

interface Interface1
interface Interface2

open class NormalClass
data class BaseDataClass(val y: String)