package de.longuyen.shapespearemonkey

fun main(){
    val target = "God saves the Queen"
    val pop = Population(target = target)
    pop.fitAndSort()
    var generation = 0
    while(pop.chromosomes.first().fitness < target.length){
        pop.evolve()
        pop.fitAndSort()
        println("Generation $generation with a fitness of ${pop.chromosomes.first().fitness} and best result ${pop.chromosomes.first().geneExpression()}")
        generation++
    }
}