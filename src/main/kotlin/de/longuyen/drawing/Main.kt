package de.longuyen.drawing


fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        PopulationBasedGeneticDraw(args[0]).run()
    } else {
        PopulationBasedGeneticDraw("images/raupy.png").run()
    }
}