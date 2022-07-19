package studio.sketches.random

import processing.core.PApplet.{dist, map, norm}
import processing.core.PConstants.*
import studio.sketches.Sketch
import studio.sketches.starfield.Star

class GaussianSketch extends Sketch {
  override def settings(): Unit = {
    size(1024, 1024)
  }

  override def setup(): Unit = {
    colorMode(HSB, 100)
    background(0)
  }

  override def draw(): Unit = {
    for i <- (0 until 50) do
      drawPoint(i / 10f)
  }

  private def drawPoint(size: Float): Unit = {
    val center = width / 2f
    val deviation = width / 8f
    val randX = clamp(scaledGaussian(center, deviation), 0, width);
    val randY = clamp(scaledGaussian(center, deviation), 0, width);
    val hue = 100 * norm(dist(center, center, randX, randY), 0, center);
    stroke(color(hue, 80, 80, 50));
    strokeWeight(size);
    point(randX, randY);
  }

  private def clamp(value: Float, min: Float, max: Float): Float =
    Math.max(min, Math.min(value, max))

  private def scaledGaussian(mean: Float, sd: Float): Float =
    (randomGaussian() * sd) + mean
}
