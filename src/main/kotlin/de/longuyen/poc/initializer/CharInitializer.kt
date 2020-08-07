package de.longuyen.poc.initializer

import de.longuyen.poc.chromosome.CharChromosome
import java.lang.StringBuilder
import java.util.*

const val ALPHABET = "abcdefghijklmnopqrstuvwxyz "

class CharInitializer(private val target: String) : IIinitializer<CharChromosome> {
    override fun generate(): CharChromosome {
        val random = Random()
        val stringBuilder = StringBuilder()
        for(i in target.indices){
            stringBuilder.append(ALPHABET[random.nextInt(ALPHABET.length)])
        }
        return CharChromosome(stringBuilder.toString().toCharArray())
    }

}