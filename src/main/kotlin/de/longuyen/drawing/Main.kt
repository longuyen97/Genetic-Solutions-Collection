package de.longuyen.drawing


fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        GUI(args[0]).run()
    } else {
        GUI("images/raupy.png").run()
    }
}