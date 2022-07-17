package studio.sketches.walkers

import studio.sketches.Sketch

class Grid(val width: Int, val height: Int, areaWidth: Float, areaHeight: Float)(implicit s: Sketch) {
  val cellWidth = areaWidth / width
  val cellHeight = areaHeight / height

  def drawWalker(walker: Walker, color: Int) = {
    s.noStroke()
    s.fill(color)
    s.rect(walker.x * cellWidth, walker.y * cellHeight, cellWidth, cellHeight)
  }
}
