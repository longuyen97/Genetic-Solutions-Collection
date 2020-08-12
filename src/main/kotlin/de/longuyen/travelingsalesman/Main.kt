package de.longuyen.travelingsalesman

const val SANITY_CHECK = false

fun main(){
    val graph = CompleteGraph(30, 50, 100)
    val population = Population(100, graph)
    population.fitAndSort()
    val before = System.currentTimeMillis()
    println(graph)
    for(i in 0 until 10000){
        population.evolve()
        population.fitAndSort()
    }
    val after = System.currentTimeMillis()
    println("Genetic algorithm's solution after ${(after - before) / 1000} seconds: Shortest path ${population.fittest().fitness} - Longest path ${population.worst().fitness}")
}