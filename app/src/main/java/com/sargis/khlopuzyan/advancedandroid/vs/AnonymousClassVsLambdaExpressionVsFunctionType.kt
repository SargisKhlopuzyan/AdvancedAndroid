package com.sargis.khlopuzyan.advancedandroid.vs

//TODO-URL (anonymous class vs lambda expression in kotlin) : https://www.google.com/search?q=anonymous+class+vs+lambda+expression+in+kotlin&sca_esv=8c582dbeba8eac0c&sxsrf=AE3TifN3xgi09XMCY7UJi_Dn0ZQFsclkAQ%3A1751628314455&ei=GrpnaMLBG7uP7NYP_ombGA&ved=0ahUKEwjCttj7i6OOAxW7B9sEHf7EBgMQ4dUDCBA&uact=5&oq=anonymous+class+vs+lambda+expression+in+kotlin&gs_lp=Egxnd3Mtd2l6LXNlcnAiLmFub255bW91cyBjbGFzcyB2cyBsYW1iZGEgZXhwcmVzc2lvbiBpbiBrb3RsaW4yBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEdIjwRQ-wFY-wFwAXgCkAEAmAEAoAEAqgEAuAEDyAEA-AEBmAICoAIJwgIKEAAYsAMY1gQYR5gDAOIDBRIBMSBAiAYBkAYIkgcBMqAHALIHALgHAMIHAzItMsgHBw&sclient=gws-wiz-serp
//TODO-URL (function type vs lambda type in kotlin) : https://www.google.com/search?q=function+type+vs+lambda+type+in+kotlin&sca_esv=63773c6ec55f374f&sxsrf=AE3TifMdh6bUG2FCN_nsLgI30MwC7-V9sA%3A1751629908301&ei=VMBnaOGVEsqOxc8P-7Sl8QQ&oq=function+type+vs+lambda&gs_lp=Egxnd3Mtd2l6LXNlcnAiF2Z1bmN0aW9uIHR5cGUgdnMgbGFtYmRhKgIIADIFECEYoAEyBRAhGKABMgUQIRigATIFECEYoAEyBRAhGJ8FMgUQIRifBTIFECEYnwUyBRAhGJ8FMgUQIRifBTIFECEYnwVIpztQ8RJY0jNwA3gBkAEAmAG1AaABnQuqAQMwLjm4AQPIAQD4AQGYAgygAuYLwgIKEAAYsAMY1gQYR8ICBhAAGBYYHsICCxAAGIAEGIYDGIoFwgIFEAAY7wXCAggQABiABBiiBMICBxAhGKABGAqYAwCIBgGQBgiSBwMzLjmgB-A-sgcDMC45uAfLC8IHBzAuNy40LjHIBz0&sclient=gws-wiz-serp

private fun main() {

    /*: anonymous object : CustomClass*/
    val anonymousClass = object : CustomClass() {

    }

    val lambda: (String, Int) -> Unit = { name: String, age: Int ->

    }

    val functionType: (String, Int) -> Unit = ::anyFunction

    functionType("", 25)

}

private open class CustomClass {

}

private fun anyFunction(name: String, age: Int) {

}