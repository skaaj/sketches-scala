package studio.sketches.sincircles

import processing.core.PApplet.map
import processing.core.PConstants.*
import studio.sketches.Sketch
import studio.sketches.starfield.Star

class SinCirclesSketch extends Sketch {
  val _width = 1024
  val _height = 768

  val margin = 25
  val areaSize = Math.min(_width, _height) - margin

  override def settings(): Unit = {
    size(_width, _height)
  }

  override def draw(): Unit = {
    println(frameRate)
    background(33)
    noStroke()
    fill(255)
    translate(width / 2, height / 2)
    circle(0, 0, areaSize)
    for n <- (75 to 175 by 25) do
      drawCircle(frameCount, n)
    rotate(-PI / 4f)
    for n <- (75 to 175 by 25) do
      drawCircle(frameCount, n)
  }

  def drawCircle(frame: Int, n: Int) = {
    fill(0, 255f / 8f)
    val max = areaSize * 0.9f
    ellipse(0, 0, max * Math.sin(frame / n.toDouble).toFloat, max * Math.cos(frame / n.toDouble).toFloat)
  }
}
