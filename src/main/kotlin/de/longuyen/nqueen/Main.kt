package de.longuyen.nqueen

fun main(){
    val population = Population(200)
    population.fitAndSort()
    val before = System.currentTimeMillis()
    for(i in 0 until 1000){
        population.evolve()
        population.fitAndSort()
    }
    val after = System.currentTimeMillis()
    println("Genetic algorithm's fittest solution (${population.fittest().fitness}) after ${(after - before) / 1000} seconds:")
    println(population.fittest())
}