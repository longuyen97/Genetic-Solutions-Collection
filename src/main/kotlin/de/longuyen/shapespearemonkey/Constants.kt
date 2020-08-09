package de.longuyen.shapespearemonkey

val ALPHABET = {
    val ret = mutableListOf<Char>()
    for(i in 'a'.toInt()..'z'.toInt()){
        ret.add(i.toChar())
    }
    for(i in 'A'.toInt()..'Z'.toInt()){
        ret.add(i.toChar())
    }
    ret.add(' ')
    ret.add(',')
    ret.add('.')
    ret.toCharArray()
}()

