package studio.sketches.walkers

import processing.core.PApplet.map
import processing.core.PConstants.*
import studio.sketches.Sketch
import studio.sketches.starfield.Star

class LonelyWalkerSketch extends Sketch {
  implicit val sketch: Sketch = this

  val _width = 1024
  val _height = 1024
  val grid = new Grid(25, 25, _width, _height)
  var states = List(Walker(x = 0, y = 0, direction = 1, grid))

  override def settings(): Unit = {
    size(_width, _height)
  }

  override def setup(): Unit = {
    val walker = states.head
    grid.drawWalker(walker, color(0))
  }

  override def draw(): Unit = {
    val currentWalker = states.head
    val newWalker =
      currentWalker.walk()
        .orElse(currentWalker.turn())
        .getOrElse(currentWalker.block())

    grid.drawWalker(newWalker, color(0))

    if newWalker.isBlocked then
      sys.exit(255)
    else
      states = newWalker +: states
  }
}
