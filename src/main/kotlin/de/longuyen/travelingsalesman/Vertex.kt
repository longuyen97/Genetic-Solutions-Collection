package de.longuyen.travelingsalesman

import java.util.*
import java.util.concurrent.ThreadLocalRandom

data class Vertex(val name: String){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Vertex
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

data class Edge(val a: Vertex, val b: Vertex){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Edge

        if(a == other.b && b == other.a) return true
        if (a != other.a || b != other.b) return false
        return true
    }

    override fun hashCode(): Int {
        val aCode = a.hashCode()
        val bCode = b.hashCode()
        return aCode and bCode
    }
}

class CompleteGraph(val size: Int, min: Int, max: Int){
    val vertices: MutableList<Vertex> = mutableListOf()
    val distances: MutableMap<Edge, Int> = mutableMapOf()

    init {
        for(i in 0 until size){
            vertices.add(Vertex(UUID.randomUUID().toString()))
        }

        for(i in 0 until vertices.size){
            distances[Edge(vertices[i], vertices[i])] = 0
            for(j in i + 1 until vertices.size){
                val distance = ThreadLocalRandom.current().nextInt(min, max);
                distances[Edge(vertices[i], vertices[j])] = distance
                distances[Edge(vertices[j], vertices[i])] = distance
            }
        }
    }
}