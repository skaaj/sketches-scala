package studio.sketches.random

import processing.core.PApplet.{dist, map}
import processing.core.PConstants.*
import studio.sketches.Sketch
import studio.sketches.starfield.Star

class PerlinSketch extends Sketch {
  override def settings(): Unit = {
    size(1024, 768)
    noLoop()
  }

  override def draw(): Unit = {
    background(0)
    val halfWidth = width / 2
    val maxDist = Math.sqrt(2 * halfWidth * halfWidth).toFloat

    for
      x <- (0 until width)
      y <- (0 until height)
    do
      val distToCenter = dist(x, y, halfWidth, halfWidth)
      val noiseStep = map(distToCenter, 0, maxDist, 0.005, 0.04)
      stroke(255 * noise(x * noiseStep, y * noiseStep))
      point(x, y)
  }
}
