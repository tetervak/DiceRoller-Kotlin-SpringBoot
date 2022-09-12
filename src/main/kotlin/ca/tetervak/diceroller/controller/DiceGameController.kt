package ca.tetervak.diceroller.controller

import ca.tetervak.diceroller.model.DiceGame
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
class DiceGameController {

    private val logger = LoggerFactory.getLogger(DiceGameController::class.java)

    @GetMapping(value = ["/", "/dice-game"])
    fun diceGame(
        @RequestParam(defaultValue = "3") numberOfDice: Int,
        @RequestParam(defaultValue = "false") isRolled: Boolean
    ): ModelAndView {

        logger.trace("diceGame() is called")

        return if (isRolled) {
            logger.debug("dice is rolled")
            val game = DiceGame(numberOfDice)
            game.roll()
            logger.debug("game.rollData = ${game.rollData}")
            ModelAndView("GameResult").apply {
                addObject("rollData", game.rollData)
            }
        } else {
            logger.debug("dice is not rolled")
            ModelAndView("GameStart")
        }
    }
}