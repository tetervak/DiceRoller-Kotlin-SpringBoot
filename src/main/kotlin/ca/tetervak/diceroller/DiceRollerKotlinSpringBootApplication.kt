package ca.tetervak.diceroller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiceRollerKotlinSpringBootApplication

fun main(args: Array<String>) {
    runApplication<DiceRollerKotlinSpringBootApplication>(*args)
}
